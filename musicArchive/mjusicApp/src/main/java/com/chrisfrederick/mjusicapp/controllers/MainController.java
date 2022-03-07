package com.chrisfrederick.mjusicapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MainController {

    @GetMapping("/react")
    public String accessReact(){
        return "index";
    }
}
