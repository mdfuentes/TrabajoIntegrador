package softtek.proyecto.proyectoIntegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softtek.proyecto.proyectoIntegrador.entities.Empleado;
import softtek.proyecto.proyectoIntegrador.repositories.RepositorioEmpleados;

import java.util.List;

@Service
public class EmpleadosService {
    @Autowired
    RepositorioEmpleados repository;

    public Empleado getEmpleado(int id){
        return repository.findById(id).get();
    }

    public List<Empleado> getEmpleados(){
        return repository.findAll();
    }

    public Empleado guardarEmpleado(Empleado e){
        return repository.save(e);
    }

    public Empleado editarEmpleado(Empleado e){
        Empleado empleadoExistente = repository.findById(e.getId()).orElse(null);
        empleadoExistente.setNombre(e.getNombre());
        empleadoExistente.setApellido(e.getApellido());
        empleadoExistente.setOrden(e.getOrden());
        empleadoExistente.setSupervisor(e.getSupervisor());
        return repository.save(empleadoExistente);
    }

    public String borrarEmpleado(int id){
        repository.deleteById(id);
        return "Empleado eliminado";
    }


}
