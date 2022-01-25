package softtek.proyecto.proyectoIntegrador.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detalle_orden")
@Setter
@Getter
public class DetalleOrden {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private double precio;

    @ManyToOne(targetEntity = Producto.class)
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;

    @ManyToOne(targetEntity = Orden.class)
    @JoinColumn(name = "id_orden", referencedColumnName = "id")
    private Orden orden;
}
