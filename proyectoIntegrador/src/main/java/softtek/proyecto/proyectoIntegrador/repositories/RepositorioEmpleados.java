package softtek.proyecto.proyectoIntegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softtek.proyecto.proyectoIntegrador.entities.Empleado;

public interface RepositorioEmpleados extends JpaRepository<Empleado, Integer> {
}
