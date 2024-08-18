/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.controller;
import com.proyectoANKA.DesarrolloWeb.domain.Producto;
import com.proyectoANKA.DesarrolloWeb.services.CategoriaServices;
import com.proyectoANKA.DesarrolloWeb.services.ProductoServices;
import java.util.ArrayList;

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

       @Autowired
    private CategoriaServices categoriaService;

    
    
    @PostMapping("/query")
    public String query(
            @RequestParam(value="nombreInf") String nombreInf,
            Model model) {
        
        
         ArrayList<Producto> producto = new ArrayList();
        for (Producto producto1 : productoService.metodoSQL(nombreInf)) {
             
            if (producto1.isActivo()) {
                producto.add(producto1);
            }
            
         }
        
        var productos = producto;
        
        
        
        
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        
        
        
        model.addAttribute("productos", productos);

        model.addAttribute("nombreInf", nombreInf);
        
        

        return "/search/listado";
    }
    


    
}


