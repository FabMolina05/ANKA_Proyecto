/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.controller;
import com.proyectoANKA.DesarrolloWeb.services.ProductoServices;

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
    private ProductoServices productoService;

    
    
    
    @PostMapping("/query")
    public String query(
            @RequestParam(value="nombreInf") String nombreInf,
            Model model) {
        
        
        var producto = productoService.metodoSQL(nombreInf);
        
        model.addAttribute("productos", producto);

        model.addAttribute("nombreInf", nombreInf);
        
        

        return "/search/listado";
    }
    


    
}


