/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.services.impl;

import com.proyectoANKA.DesarrolloWeb.dao.BisuteriaDao;

import com.proyectoANKA.DesarrolloWeb.domain.Bisuteria;
import com.proyectoANKA.DesarrolloWeb.services.BisuteriaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BisuteriaServiceImpl implements BisuteriaServices {

    @Autowired
    private BisuteriaDao bisuteriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Bisuteria> getBisuterias(boolean activos) {
        var lista = bisuteriaDao.findAll();
        
        if (activos) {
            lista.removeIf(c -> !c.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)

    public Bisuteria getBisuteria(Bisuteria bisuteria) {
        return bisuteriaDao.findById(bisuteria.getIdBisuteria()).orElse(null);
    }

    @Override
    @Transactional

    public void save(Bisuteria bisuteria) {
        bisuteriaDao.save(bisuteria);
    }

    @Override
    @Transactional

    public void delete(Bisuteria bisuteria) {
        bisuteriaDao.delete(bisuteria);
    }
    
    @Override
    @Transactional (readOnly=true)
    public List<Bisuteria> metodoSQL(String nombreInf) {
         return bisuteriaDao.consultaSQL(nombreInf);
    }
}