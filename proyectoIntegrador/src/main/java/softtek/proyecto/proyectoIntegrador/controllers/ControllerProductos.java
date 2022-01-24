package softtek.proyecto.proyectoIntegrador.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.DTO.ProductoDTO;
import softtek.proyecto.proyectoIntegrador.entities.Producto;
import softtek.proyecto.proyectoIntegrador.services.ProductosService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/productos")

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ControllerProductos {
    @Autowired
    ProductosService productosService;

    @GetMapping("/")
    public List<ProductoDTO> findProductos(){
        return productosService.getProductos();
    }

    @GetMapping("/page/{page}")
    public Page<ProductoDTO> findProductosPaginados(@PathVariable int page) {
        return  productosService.getPaginacionProductos(page, 10);
    }

    @GetMapping("/{id}")
    public ProductoDTO findProductoId (@PathVariable int id){
        return productosService.getProductoById(id);
    }

    @PostMapping("/")
    public ProductoDTO addProducto(@Valid @RequestBody ProductoDTO p){
        return productosService.guardarProducto(p);
    }

    @PutMapping("/{id}")
    public ProductoDTO actualizarProducto(@RequestBody ProductoDTO p, @PathVariable int id){
        return productosService.editarProducto(p, id);
    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable int id){
        return productosService.borrarProducto(id);
    }
}
