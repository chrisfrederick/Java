package com.codingdojo.counter.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CounterController {

    @RequestMapping("/")
    public String homeRoute(HttpSession session, Model model){

        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }else{
            session.setAttribute("count", ((Integer)session.getAttribute("count")+1));
        }
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counterRoute(HttpSession session, Model model){
        Integer currentCount = (Integer) session.getAttribute("count");
        model.addAttribute("countToShow", currentCount);
        return "counter.jsp";
    }
}
