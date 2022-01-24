package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.entities.Orden;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioOrdenes;

import java.util.List;

@Service
public class OrdenesService {
    @Autowired
    RepositorioOrdenes repository;

    public Orden getOrden(int id){
        return repository.findById(id).get();
    }

    public List<Orden> getOrdenes(){
        return repository.findAll();
    }

    public Orden guardarOrden(Orden o){
        return repository.save(o);
    }

    public Orden editarOrden(Orden o){
        Orden ordenExistente = repository.findById(o.getId()).orElse(null);
        ordenExistente.setDetalleOrden(o.getDetalleOrden());
        ordenExistente.setCliente(o.getCliente());
        ordenExistente.setEmpleado(o.getEmpleado());
        ordenExistente.setDetalleOrden(o.getDetalleOrden());
        ordenExistente.setFechaEntrega(o.getFechaEntrega());
        ordenExistente.setFechaGeneracion(o.getFechaGeneracion());
        return repository.save(ordenExistente);
    }

    public String borrarOrden(int id){
        repository.deleteById(id);
        return "Se elimino la orden";
    }
}
