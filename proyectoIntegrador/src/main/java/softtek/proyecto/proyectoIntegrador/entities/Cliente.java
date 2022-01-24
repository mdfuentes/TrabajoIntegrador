package softtek.proyecto.proyectoIntegrador.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "cliente")
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "cuit_dni")
    private String cuitDni;

    private String TipoCliente; //VER ENUM
            //TODO

    @OneToMany(mappedBy = "cliente")
    private List<Orden> orden;

}
