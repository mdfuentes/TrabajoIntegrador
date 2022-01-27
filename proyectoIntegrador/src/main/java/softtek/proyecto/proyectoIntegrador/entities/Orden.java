package softtek.proyecto.proyectoIntegrador.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden")
@Getter
@Setter
public class Orden {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column(name = "fecha_generacion")
    private Date fechaGeneracion;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @ManyToOne(targetEntity = Cliente.class)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
    private Empleado empleado;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<DetalleOrden> detalleOrden;



}
