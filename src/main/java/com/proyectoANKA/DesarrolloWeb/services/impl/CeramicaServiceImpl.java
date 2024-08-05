/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.services.impl;

import com.proyectoANKA.DesarrolloWeb.dao.CeramicaDao;
import com.proyectoANKA.DesarrolloWeb.domain.Ceramica;
import com.proyectoANKA.DesarrolloWeb.services.CeramicaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CeramicaServiceImpl implements CeramicaServices {

    @Autowired
    private CeramicaDao ceramicaDao;

    @Override
    @Transactional(readOnly = true)
    
    public List<Ceramica> getCeramicas(boolean activos) {
        var lista = ceramicaDao.findAll();
        
        if (activos) {
            lista.removeIf(c -> !c.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)

    public Ceramica getCeramica(Ceramica ceramica) {
        return ceramicaDao.findById(ceramica.getIdCeramica()).orElse(null);
    }

    @Override
    @Transactional

    public void save(Ceramica ceramica) {
        ceramicaDao.save(ceramica);
    }

    @Override
    @Transactional

    public void delete(Ceramica ceramica) {
        ceramicaDao.delete(ceramica);
    }
    
    @Override
    @Transactional (readOnly=true)
    public List<Ceramica> metodoSQL(String nombreInf) {
         return ceramicaDao.consultaSQL(nombreInf);
    }
}