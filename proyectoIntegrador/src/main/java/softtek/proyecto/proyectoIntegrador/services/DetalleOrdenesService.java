package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.DTO.DetalleOrdenDTO;
import softtek.proyecto.proyectoIntegrador.entities.DetalleOrden;
import softtek.proyecto.proyectoIntegrador.entities.Orden;
import softtek.proyecto.proyectoIntegrador.entities.Producto;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioDetalleOrdenes;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioOrdenes;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioProductos;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetalleOrdenesService {
    @Autowired
    RepositorioDetalleOrdenes repositorioDetalleOrdenes;
    @Autowired
    RepositorioProductos repositorioProductos;
    @Autowired
    RepositorioOrdenes repositorioOrdenes;

    public DetalleOrdenDTO getDetalleOrden(int id){

        return convertirDetalleADTO(repositorioDetalleOrdenes.findById(id).get());
    }

    public List<DetalleOrdenDTO> getDetallesOrdenes(){

        return convertirDetallesADTO(repositorioDetalleOrdenes.findAll());
    }

    public DetalleOrdenDTO guardarDetalleOrden(DetalleOrdenDTO detalle){
        repositorioDetalleOrdenes.save(convertirDTOADetalle(detalle));
        return detalle;
    }

    public DetalleOrdenDTO editarDetalleOrden(DetalleOrdenDTO detalle, int id){
        DetalleOrden detalleDTO = convertirDTOADetalle(detalle);
        DetalleOrden detalleExistente = repositorioDetalleOrdenes.findById(id).orElse(null);
        detalleExistente.setPrecio(detalleDTO.getPrecio());
        detalleExistente.setOrden(detalleDTO.getOrden());
        detalleExistente.setProducto(detalleDTO.getProducto());
        repositorioDetalleOrdenes.save(detalleExistente);
        return detalle;
    }

    public String borrarDetalleOrden(int id){
        repositorioDetalleOrdenes.deleteById(id);
        return "Detalle Orden borrado";
    }

    public DetalleOrden convertirDTOADetalle(DetalleOrdenDTO dto){
        DetalleOrden detalle = new DetalleOrden();
        Producto producto;
        Orden orden;
        detalle.setPrecio(dto.getPrecio());
        producto = repositorioProductos.findById(dto.getIdProducto()).get();
        orden = repositorioOrdenes.findById(dto.getIdOrden()).get();
        detalle.setProducto(producto);
        detalle.setOrden(orden);
        return detalle;
    }

    public DetalleOrdenDTO convertirDetalleADTO(DetalleOrden detalle){
        DetalleOrdenDTO detalleOrdenDTO = new DetalleOrdenDTO(detalle);
        return detalleOrdenDTO;
    }

    public List<DetalleOrdenDTO> convertirDetallesADTO(List<DetalleOrden> list){
        List<DetalleOrdenDTO> listaDTO = new ArrayList<>();
        for(DetalleOrden detalle : list){
            listaDTO.add(convertirDetalleADTO(detalle));
        }
        return listaDTO;
    }

}
