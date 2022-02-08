package com.example.prueba.retoopcional.models.service;

import java.util.List;

import com.example.prueba.retoopcional.models.entity.Empleado;

public interface IEmpleadoService {
    public List<Empleado> findAll();
    public Empleado findById(Long id);
    public List<Empleado> findByNombre(String term);
    public Double getSalario(Empleado empleado, Integer cantidad);
    
}
