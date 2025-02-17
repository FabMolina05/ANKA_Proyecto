package com.proyectoANKA.DesarrolloWeb.services.impl;

import com.proyectoANKA.DesarrolloWeb.dao.ProductoDao;
import com.proyectoANKA.DesarrolloWeb.domain.Producto;
import com.proyectoANKA.DesarrolloWeb.services.ProductoServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoServices {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();

        if (activos) {
            lista.removeIf(c -> !c.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)

    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional

    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional

    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    @Override
    @Transactional (readOnly=true)
    public List<Producto> metodoSQL(String nombreInf) {
         return productoDao.consultaSQL(nombreInf);
    }
    

}
