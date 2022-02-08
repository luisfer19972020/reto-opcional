package com.example.prueba.retoopcional.models.service;

import java.util.List;

import com.example.prueba.retoopcional.models.dao.IPagoDao;
import com.example.prueba.retoopcional.models.entity.Pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagoServceImp implements IPagoService {

    @Autowired
    private IPagoDao pagoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Pago> findAll() {
        return (List<Pago>) pagoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pago findById(Long id) {
        return pagoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Pago pago) {
        pagoDao.save(pago);
    }
    
}
