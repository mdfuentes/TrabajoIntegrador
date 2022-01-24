package softtek.proyecto.proyectoIntegrador.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "proveedor")
@Getter
@Setter
public class Proveedor {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String direccion;


    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;

    @ManyToMany
    @JoinTable(
            name = "proveedor_categoria",
            joinColumns = {@JoinColumn (name = "id_proveedor")},
            inverseJoinColumns = {@JoinColumn(name = "id_categoria")}
    )
    private List<Categoria> categorias;


}
