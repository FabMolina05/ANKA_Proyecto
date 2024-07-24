/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.controller;
import com.proyectoANKA.DesarrolloWeb.domain.Arte;
import com.proyectoANKA.DesarrolloWeb.services.ArteServices;
import com.proyectoANKA.DesarrolloWeb.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/arte")

public class ArteController {

    @Autowired
    private ArteServices arteService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = arteService.getArtes(true);
        model.addAttribute("artes", lista);
        model.addAttribute("totalArtes", lista.size());
    
   
        return "/arte/listado";
    }
    


    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Arte arte, @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            arteService.save(arte);
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "arte", arte.getIdArte());

            arte.setRutaImagen(rutaImagen);
        }
        arteService.save(arte);

        return "redirect:/arte/listado";
    }

    @GetMapping("/eliminar/{idArte}")
    public String eliminar(Arte arte) {

        arteService.delete(arte);

        return "redirect:/arte/listado";

    }
    
    @GetMapping("/modificar/{idArte}")
    public String modificar(Arte arte,Model model) {

        arte = arteService.getArte(arte);
        model.addAttribute("arte",arte);
        

        return "/arte/modifica";

    }
    
}


