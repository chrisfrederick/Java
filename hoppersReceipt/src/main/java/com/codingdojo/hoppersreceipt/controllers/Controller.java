package com.codingdojo.hoppersreceipt.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/")
    public String index(Model model){
        String customer = "Grace Hopper";
        String item = "Copper Wire";
        String price = "$5.25";
        String description = "Metal strips.Also an illustration of nanoseconds";
        String vendor = "Little Things Corner Store";

        model.addAttribute("name", customer);
        model.addAttribute("item", item);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);

        return "index.jsp";
    }
}
