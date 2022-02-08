package com.example.prueba.retoopcional.models.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.prueba.retoopcional.models.dao.IEmpleadoDao;
import com.example.prueba.retoopcional.models.entity.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {
    private SimpleDateFormat formatoDeAño = new SimpleDateFormat("yyyy");
    @Autowired
    private IEmpleadoDao empleadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findByNombre(String term) {
        return empleadoDao.findByNombre(term);
    }

    @Override
    public Double getSalario(Empleado empleado, Integer cantidad) {
        // Agregamos bono por antiguedad
        int añoActual = Integer.parseInt(formatoDeAño.format(new Date()));
        Double sueldo = empleado.getSalarioBase();
        // bono de ventas + bono de antiguedad + salario base
        return (sueldo * (cantidad * 5) / 100) + (sueldo * ((añoActual - empleado.getCreatedAt()) * 5) / 100) + sueldo;
    }

}
