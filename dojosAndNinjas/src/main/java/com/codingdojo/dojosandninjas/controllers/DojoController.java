package com.codingdojo.dojosandninjas.controllers;


import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.services.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DojoController {
    @Autowired
    DojoService dojoService;

    @GetMapping("/")
    public String index(){
        return "index.jsp";
    }

    @GetMapping("/dojos")
    public String dojos(Model model){
        List<Dojo> dojos = dojoService.findAllDojos();
        model.addAttribute("dojos", dojos);
        return "showDojos.jsp";
    }

    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo")Dojo dojo){
        return "dojo.jsp";
    }

    @GetMapping("/dojos/ninjas")
    public String getNinjas(Model model){
        List<Dojo> ninjas = dojoService.findAllDojos();
        model.addAttribute(ninjas);
        return "ninjas.jsp";
    }

    @PostMapping("/dojos/create")
    public String createDojo(
            @Valid
            @ModelAttribute("dojo") Dojo dojo,
            BindingResult result
    ){
        if(result.hasErrors()){
            return "dojo.jsp";
        }else{
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
    }



}
