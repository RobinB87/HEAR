package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Entities.Category;
import com.capgemini.HEAR.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    ICategoryRepository categoryRepository;

    @GetMapping("/all")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    //get id
    @GetMapping("/get/{id}")
    public Category getCategory(@PathVariable int id) {

        return categoryRepository.findById(id).isPresent() ? categoryRepository.findById(id).get() : null;
    }

    //edit
    @GetMapping("/edit/{id}/{title}")
    public Category editCategory(@PathVariable int id, @PathVariable String title){

        if(categoryRepository.findById(id).isPresent()){
            Category category = categoryRepository.findById(id).get();
            category.setTitle(title);

            return categoryRepository.save(category);
        }
        return null;
    }



    //delete
}
