package softtek.proyecto.proyectoIntegrador.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empleado")
@Setter
@Getter
public class Empleado {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @OneToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "id_supervisor")
    private Empleado supervisor;

    @OneToMany(mappedBy = "empleado")
    private List<Orden> orden;



}
