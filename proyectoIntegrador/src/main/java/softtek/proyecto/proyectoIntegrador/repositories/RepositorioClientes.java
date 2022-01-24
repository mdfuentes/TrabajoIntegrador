package softtek.proyecto.proyectoIntegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softtek.proyecto.proyectoIntegrador.entities.Cliente;

public interface RepositorioClientes extends JpaRepository<Cliente, Integer> {
}
