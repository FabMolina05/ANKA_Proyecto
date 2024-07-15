/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba_a.service.impl;

import com.prueba_a.dao.CasaDao;
import com.prueba_a.domain.Casa;
import com.prueba_a.service.CasaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CasaServiceImpl implements CasaService {

    @Autowired
    private CasaDao casaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Casa> getCasas() {
        var lista = casaDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)

    public Casa getCasa(Casa casa) {
        return casaDao.findById(casa.getIdCasa()).orElse(null);
    }

    @Override
    @Transactional

    public void save(Casa casa) {
        casaDao.save(casa);
    }

    @Override
    @Transactional

    public void delete(Casa casa) {
        casaDao.delete(casa);
    }
}