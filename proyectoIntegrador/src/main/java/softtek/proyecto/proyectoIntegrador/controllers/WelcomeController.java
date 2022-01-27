package softtek.proyecto.proyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.DTO.UsuarioDTO;
import softtek.proyecto.proyectoIntegrador.entities.AuthRequest;
import softtek.proyecto.proyectoIntegrador.util.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
public class WelcomeController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
//a
    @GetMapping("/")
    public String welcome(){
        return "Welcome";
    }

    @PostMapping("/auth")
    public UsuarioDTO generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsuario(), authRequest.getContraseña())
            );
        } catch (Exception ex) {
            throw new Exception("nombre o contraseña invalidos");
        }
        return jwtUtil.generateToken(authRequest.getUsuario());
    }
}
