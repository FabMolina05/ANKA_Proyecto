/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.controller;
import com.proyectoANKA.DesarrolloWeb.domain.Bisuteria;
import com.proyectoANKA.DesarrolloWeb.services.BisuteriaServices;
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
@RequestMapping("/bisuteria")

public class BisuteriaController {

    @Autowired
    private BisuteriaServices bisuteriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = bisuteriaService.getBisuterias(true);
        model.addAttribute("bisuterias", lista);
        model.addAttribute("totalBisuterias", lista.size());
    
   
        return "/bisuteria/listado";
    }
    


    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Bisuteria bisuteria, @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            bisuteriaService.save(bisuteria);
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "bisuteria", bisuteria.getIdBisuteria());

            bisuteria.setRutaImagen(rutaImagen);
        }
        bisuteriaService.save(bisuteria);

        return "redirect:/bisuteria/listado";
    }

    @GetMapping("/eliminar/{idBisuteria}")
    public String eliminar(Bisuteria bisuteria) {

        bisuteriaService.delete(bisuteria);

        return "redirect:/bisuteria/listado";

    }
    
    @GetMapping("/modificar/{idBisuteria}")
    public String modificar(Bisuteria bisuteria,Model model) {

        bisuteria = bisuteriaService.getBisuteria(bisuteria);
        model.addAttribute("bisuteria",bisuteria);
        

        return "/bisuteria/modifica";

    }
    
}


