package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.DTO.ProductoDTO;
import softtek.proyecto.proyectoIntegrador.DTO.ProveedorDTO;
import softtek.proyecto.proyectoIntegrador.entities.Producto;
import softtek.proyecto.proyectoIntegrador.entities.Proveedor;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioProductos;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioProveedor;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedoresService {
    @Autowired
    private RepositorioProveedor repositorioProveedor;

    @Autowired
    RepositorioProductos repositorioProductos;

    public Proveedor guardarProveedor(ProveedorDTO p){
        return repositorioProveedor.save(convertirDTOAProveedor(p));
    }

    public ProveedorDTO getProveedor(int id){
        return convertirProveedorADTO(repositorioProveedor.findById(id).get());
    }

    public List<ProveedorDTO> getProveedores(){

        return convertirProveedoresADTO(repositorioProveedor.findAll());
    }

    public Page<ProveedorDTO> getPaginacionProveedores(int page, int size){
        Page<Proveedor> proveedor = repositorioProveedor.findAll(PageRequest.of(page, size, Sort.by("id")));
        Page<ProveedorDTO> dtoPage = proveedor.map(prov -> new ProveedorDTO(prov));
        return dtoPage;

    }

    public String borrarProveedor(int id){
        repositorioProveedor.deleteById(id);
        return "Proveedor eliminado";
    }

    public Proveedor editarProveedor(Proveedor p){
        Proveedor proveedorExistente = repositorioProveedor.findById(p.getId()).orElse(null);
        proveedorExistente.setNombre(p.getNombre());
        proveedorExistente.setDireccion(p.getDireccion());
        return repositorioProveedor.save(proveedorExistente);
    }

    public ProveedorDTO convertirProveedorADTO(Proveedor p){
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setId(p.getId());
        proveedorDTO.setNombre(p.getNombre());
        proveedorDTO.setDireccion(p.getDireccion());
        return proveedorDTO;
    }

    public List<ProveedorDTO> convertirProveedoresADTO(List<Proveedor> list){
        List<ProveedorDTO> listaDTO = new ArrayList<>();
        for (Proveedor proveedor : list){
            listaDTO.add(convertirProveedorADTO(proveedor));
        }
        return listaDTO;
    }

    public Proveedor convertirDTOAProveedor(ProveedorDTO dto){
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(dto.getNombre());
        proveedor.setDireccion(dto.getDireccion());
        return proveedor;
    }

}
