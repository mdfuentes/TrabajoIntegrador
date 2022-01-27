package softtek.proyecto.proyectoIntegrador.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "administrador")
@Getter
@Setter
public class Administrador extends Usuario{

}
