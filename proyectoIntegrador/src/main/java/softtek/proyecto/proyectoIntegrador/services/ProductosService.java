package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.DTO.ProductoDTO;
import softtek.proyecto.proyectoIntegrador.entities.Producto;
import softtek.proyecto.proyectoIntegrador.entities.Proveedor;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioProductos;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioProveedor;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosService {
    @Autowired
    private RepositorioProductos repositorioProductos;

    @Autowired RepositorioProveedor repositorioProveedor;

    public ProductoDTO guardarProducto(ProductoDTO p){
        repositorioProductos.save(convertirDTOAProducto(p));
        return p;
    }

    public ProductoDTO getProductoById(Integer id){
        return convertirProductoADTO(repositorioProductos.findById(id).get());
    }


    public List<ProductoDTO> getProductos() {
        return convertirProductosADTO(repositorioProductos.findAll());
    }

    public Page<ProductoDTO> getPaginacionProductos(int page, int size){
        Page<Producto> producto = repositorioProductos.findAll(PageRequest.of(page, size, Sort.by("id")));
        Page<ProductoDTO> dtoPage =  producto.map(product -> new ProductoDTO(product));
        return dtoPage;
    }

    public String borrarProducto(int id){
        repositorioProductos.deleteById(id);
        return "Producto eliminado";
    }

    public ProductoDTO editarProducto(ProductoDTO p, int id){
        Producto productoDTO = convertirDTOAProducto(p);
        Producto productoExistente = repositorioProductos.findById(id).orElse(null);
        productoExistente.setNombre(productoDTO .getNombre());
        productoExistente.setPrecio(productoDTO .getPrecio());
        productoExistente.setStock(productoDTO .getStock());
        productoExistente.setProveedor(productoDTO .getProveedor());
        repositorioProductos.save(productoExistente);
        return p;
    }

    public Producto convertirDTOAProducto(ProductoDTO dto) {
        Producto producto = new Producto();
        Proveedor proveedor;
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        proveedor = repositorioProveedor.findById(dto.getIdProveedor()).get();
        producto.setProveedor(proveedor);
        return producto;
    }

    public ProductoDTO convertirProductoADTO(Producto p) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(p.getId());
        productoDTO.setNombre(p.getNombre());
        productoDTO.setPrecio(p.getPrecio());
        productoDTO.setStock(p.getStock());
        productoDTO.setIdProveedor(p.getProveedor().getId());
        productoDTO.setNombreProveedor(p.getProveedor().getNombre());
        return productoDTO;
    }
    public List<ProductoDTO> convertirProductosADTO(List<Producto> list){
        List<ProductoDTO> listaDTO = new ArrayList<>();
        for(Producto producto : list){
            listaDTO.add(convertirProductoADTO(producto));
        }
        return listaDTO;
    }
}
