/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.controller;

import com.proyectoANKA.DesarrolloWeb.services.CategoriaServices;
import com.proyectoANKA.DesarrolloWeb.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {

    @Autowired
    private ProductoServices productoService;

    @Autowired
    private CategoriaServices categoriaService;

    @GetMapping("/")
    public String listado(Model model) {

        var producto = productoService.getProductos(true);
        model.addAttribute("productos", producto);

        var categoria = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categoria);

        return "index";
        
    }

    @GetMapping("/conocenos")
    public String conocenos(Model model) {

        var categoria = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categoria);
  
        return "/conocenos/fragmentos";

    }
}
