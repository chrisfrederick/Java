package com.codingdojo.manytomany.services;

import com.codingdojo.manytomany.models.Category;
import com.codingdojo.manytomany.repositories.CategoryRepo;
import com.codingdojo.manytomany.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo){
        this.categoryRepo=categoryRepo;
    }

    public List<Category> allCategories(){
        return categoryRepo.findAll();
    }

    public Category findCategory(Long id){
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }else{
            return null;
        }
    }


}
