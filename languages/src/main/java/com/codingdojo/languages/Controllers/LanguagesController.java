package com.codingdojo.languages.Controllers;

import com.codingdojo.languages.Models.Language;
import com.codingdojo.languages.Services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguagesController {
    @Autowired
    LanguageService languageService;

    @GetMapping("/languages")
    public String index(Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("language", languages);
        return "index.jsp";
    }

    @GetMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language){
        return "create.jsp";
    }

    @PostMapping("/languages/create")
    public String createNew(
            @Valid
            @ModelAttribute("language") Language language, BindingResult result
    ){
        if(result.hasErrors()){
            return "create.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    @GetMapping("/languages/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model){
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }

    @PutMapping("languages/{id}")
    public  String update(@Valid @ModelAttribute("language") Language language, BindingResult result){
        if(result.hasErrors()){
            return "edit.jsp";
        }else{
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }

    @GetMapping("/languages/{id}")
    public String getLanguageById(
            Model model,
            @PathVariable(value = "id") Integer id
    ){
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "detail.jsp";
    }

    @PostMapping(value ="/languages/destroy/{id}")
    public String destroy(@PathVariable("id") Integer id){
        languageService.delete(id);
        return "redirect:/languages";
    }


}
