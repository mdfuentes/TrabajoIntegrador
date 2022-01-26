package softtek.proyecto.proyectoIntegrador.DTO;


import lombok.Getter;
import lombok.Setter;
import softtek.proyecto.proyectoIntegrador.entities.DetalleOrden;

@Getter
@Setter
public class DetalleOrdenDTO {
    public DetalleOrdenDTO(){}

    public DetalleOrdenDTO(DetalleOrden detalle){
        this.id = detalle.getId();
        this.precio = detalle.getPrecio();
        this.idProducto = detalle.getProducto().getId();
        this.cantidad = detalle.getCantidad();
        this.idOrden = detalle.getOrden().getId();

    }
    private Integer id;

    private double precio;

    private Integer cantidad;

    private Integer idProducto;

    private Integer idOrden;


}
