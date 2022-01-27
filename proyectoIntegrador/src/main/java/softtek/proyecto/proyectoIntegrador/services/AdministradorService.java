package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.DTO.AdministradorDTO;
import softtek.proyecto.proyectoIntegrador.entities.Administrador;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioAdministrador;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioClientes;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministradorService {
    @Autowired
    RepositorioAdministrador repositorioAdministrador;

    public AdministradorDTO getAdministrador(int id) {
        return convertirAdministradorADTO(repositorioAdministrador.findById(id).get());
    }

    public List<AdministradorDTO> getAdministradores(){
        return convertirAdministradoresADTO(repositorioAdministrador.findAll());
    }

    public AdministradorDTO guardarAdministrador(AdministradorDTO admin){
        repositorioAdministrador.save(convertirDTOAAdministrador(admin));
        return admin;
    }


    public Administrador convertirDTOAAdministrador(AdministradorDTO dto){
        Administrador administrador = new Administrador();
        administrador.setNombre(dto.getNombre());
        administrador.setApellido(dto.getApellido());
        administrador.setUsuario(dto.getUsuario());
        administrador.setContraseña(dto.getContraseña());
        return administrador;
    }

    public AdministradorDTO convertirAdministradorADTO(Administrador admin){
        AdministradorDTO dto = new AdministradorDTO();
        dto.setApellido(admin.getApellido());
        dto.setNombre(admin.getNombre());
        dto.setUsuario(admin.getUsuario());
        dto.setContraseña(admin.getContraseña());
        dto.setId(admin.getId());
        return dto;
    }

    public List<AdministradorDTO> convertirAdministradoresADTO(List<Administrador> list){
        List<AdministradorDTO> listaDTO = new ArrayList<>();
        for(Administrador admin : list){
            listaDTO.add(convertirAdministradorADTO(admin));
        }
        return listaDTO;
    }
}
