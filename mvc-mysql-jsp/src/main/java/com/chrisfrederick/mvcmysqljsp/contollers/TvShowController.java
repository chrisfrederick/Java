package com.chrisfrederick.mvcmysqljsp.contollers;

import com.chrisfrederick.mvcmysqljsp.models.User;
import com.chrisfrederick.mvcmysqljsp.models.TvShow;
import com.chrisfrederick.mvcmysqljsp.services.TvShowService;
import com.chrisfrederick.mvcmysqljsp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TvShowController {
    @Autowired
    private TvShowService tvShowService;
    @Autowired
    private UserService userService;

    @GetMapping("/shows/new")
    public String newShow(@ModelAttribute("newShow") TvShow tvShow, Model model, HttpSession session, RedirectAttributes redirectAttributes){
        Long userId = (Long)session.getAttribute("user_id");
        if(userId == null){
            redirectAttributes.addFlashAttribute("notLoggedIn", "You must be logged in");
            return "redirect:/";
        }else{
            model.addAttribute("userId", userId);
            return "newShow.jsp";
        }
    }

    @PostMapping("/create/show")
    public String createNew(@Valid @ModelAttribute("newShow") TvShow tvShow, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            System.out.println(result);
            Long userId = (Long)session.getAttribute("user_id");
            model.addAttribute("userId", userId);
            return "newShow.jsp";
        } else {
            tvShowService.createShow(tvShow);
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/shows/{id}")
    public String getShowById(Model model, @PathVariable(value = "id")Long id, HttpSession session, RedirectAttributes redirectAttributes){
        Long userId = (Long)session.getAttribute("user_id");
        if(userId == null){
            redirectAttributes.addFlashAttribute("notLoggedIn", "You must be logged in");
            return "redirect:/";
        }else {
            TvShow tvShow = tvShowService.findShowById(id);
            User user = userService.findUserById(id);
            model.addAttribute("user", user);
            model.addAttribute("tvShow", tvShow);
            return "showDetail.jsp";
        }
    }




    @GetMapping("/shows/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes){
        Long userId = (Long)session.getAttribute("user_id");
        if(userId == null){
            redirectAttributes.addFlashAttribute("notLoggedIn", "You must be logged in");
            return "redirect:/";
        }else {
            TvShow tvShow = tvShowService.findShowById(id);
            model.addAttribute("tvShow", tvShow);
            model.addAttribute("userId", userId);
            return "edit.jsp";
        }
    }

    @PutMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("tvShow") TvShow tvShow, BindingResult result){
        if(result.hasErrors()){
            return "edit.jsp";
        }else{
            System.out.println(tvShow.getId());
            tvShowService.updateShow(tvShow);
            return "redirect:/dashboard";
        }
    }

    @DeleteMapping(value="/shows/destroy/{id}")
    public String destroy(@PathVariable("id") Long id){
        tvShowService.deleteShow(id);
        return "redirect:/dashboard";
    }
}
