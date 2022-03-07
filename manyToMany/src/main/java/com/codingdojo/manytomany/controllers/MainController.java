package com.codingdojo.manytomany.controllers;

import com.codingdojo.manytomany.models.Product;
import com.codingdojo.manytomany.services.CategoryService;
import com.codingdojo.manytomany.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        List<Product> products = productService.allProducts();
    }
}
