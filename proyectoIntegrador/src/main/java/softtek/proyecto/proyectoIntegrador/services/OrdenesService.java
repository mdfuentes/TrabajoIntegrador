package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.DTO.OrdenDTO;
import softtek.proyecto.proyectoIntegrador.entities.Cliente;
import softtek.proyecto.proyectoIntegrador.entities.Empleado;
import softtek.proyecto.proyectoIntegrador.entities.Orden;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioClientes;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioEmpleados;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioOrdenes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrdenesService {
    @Autowired
    RepositorioOrdenes repositorioOrdenes;
    @Autowired
    RepositorioEmpleados repositorioEmpleados;
    @Autowired
    RepositorioClientes repositorioClientes;

    public OrdenDTO getOrden(int id){
        return convertirOrdenADTO(repositorioOrdenes.findById(id).get());
    }

    public List<OrdenDTO> getOrdenes(){
        return convertirOrdenesADTO(repositorioOrdenes.findAll());
    }

    public OrdenDTO guardarOrden(OrdenDTO o){
        Orden orden = convertirDTOAOrden(o);
        orden = repositorioOrdenes.save(convertirDTOAOrden(o));
        o.setId(orden.getId());
        return o ;
    }

    public OrdenDTO editarOrden(OrdenDTO o, int id){
        Orden ordenDTO = convertirDTOAOrden(o);
        Orden ordenExistente = repositorioOrdenes.findById(id).orElse(null);
        ordenExistente.setFechaGeneracion(ordenDTO.getFechaGeneracion());
        ordenExistente.setFechaEntrega(ordenDTO.getFechaEntrega());
        ordenExistente.setCliente(ordenDTO.getCliente());
        ordenExistente.setEmpleado(ordenDTO.getEmpleado());
        repositorioOrdenes.save((ordenExistente));
        return o;
    }

    public String borrarOrden(int id){
        repositorioOrdenes.deleteById(id);
        return "Se elimino la orden";
    }

    public Orden convertirDTOAOrden (OrdenDTO dto){
        Orden orden = new Orden();
        Cliente cliente;
        Empleado empleado;
        orden.setFechaEntrega(dto.getFechaEntrega());
        orden.setFechaGeneracion(dto.getFechaGeneracion());
        cliente = repositorioClientes.findById(dto.getIdCliente()).get();
        empleado = repositorioEmpleados.findById(dto.getIdEmpleado()).get();
        orden.setCliente(cliente);
        orden.setEmpleado(empleado);
        return orden;
    }

    public OrdenDTO convertirOrdenADTO(Orden o){
        OrdenDTO ordenDTO = new OrdenDTO(o);
        return ordenDTO;
    }

    public List<OrdenDTO> convertirOrdenesADTO(List<Orden> list){
        List<OrdenDTO> listaDTO = new ArrayList<>();
        for(Orden orden : list){
            listaDTO.add(convertirOrdenADTO(orden));
        }
        return listaDTO;
    }
}
