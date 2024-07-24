/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.services.impl;

import com.proyectoANKA.DesarrolloWeb.dao.ArteDao;
import com.proyectoANKA.DesarrolloWeb.domain.Arte;
import com.proyectoANKA.DesarrolloWeb.services.ArteServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArteServiceImpl implements ArteServices {

    @Autowired
    private ArteDao arteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arte> getArtes(boolean activos) {
        var lista = arteDao.findAll();
        
        if (activos) {
            lista.removeIf(c -> !c.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)

    public Arte getArte(Arte arte) {
        return arteDao.findById(arte.getIdArte()).orElse(null);
    }

    @Override
    @Transactional

    public void save(Arte arte) {
        arteDao.save(arte);
    }

    @Override
    @Transactional

    public void delete(Arte arte) {
        arteDao.delete(arte);
    }
}