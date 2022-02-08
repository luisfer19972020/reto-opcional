package com.example.prueba.retoopcional.models.service;

import java.util.List;

import com.example.prueba.retoopcional.models.entity.Pago;

public interface IPagoService {
    List<Pago> findAll();
    public Pago findById(Long id);
    public void save(Pago pago);
}
