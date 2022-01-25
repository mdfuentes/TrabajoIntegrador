package softtek.proyecto.proyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.DTO.DetalleOrdenDTO;
import softtek.proyecto.proyectoIntegrador.services.DetalleOrdenesService;

import java.util.List;

@RequestMapping("/detalles")
@RestController
public class ControllerDetalleOrdenes {
    @Autowired
    DetalleOrdenesService detalleOrdenesService;

    @GetMapping("/")
    public List<DetalleOrdenDTO> findDetalles () {
        return detalleOrdenesService.getDetallesOrdenes();
    }

    @GetMapping("/{id}")
    public DetalleOrdenDTO findDetalle(@PathVariable int id){
        return detalleOrdenesService.getDetalleOrden(id);
    }

    @PostMapping("/")
    public DetalleOrdenDTO addDetalle(@RequestBody DetalleOrdenDTO detalle){
        return detalleOrdenesService.guardarDetalleOrden(detalle);
    }

    @PutMapping("/{id}")
    public DetalleOrdenDTO updateDetalle(@RequestBody DetalleOrdenDTO detalle, @PathVariable int id){
        return detalleOrdenesService.editarDetalleOrden(detalle, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDetalle(@PathVariable int id){
        return detalleOrdenesService.borrarDetalleOrden(id);
    }

}
