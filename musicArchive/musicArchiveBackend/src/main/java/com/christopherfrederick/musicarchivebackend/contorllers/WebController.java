package com.christopherfrederick.musicarchivebackend.contorllers;


import com.christopherfrederick.musicarchivebackend.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class WebController {


    private final StorageService storageService;

    @Autowired
    public WebController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String getIndex(Model model){

        model.addAttribute("songFileNames", storageService.getSongFileNames());

        return "index";
    }

    @GetMapping("/song")
    public String getSong(Model model){

        model.addAttribute("songFileNames", storageService.getSongFileNames());

        return "play";
    }

    @PostMapping
    public String handleFileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        storageService.uploadSong(file);
        return "redirect:/";
    }
}
