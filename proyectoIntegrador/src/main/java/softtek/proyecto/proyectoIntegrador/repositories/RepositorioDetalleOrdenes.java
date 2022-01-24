package softtek.proyecto.proyectoIntegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softtek.proyecto.proyectoIntegrador.entities.DetalleOrden;

public interface RepositorioDetalleOrdenes extends JpaRepository<DetalleOrden, Integer> {
}
