package softtek.proyecto.proyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.DTO.OrdenDTO;
import softtek.proyecto.proyectoIntegrador.entities.Orden;
import softtek.proyecto.proyectoIntegrador.services.OrdenesService;

import java.util.List;


@RequestMapping("/ordenes")
@RestController
public class ControllerOrdenes {
    @Autowired
    OrdenesService ordenesService;

    @GetMapping("/")
    public List<OrdenDTO> findOrdenes(){
        return ordenesService.getOrdenes();
    }

    @GetMapping("/{id}")
    public OrdenDTO findOrden(@PathVariable int id){
        return ordenesService.getOrden(id);
    }

    @PostMapping("/")
    public OrdenDTO addOrden(@RequestBody OrdenDTO o){
        return ordenesService.guardarOrden(o);
    }

    @PutMapping("/{id}")
    public OrdenDTO updateOrden(@RequestBody OrdenDTO o, @PathVariable int id){
        return ordenesService.editarOrden(o, id);
    }

    @DeleteMapping("/{id}")
    public String deleteOrden(@PathVariable int id){
        return ordenesService.borrarOrden(id);
    }

}
