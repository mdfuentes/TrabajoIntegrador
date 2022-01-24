package softtek.proyecto.proyectoIntegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softtek.proyecto.proyectoIntegrador.entities.Producto;

@Repository
public interface RepositorioProductos extends JpaRepository<Producto, Integer> {
}
