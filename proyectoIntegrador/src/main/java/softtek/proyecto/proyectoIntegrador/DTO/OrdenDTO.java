package softtek.proyecto.proyectoIntegrador.DTO;


import lombok.Getter;
import lombok.Setter;
import softtek.proyecto.proyectoIntegrador.entities.Orden;

import java.util.Date;

@Getter
@Setter
public class OrdenDTO {

    public OrdenDTO(){}

    public OrdenDTO(Orden o){
        this.id = o.getId();
        this.fechaEntrega = o.getFechaEntrega();
        this.fechaGeneracion = o.getFechaGeneracion();
        this.idCliente = o.getCliente().getId();
        this.idEmpleado = o.getEmpleado().getId();
    }

    private Integer id;

    private Date fechaGeneracion;

    private Date fechaEntrega;

    private Integer idCliente;

    private Integer idEmpleado;


}
