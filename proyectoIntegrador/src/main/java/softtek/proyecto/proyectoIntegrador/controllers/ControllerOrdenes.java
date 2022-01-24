package softtek.proyecto.proyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.entities.Orden;
import softtek.proyecto.proyectoIntegrador.services.OrdenesService;

import java.util.List;


@RequestMapping("/ordenes")
@RestController
public class ControllerOrdenes {
    @Autowired
    OrdenesService ordenesService;

    @GetMapping("/")
    public List<Orden> findOrdenes(){
        return ordenesService.getOrdenes();
    }

    @GetMapping("/{id}")
    public Orden findOrden(@PathVariable int id){
        return ordenesService.getOrden(id);
    }

    @PostMapping("/")
    public Orden addOrden(@RequestBody Orden o){
        return ordenesService.guardarOrden(o);
    }

    @PutMapping("/")
    public Orden updateOrden(@RequestBody Orden o){
        return ordenesService.editarOrden(o);
    }

    @DeleteMapping("/{id}")
    public String deleteOrden(@PathVariable int id){
        return ordenesService.borrarOrden(id);
    }

}
