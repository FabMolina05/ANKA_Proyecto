/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.services;

import com.proyectoANKA.DesarrolloWeb.domain.Categoria;
import java.util.List;

public interface CategoriaServices  {
    
    // Se obtiene un listado de registros de categorías
    // en un ArrayList (pueden ser todas o solo las activas)
    
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void  save(Categoria categoria);
    
        public void  delete(Categoria categoria);


    
}
