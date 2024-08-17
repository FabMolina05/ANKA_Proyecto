/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.controller;
import com.proyectoANKA.DesarrolloWeb.services.ArteServices;
import com.proyectoANKA.DesarrolloWeb.services.BisuteriaServices;
import com.proyectoANKA.DesarrolloWeb.services.CeramicaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class IndexController {

    @Autowired
    private CeramicaServices ceramicaService;
        @Autowired
    private ArteServices arteService;
            @Autowired
    private BisuteriaServices bisuteriaService;

    @GetMapping("/")
    public String listado(Model model) {
        var ceramica = ceramicaService.getCeramicas(true);
        model.addAttribute("ceramicas", ceramica);
        
         var arte = arteService.getArtes(true);
        model.addAttribute("artes", arte);
        
         var bisuteria = bisuteriaService.getBisuterias(true);
        model.addAttribute("bisuterias",bisuteria);
        
        
   
        return "index";
    }
    
    
    


    
}


