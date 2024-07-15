
package com.prueba_a.controller;
import com.prueba_a.domain.Casa;
import com.prueba_a.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/casa")

public class CasaController {

    @Autowired
    private CasaService casaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = casaService.getCasas();
        model.addAttribute("casas", lista);
        model.addAttribute("totalCasas", lista.size());
        return "/casa/listado";
    }
    

    @PostMapping("/guardar")
    public String guardar(Casa casa) {

        casaService.save(casa);

        return "redirect:/casa/listado";
    }

    @GetMapping("/eliminar/{idCasa}")
    public String eliminar(Casa casa) {

        casaService.delete(casa);

        return "redirect:/casa/listado";

    }
    
    @GetMapping("/modificar/{idCasa}")
    public String modificar(Casa casa,Model model) {

        casa = casaService.getCasa(casa);
        model.addAttribute("casa",casa);
        

        return "/casa/modifica";

    }
    
}


