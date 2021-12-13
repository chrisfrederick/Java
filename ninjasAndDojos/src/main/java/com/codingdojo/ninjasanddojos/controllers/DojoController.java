package com.codingdojo.ninjasanddojos.controllers;


import com.codingdojo.ninjasanddojos.models.Dojo;
import com.codingdojo.ninjasanddojos.models.Ninja;
import com.codingdojo.ninjasanddojos.services.DojoService;
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
public class DojoController {
    @Autowired
    DojoService dojoService;

    @GetMapping("/")
    public String dojoIndex(Model model){
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "index.jsp";
    }

    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("newDojo") Dojo dojo, Model model){
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newDojo.jsp";
    }

    @PostMapping("/create/dojo")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result);
            return "newDojo.jsp";
        } else {
            dojoService.saveDojo(dojo);
            return "redirect:/";
        }
    }

    @GetMapping("/dojos/{id}")
    public String getDojoById(
            Model model,
            @PathVariable(value = "id")Long id
    ){
        Dojo dojo = dojoService.findDojoById(id);

        model.addAttribute("dojo", dojo);
        return "dojoNinja.jsp";
    }





}
