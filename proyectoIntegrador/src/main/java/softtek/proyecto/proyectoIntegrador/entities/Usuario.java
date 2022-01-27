package softtek.proyecto.proyectoIntegrador.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "usuario")
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column (unique = true)
    private String usuario;

    @Column
    private String contraseña;

    @Column
    private String nombre;

    @Column
    private String apellido;



}
