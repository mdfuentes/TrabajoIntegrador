package softtek.proyecto.proyectoIntegrador.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import softtek.proyecto.proyectoIntegrador.services.CustomUserDetailsService;
import softtek.proyecto.proyectoIntegrador.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CustomUserDetailsService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String autorizationHeader = request.getHeader("Authorization");
        String token = null;
        String usuario = null;
        if (autorizationHeader != null && autorizationHeader.startsWith("Bearer ")){
            token = autorizationHeader.substring(7);
            usuario = jwtUtil.extractUsername(token);
        }
        if ( usuario != null && SecurityContextHolder.getContext().getAuthentication() == null){
          UserDetails userDetails = service.loadUserByUsername(usuario);
          if (jwtUtil.validateToken(token, userDetails)){
              UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                      userDetails, null, userDetails.getAuthorities());
              usernamePasswordAuthenticationToken
                      .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

          }
        }
        filterChain.doFilter(request, response);
    }
}
