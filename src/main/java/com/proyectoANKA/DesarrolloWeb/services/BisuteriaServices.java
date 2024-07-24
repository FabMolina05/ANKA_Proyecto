/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.services;

import com.proyectoANKA.DesarrolloWeb.domain.Bisuteria;
import java.util.List;

public interface BisuteriaServices  {
    
    // Se obtiene un listado de registros de categorías
    // en un ArrayList (pueden ser todas o solo las activas)
    
    public List<Bisuteria> getBisuterias(boolean activos);
    
    public Bisuteria getBisuteria(Bisuteria categoria);
    
    public void  save(Bisuteria categoria);
    
        public void  delete(Bisuteria categoria);


    
}
