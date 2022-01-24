package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.entities.Cliente;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioClientes;

import java.util.List;

@Service
public class ClientesService {
    @Autowired
    RepositorioClientes repository;

    public Cliente getCliente(int id){
        return repository.findById(id).get();
    }

    public List<Cliente> getClientes(){
        return repository.findAll();
    }

    public Cliente guardarCliente(Cliente c){
        return repository.save(c);
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

}
