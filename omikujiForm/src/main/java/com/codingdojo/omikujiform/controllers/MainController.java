package com.codingdojo.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "omikuji.jsp";
    }

    @PostMapping("/form")
    public String form(
            HttpSession session,
            @RequestParam(value="number") String number,
            @RequestParam(value="city") String city,
            @RequestParam(value="person") String person,
            @RequestParam(value="hobby") String hobby,
            @RequestParam(value="thing") String thing,
            @RequestParam(value="nice") String nice){
        session.setAttribute("city", city);
        session.setAttribute("number", number);
        session.setAttribute("person", person);
        session.setAttribute("hobby", hobby);
        session.setAttribute("thing", thing);
        session.setAttribute("nice", nice);
                return "redirect:/show";
    }

    @GetMapping("/show")
    public String show(HttpSession session, Model model){
        String city = (String)session.getAttribute("city");
        String number = (String)session.getAttribute("number");
        String person = (String)session.getAttribute("person");
        String hobby = (String)session.getAttribute("hobby");
        String thing = (String)session.getAttribute("thing");
        String nice = (String)session.getAttribute("nice");
        model.addAttribute("city", city);
        model.addAttribute("number", number);
        model.addAttribute("person", person);
        model.addAttribute("hobby", hobby);
        model.addAttribute("thing", thing);
        model.addAttribute("nice", nice);
        return "show.jsp";
    }

}
