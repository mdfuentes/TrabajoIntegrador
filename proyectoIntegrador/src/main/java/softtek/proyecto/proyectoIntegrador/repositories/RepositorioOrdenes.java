package softtek.proyecto.proyectoIntegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softtek.proyecto.proyectoIntegrador.entities.Orden;

public interface RepositorioOrdenes extends JpaRepository<Orden, Integer> {
}
