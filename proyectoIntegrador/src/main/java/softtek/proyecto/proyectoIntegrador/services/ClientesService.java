package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.DTO.ClienteDTO;
import softtek.proyecto.proyectoIntegrador.entities.Cliente;
import softtek.proyecto.proyectoIntegrador.entities.Orden;
import softtek.proyecto.proyectoIntegrador.entities.enumRol;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioClientes;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioOrdenes;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientesService {
    @Autowired
    RepositorioClientes repository;
    RepositorioOrdenes repositorioOrdenes;

    public ClienteDTO getCliente(int id){
        return convertirClienteADTO(repository.findById(id).get());
    }

    public List<ClienteDTO> getClientes(){
        return convertirClientesADTO(repository.findAll());
    }

    public ClienteDTO guardarCliente(ClienteDTO c){
        repository.save(convertirDTOACliente(c));
        return c;
    }

    public Cliente editarCliente(Cliente c){
        Cliente clienteExistente = repository.findById(c.getId()).orElse(null);
        clienteExistente.setNombre(c.getNombre());
        clienteExistente.setApellido(c.getApellido());
        clienteExistente.setRazonSocial(c.getRazonSocial());
        clienteExistente.setCuitDni(c.getCuitDni());
        clienteExistente.setOrden(c.getOrden());
        clienteExistente.setTipoCliente(c.getTipoCliente());
        return repository.save(clienteExistente);
    }

    public String borrarCliente(int id){
        repository.deleteById(id);
        return "Se elimino el cliente";
    }

    public Cliente convertirDTOACliente(ClienteDTO dto){
        Cliente cliente = new Cliente();
        Orden ordenes;
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setCuitDni(dto.getCuitDni());
        cliente.setTipoCliente(dto.getTipoCliente());
        cliente.setRazonSocial(dto.getRazonSocial());
        cliente.setUsuario(dto.getUsuario());
        cliente.setContraseña(dto.getContraseña());
        cliente.setRol(enumRol.CLIENTE);
        return cliente;
    }

    public ClienteDTO convertirClienteADTO (Cliente cliente){
        ClienteDTO dto = new ClienteDTO();
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setTipoCliente(cliente.getTipoCliente());
        dto.setCuitDni(cliente.getCuitDni());
        dto.setRazonSocial(cliente.getRazonSocial());
        dto.setUsuario(cliente.getUsuario());
        dto.setContraseña(cliente.getContraseña());
        dto.setRol("CLIENTE");
        return dto;
    }

    public List<ClienteDTO> convertirClientesADTO(List<Cliente> list){
        List<ClienteDTO> listaDTO = new ArrayList<>();
        for(Cliente cliente : list){
            listaDTO.add(convertirClienteADTO(cliente));
        }
        return listaDTO;
    }

}
