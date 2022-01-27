package softtek.proyecto.proyectoIntegrador.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Integer id;

    private String usuario;

    private String contraseña;

    private String nombre;

    private String apellido;
}
