package softtek.proyecto.proyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.entities.Cliente;
import softtek.proyecto.proyectoIntegrador.services.ClientesService;

import java.util.List;

@RestController
public class ControllerClientes {
    @Autowired
    ClientesService clientesService;

    @RequestMapping("/clientes")
    public List<Cliente> findClientes(){
        return clientesService.getClientes();
    }

    @GetMapping("/clientes/{id}")
    public Cliente findCliente(@PathVariable int id){
        return clientesService.getCliente(id);
    }

    @PostMapping("/clientes")
    public Cliente addCliente(@RequestBody Cliente c){
        return clientesService.guardarCliente(c);
    }

    @PutMapping("/clientes")
    public Cliente updateCliente(@RequestBody Cliente c){
        return clientesService.editarCliente(c);
    }

    @DeleteMapping("/clientes/{id}")
    public String deleteCliente(@PathVariable int id){
        return clientesService.borrarCliente(id);
    }

}
