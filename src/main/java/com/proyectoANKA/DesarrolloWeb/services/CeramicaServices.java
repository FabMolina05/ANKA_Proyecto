/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.services;

import com.proyectoANKA.DesarrolloWeb.domain.Arte;
import com.proyectoANKA.DesarrolloWeb.domain.Ceramica;
import java.util.List;

public interface CeramicaServices  {
    
    // Se obtiene un listado de registros de categorías
    // en un ArrayList (pueden ser todas o solo las activas)
    
    public List<Ceramica> getCeramicas(boolean activos);
    
    public Ceramica getCeramica(Ceramica ceramica);
    
    public void  save(Ceramica ceramica);
    
        public void  delete(Ceramica ceramica);

    public List<Ceramica>metodoSQL(String nombreInf);

    
}
