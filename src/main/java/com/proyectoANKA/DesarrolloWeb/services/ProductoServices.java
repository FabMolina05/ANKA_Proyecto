package com.proyectoANKA.DesarrolloWeb.services;

import com.proyectoANKA.DesarrolloWeb.domain.Producto;
import java.util.List;

public interface ProductoServices  {

    public List<Producto> getProductos(boolean activos);
    
    public Producto getProducto(Producto producto);
    
    public void  save(Producto producto);
    
    public void  delete(Producto producto);

    public List<Producto>metodoSQL(String nombreInf);

}
