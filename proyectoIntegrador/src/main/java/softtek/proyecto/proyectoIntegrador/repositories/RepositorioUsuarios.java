package softtek.proyecto.proyectoIntegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softtek.proyecto.proyectoIntegrador.entities.Usuario;

public interface RepositorioUsuarios extends JpaRepository<Usuario, Integer> {
    Usuario findByUsuario(String usuario);
}
