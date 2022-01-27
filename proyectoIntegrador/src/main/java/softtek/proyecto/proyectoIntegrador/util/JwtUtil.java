package softtek.proyecto.proyectoIntegrador.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.DTO.UsuarioDTO;
import softtek.proyecto.proyectoIntegrador.entities.Usuario;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioUsuarios;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    @Autowired
    RepositorioUsuarios repositorioUsuarios;

    private String secret = "matias";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public UsuarioDTO generateToken(String username) {
        UsuarioDTO usuarioDTO;
        usuarioDTO = convertirUsuarioaDTO(repositorioUsuarios.findByUsuario(username));
        Map<String, Object> claims = new HashMap<>();
        String token = createToken(claims, username);
        usuarioDTO.setToken(token);
        return usuarioDTO;
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private UsuarioDTO convertirUsuarioaDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsuario(usuario.getUsuario());
        usuarioDTO.setApellido(usuario.getApellido());
        usuarioDTO.setNombre(usuario.getNombre());
        return usuarioDTO;
    }
}