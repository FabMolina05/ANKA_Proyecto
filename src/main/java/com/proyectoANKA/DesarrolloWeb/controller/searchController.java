/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.controller;
import com.proyectoANKA.DesarrolloWeb.domain.Ceramica;
import com.proyectoANKA.DesarrolloWeb.services.ArteServices;
import com.proyectoANKA.DesarrolloWeb.services.BisuteriaServices;
import com.proyectoANKA.DesarrolloWeb.services.CeramicaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")

public class searchController {

    @Autowired
    private CeramicaServices ceramicaService;
        @Autowired
    private ArteServices arteService;
            @Autowired
    private BisuteriaServices bisuteriaService;

    
    
    
    @PostMapping("/query")
    public String query(
            @RequestParam(value="nombreInf") String nombreInf,
            Model model) {
        
        
        var arte = arteService.metodoSQL(nombreInf);
        
        model.addAttribute("artes", arte);

        model.addAttribute("nombreInf", nombreInf);
        
         var bisuteria = bisuteriaService.metodoSQL(nombreInf);
        
        model.addAttribute("bisuterias", bisuteria );

        model.addAttribute("nombreInf", nombreInf);

         var ceramica = ceramicaService.metodoSQL(nombreInf);
        
        model.addAttribute("ceramicas", ceramica);

        model.addAttribute("nombreInf", nombreInf);


        return "/search/listado";
    }
    


    
}


