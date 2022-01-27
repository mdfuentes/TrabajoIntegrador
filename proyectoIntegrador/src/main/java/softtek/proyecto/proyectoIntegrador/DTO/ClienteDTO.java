package softtek.proyecto.proyectoIntegrador.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO extends UsuarioDTO{

    private String razonSocial;

    private String cuitDni;

    private String TipoCliente;

}
