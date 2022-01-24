package softtek.proyecto.proyectoIntegrador.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softtek.proyecto.proyectoIntegrador.entities.Empleado;
import softtek.proyecto.proyectoIntegrador.services.EmpleadosService;

import java.util.List;

@RequestMapping
public class ControllerEmpleados {
    @Autowired
    EmpleadosService empleadosService;

    @RequestMapping("/empleados")
    public List<Empleado> findEmpleados(){
        return empleadosService.getEmpleados();
    }

    @GetMapping("/emmpleados/{id}")
    public Empleado findEmpleado(@PathVariable int id){
        return empleadosService.getEmpleado(id);
    }

    @PostMapping("/empleados")
    public Empleado addEmpleado(@RequestBody Empleado e){
        return empleadosService.guardarEmpleado(e);
    }

    @PutMapping("/empleados")
    public Empleado updateEmpleado(@RequestBody Empleado e){
        return empleadosService.editarEmpleado(e);
    }

    @DeleteMapping("/empleados/{id}")
    public String deleteEmpleado(@PathVariable int id){
        return empleadosService.borrarEmpleado(id);
    }
}
