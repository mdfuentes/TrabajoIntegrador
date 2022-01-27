package softtek.proyecto.proyectoIntegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softtek.proyecto.proyectoIntegrador.entities.Administrador;

public interface RepositorioAdministrador extends JpaRepository<Administrador, Integer> {
}
