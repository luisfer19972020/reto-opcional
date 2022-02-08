package com.example.prueba.retoopcional.models.dao;

import com.example.prueba.retoopcional.models.entity.Pago;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IPagoDao extends CrudRepository<Pago,Long>{
    
}
