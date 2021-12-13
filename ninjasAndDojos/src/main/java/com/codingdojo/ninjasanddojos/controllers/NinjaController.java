package com.codingdojo.ninjasanddojos.controllers;


import com.codingdojo.ninjasanddojos.models.Dojo;
import com.codingdojo.ninjasanddojos.models.Ninja;
import com.codingdojo.ninjasanddojos.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NinjaController {
    @Autowired
    NinjaService ninjaService;

//    @GetMapping("/")
//    public String ninjaIndex(Model model){
//        List<Ninja> ninjas = ninjaService.allNinjas();
//        model.addAttribute(ninjas);
//        return "index.jsp";
//    }

    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("newNinja") Ninja ninja, Model model){
        List<Dojo> dojos = ninjaService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newNinja.jsp";
    }

    @PostMapping("/create/ninja")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model){
        if(result.hasErrors()){
            System.out.println(result);
            List<Dojo> dojos = ninjaService.allDojos();
            model.addAttribute("dojos", dojos);
            return "newNinja.jsp";
        } else {
            ninjaService.saveNinja(ninja);
            return "redirect:/";
        }
    }

//    @GetMapping("/dojos/{id}")
//    public String getDojoById(
//            Model model,
//            @PathVariable(value = "id")Long id
//    ){
//        Dojo dojo = ninjaService.findDojoById(id);
//        model.addAttribute("dojo", dojo);
//        return "dojoNinja.jsp";
//    }
}
