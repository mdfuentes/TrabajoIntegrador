package softtek.proyecto.proyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.DTO.ProductoDTO;
import softtek.proyecto.proyectoIntegrador.DTO.ProveedorDTO;
import softtek.proyecto.proyectoIntegrador.entities.Proveedor;
import softtek.proyecto.proyectoIntegrador.services.ProveedoresService;

import java.util.List;

@RequestMapping("/proveedores")
@CrossOrigin(origins = "*")
@RestController
public class ControllerProveedores {
    @Autowired
    ProveedoresService proveedoresService;

    @GetMapping("/")
    public List<ProveedorDTO> findProveedores(){
        return proveedoresService.getProveedores();
    }

    @GetMapping("/page/{page}")
    public Page<ProveedorDTO> findProductosPaginados(@PathVariable int page) {
        return  proveedoresService.getPaginacionProveedores(page, 10);
    }

    @GetMapping("/{id}")
    public ProveedorDTO findProveedor(@PathVariable int id){
        return proveedoresService.getProveedor(id);
    }

    @PostMapping("/")
    public Proveedor addProveedor(@RequestBody ProveedorDTO p){
        return proveedoresService.guardarProveedor(p);
    }

    @PutMapping("/{id}")
    public ProveedorDTO updateProveedor(@RequestBody ProveedorDTO p, @PathVariable int id){
        return proveedoresService.editarProveedor(p, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProveedor(@PathVariable int id){
        return proveedoresService.borrarProveedor(id);
    }

}
