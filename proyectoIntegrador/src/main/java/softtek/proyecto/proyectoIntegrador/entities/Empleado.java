package softtek.proyecto.proyectoIntegrador.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empleado")
@Setter
@Getter
public class Empleado extends Usuario{

  /*  @OneToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "id_supervisor")
    private Empleado supervisor;*/

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Orden> orden;



}
