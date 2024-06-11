
package com.tienda_L.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String inicio(Model model){
     
        model.addAttribute("mensaje"," Saludos a todos");
                model.addAttribute("edad",50);

        
        return "index";
        
    }
    
    
}
