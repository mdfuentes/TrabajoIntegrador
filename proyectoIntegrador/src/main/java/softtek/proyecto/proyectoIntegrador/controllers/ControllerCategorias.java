package softtek.proyecto.proyectoIntegrador.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.entities.Categoria;
import softtek.proyecto.proyectoIntegrador.services.CategoriasService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ControllerCategorias {
    @Autowired
    CategoriasService categoriasService;

    @RequestMapping("/categorias")
    public List<Categoria> findCategorias(){
        return categoriasService.getCategorias();
    }

    @GetMapping("/categorias/{id}")
    public Categoria findCategoria(@PathVariable int id){
        return categoriasService.getCategoria(id);
    }

    @PostMapping("/categorias")
    public Categoria addCategoria(@RequestBody Categoria c){
        return categoriasService.guardarCategoria(c);
    }

    @PutMapping("/categorias")
    public Categoria updateCategoria(@RequestBody Categoria c){
        return categoriasService.editarCategoria(c);
    }

    @DeleteMapping("/categorias/{id}")
    public String deleteCategoria(@PathVariable int id){
        return categoriasService.borrarCategoria(id);
    }


}
