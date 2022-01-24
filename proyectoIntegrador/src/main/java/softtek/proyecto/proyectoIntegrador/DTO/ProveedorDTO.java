package softtek.proyecto.proyectoIntegrador.DTO;


import lombok.Getter;
import lombok.Setter;
import softtek.proyecto.proyectoIntegrador.entities.Producto;
import softtek.proyecto.proyectoIntegrador.entities.Proveedor;

import java.util.List;

@Getter
@Setter
public class ProveedorDTO {

    public ProveedorDTO(){}

    public ProveedorDTO(Proveedor p) {
        this.id = p.getId();
        this.nombre = p.getNombre();
        this.direccion = p.getDireccion();
    }

    private Integer id;
    private String nombre;
    private String direccion;
}
