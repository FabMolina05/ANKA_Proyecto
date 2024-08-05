/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.services;

import com.proyectoANKA.DesarrolloWeb.domain.Arte;
import java.util.List;

public interface ArteServices  {
    
    // Se obtiene un listado de registros de categorías
    // en un ArrayList (pueden ser todas o solo las activas)
    
    public List<Arte> getArtes(boolean activos);
    
    public Arte getArte(Arte categoria);
    
    public void  save(Arte categoria);
    
        public void  delete(Arte categoria);

    public List<Arte>metodoSQL(String nombreInf);
    
    
}
