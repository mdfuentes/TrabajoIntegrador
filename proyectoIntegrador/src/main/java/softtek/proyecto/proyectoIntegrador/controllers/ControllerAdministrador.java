package softtek.proyecto.proyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.DTO.AdministradorDTO;
import softtek.proyecto.proyectoIntegrador.services.AdministradorService;

import java.util.List;

@RequestMapping("/admin")

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ControllerAdministrador {
    @Autowired
    AdministradorService administradorService;

    @GetMapping("/")
    public List<AdministradorDTO> findAdmins(){
        return administradorService.getAdministradores();
    }

    @GetMapping("/{id}")
    public AdministradorDTO findAdmin(@PathVariable int id){
        return administradorService.getAdministrador(id);
    }

    @PostMapping("/")
    public AdministradorDTO saveAdmin(@RequestBody AdministradorDTO admin){
        return administradorService.guardarAdministrador(admin);
    }

}
