package softtek.proyecto.proyectoIntegrador.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Setter
@Getter
public class Categoria {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String descripcion;

    @ManyToMany(mappedBy = "categorias")
    private Set<Proveedor> proveedores;
}