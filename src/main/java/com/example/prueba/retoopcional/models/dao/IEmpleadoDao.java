package com.example.prueba.retoopcional.models.dao;

import java.util.List;

import com.example.prueba.retoopcional.models.entity.Empleado;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoDao extends CrudRepository<Empleado,Long> {
    @Query("select e from Empleado e where e.nombre like %?1%")
    public List<Empleado> findByNombre(String term);

}
