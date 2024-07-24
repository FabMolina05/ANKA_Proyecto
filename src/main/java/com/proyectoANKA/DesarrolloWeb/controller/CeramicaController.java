/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoANKA.DesarrolloWeb.controller;
import com.proyectoANKA.DesarrolloWeb.domain.Ceramica;
import com.proyectoANKA.DesarrolloWeb.services.CeramicaServices;
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
@RequestMapping("/ceramica")

public class CeramicaController {

    @Autowired
    private CeramicaServices ceramicaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = ceramicaService.getCeramicas(true);
        model.addAttribute("ceramicas", lista);
        model.addAttribute("totalCeramicas", lista.size());
    
   
        return "/ceramica/listado";
    }
    


    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Ceramica ceramica, @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            ceramicaService.save(ceramica);
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "ceramica", ceramica.getIdCeramica());

            ceramica.setRutaImagen(rutaImagen);
        }
        ceramicaService.save(ceramica);

        return "redirect:/ceramica/listado";
    }

    @GetMapping("/eliminar/{idCeramica}")
    public String eliminar(Ceramica ceramica) {

        ceramicaService.delete(ceramica);

        return "redirect:/ceramica/listado";

    }
    
    @GetMapping("/modificar/{idCeramica}")
    public String modificar(Ceramica ceramica,Model model) {

        ceramica = ceramicaService.getCeramica(ceramica);
        model.addAttribute("ceramica",ceramica);
        

        return "/ceramica/modifica";

    }
    
}


