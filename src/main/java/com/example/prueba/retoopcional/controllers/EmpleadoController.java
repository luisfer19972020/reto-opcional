package com.example.prueba.retoopcional.controllers;

import java.util.List;

import com.example.prueba.retoopcional.models.entity.Empleado;
import com.example.prueba.retoopcional.models.service.IEmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping({"/empleados","/",""})
public class EmpleadoController {
    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping({"/index","/",""})
    public String index(Model model) {
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("titulo", "Lista de empleados");
        return "empleados/index";
    }

    @GetMapping(value = "/cargar-empleados/{term}",produces = {"application/json"})
    public @ResponseBody List<Empleado> cargarEmpleados(@PathVariable(name = "term")String term) {
        return empleadoService.findByNombre(term);
    }
    
}
