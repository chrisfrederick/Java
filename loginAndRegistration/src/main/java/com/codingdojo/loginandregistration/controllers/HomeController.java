package com.codingdojo.loginandregistration.controllers;

import com.codingdojo.loginandregistration.models.Book;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.models.UserLogin;
import com.codingdojo.loginandregistration.services.BookService;
import com.codingdojo.loginandregistration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new UserLogin());
        return "index.jsp";
    }

    @GetMapping("/welcome")
    public String welcome(Model model, HttpSession session, RedirectAttributes redirectAttributes){
        Long userId = (Long)session.getAttribute("user_id");
        if(userId == null){
            redirectAttributes.addFlashAttribute("notLoggedIn", "You must be logged in");
            return "redirect:/";
        }else{
//        String userName = (String)session.getAttribute("userName");
        String userName = (String)session.getAttribute("userName");
        List<User> users = userService.findAll();
        model.addAttribute("userId", userId);
        model.addAttribute("userName",userName);
        model.addAttribute("users", users);
        return "welcome.jsp";
        }
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session){
        userService.register(newUser, result);
        if(result.hasErrors()){
            model.addAttribute("newLogin", new UserLogin());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        session.setAttribute("userName", newUser.getUserName());
        return "redirect:/welcome";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, BindingResult result, Model model, HttpSession session){
        User user = userService.login(newLogin, result);
        if(result.hasErrors()){
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }else{
            session.setAttribute("user_id", user.getId());
            session.setAttribute("userName", user.getUserName());
            return "redirect:/welcome";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        redirectAttributes.addFlashAttribute("loggedout","You have been logged out");
        return "redirect:/";
    }

}
