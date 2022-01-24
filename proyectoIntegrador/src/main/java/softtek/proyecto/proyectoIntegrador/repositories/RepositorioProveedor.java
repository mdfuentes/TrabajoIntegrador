package softtek.proyecto.proyectoIntegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softtek.proyecto.proyectoIntegrador.entities.Proveedor;

@Repository
public interface RepositorioProveedor extends JpaRepository<Proveedor, Integer> {
}
