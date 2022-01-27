package softtek.proyecto.proyectoIntegrador.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "cliente")
@Getter
@Setter
public class Cliente extends Usuario{

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "cuit_dni")
    private String cuitDni;

    private String TipoCliente; //VER ENUM
            //TODO

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Orden> orden;

}
