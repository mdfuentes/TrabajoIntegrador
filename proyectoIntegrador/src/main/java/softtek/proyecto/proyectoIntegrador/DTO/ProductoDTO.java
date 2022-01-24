package softtek.proyecto.proyectoIntegrador.DTO;

import lombok.Getter;
import lombok.Setter;
import softtek.proyecto.proyectoIntegrador.entities.Producto;
import softtek.proyecto.proyectoIntegrador.entities.Proveedor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProductoDTO {

    public ProductoDTO(){}

    public ProductoDTO(Producto p) {
        this.id = p.getId();
        this.nombre = p.getNombre();
        this.precio = p.getPrecio();
        this.stock = p.getStock();
        this.idProveedor = p.getProveedor().getId();
        this.nombreProveedor = p.getProveedor().getNombre();
    }

    private Integer id;

    @NotNull(message = "El nombre debe completarse")
    private String nombre;

    @NotNull
    @Min(value = 0, message = "El precio minimo debe ser de 0" )
    private double precio;

    @NotNull
    @Min(value = 1, message = "El stock minimo es 1")
    private Integer stock;

    @NotNull(message = "Debe seleccionar un proveedor")
    private Integer idProveedor;

    private String nombreProveedor;
}
