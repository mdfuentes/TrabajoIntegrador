package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.entities.Usuario;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioUsuarios;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private RepositorioUsuarios repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsuario(username);
        return new org.springframework.security.core.
                userdetails.User(usuario.getUsuario(), usuario.getContraseña(), new ArrayList<>());
    }
}
