package softtek.proyecto.proyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.DTO.ClienteDTO;
import softtek.proyecto.proyectoIntegrador.entities.Cliente;
import softtek.proyecto.proyectoIntegrador.services.ClientesService;

import java.util.List;

@RequestMapping("/clientes")
@RestController
public class ControllerClientes {
    @Autowired
    ClientesService clientesService;

    @GetMapping("/")
    public List<ClienteDTO> findClientes(){
        return clientesService.getClientes();
    }

    @GetMapping("/{id}")
    public ClienteDTO findCliente(@PathVariable int id){
        return clientesService.getCliente(id);
    }

    @PostMapping("/")
    public ClienteDTO addCliente(@RequestBody ClienteDTO c){
        return clientesService.guardarCliente(c);
    }

    @PutMapping("/")
    public Cliente updateCliente(@RequestBody Cliente c){
        return clientesService.editarCliente(c);
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable int id){
        return clientesService.borrarCliente(id);
    }

}
