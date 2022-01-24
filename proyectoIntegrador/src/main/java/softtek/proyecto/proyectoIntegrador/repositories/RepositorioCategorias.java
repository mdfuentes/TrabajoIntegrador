package softtek.proyecto.proyectoIntegrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softtek.proyecto.proyectoIntegrador.entities.Categoria;

public interface RepositorioCategorias extends JpaRepository<Categoria, Integer> {
}
