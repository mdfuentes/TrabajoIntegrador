package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.entities.Categoria;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioCategorias;

import java.util.List;

@Service
public class CategoriasService {
    @Autowired
    RepositorioCategorias repository;

    public Categoria getCategoria(int id){
        return repository.findById(id).get();
    }

    public List<Categoria> getCategorias(){
        return repository.findAll();
    }

    public Categoria guardarCategoria(Categoria c){
        return repository.save(c);
    }

    public Categoria editarCategoria(Categoria c){
        Categoria categoriaExistente = repository.findById(c.getId()).orElse(null);
        categoriaExistente.setDescripcion(c.getDescripcion());
        categoriaExistente.setProveedores(c.getProveedores());
        return repository.save(categoriaExistente);
    }

    public String borrarCategoria(int id){
        repository.deleteById(id);
        return "Categoria eliminada";
    }
}
