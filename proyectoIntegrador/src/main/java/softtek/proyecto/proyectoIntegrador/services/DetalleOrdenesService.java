package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.entities.DetalleOrden;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioDetalleOrdenes;

import java.util.List;

@Service
public class DetalleOrdenesService {
    @Autowired
    RepositorioDetalleOrdenes repository;

    public DetalleOrden getDetalleOrden(int id){
        return repository.findById(id).get();
    }

    public List<DetalleOrden> getDetallesOrdenes(){
        return repository.findAll();
    }

    public DetalleOrden guardarDetalleOrden(DetalleOrden detalle){
        return repository.save(detalle);
    }

    public DetalleOrden editarDetalleOrden(DetalleOrden detalle){
        DetalleOrden detalleExistente = repository.findById(detalle.getId()).orElse(null);
        detalleExistente.setPrecio(detalle.getPrecio());
       // detalleExistente.setProducto(detalle.getProducto());
        detalleExistente.setOrden(detalle.getOrden());
        detalleExistente.setStock(detalle.getStock());
        return repository.save(detalleExistente);
    }

    public String borrarDetalleOrden(int id){
        repository.deleteById(id);
        return "Detalle Orden borrado";
    }
}
