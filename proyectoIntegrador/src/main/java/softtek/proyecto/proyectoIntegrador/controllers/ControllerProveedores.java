package softtek.proyecto.proyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.DTO.ProveedorDTO;
import softtek.proyecto.proyectoIntegrador.entities.Proveedor;
import softtek.proyecto.proyectoIntegrador.services.ProveedoresService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ControllerProveedores {
    @Autowired
    ProveedoresService proveedoresService;

    @RequestMapping("/proveedores")
    public List<ProveedorDTO> findProveedores(){
        return proveedoresService.getProveedores();
    }

    @GetMapping("/proveedores/{id}")
    public ProveedorDTO findProveedor(@PathVariable int id){
        return proveedoresService.getProveedor(id);
    }

    @PostMapping("/proveedores")
    public Proveedor addProveedor(@RequestBody ProveedorDTO p){
        return proveedoresService.guardarProveedor(p);
    }

    @PutMapping("/proveedores")
    public Proveedor updateProveedor(@RequestBody Proveedor p){
        return proveedoresService.editarProveedor(p);
    }

    @DeleteMapping("/proveedores/{id}")
    public String deleteProveedor(@PathVariable int id){
        return proveedoresService.borrarProveedor(id);
    }

}
