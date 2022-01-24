package softtek.proyecto.proyectoIntegrador.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
@Setter
@Getter
public class Producto {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String nombre;

    @Column
    private double precio;

    @Column
    private Integer stock;


    @ManyToOne(targetEntity = Proveedor.class)
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    private Proveedor proveedor;


    @OneToMany(mappedBy = "producto")
    private List<DetalleOrden> detalleOrdenList;

}
