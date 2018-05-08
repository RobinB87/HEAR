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

    //get all categories
    @GetMapping("/all")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    //add a category
    @PostMapping("/add")
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    //get a category by id
    @GetMapping("/get/{id}")
    public Category getCategory(@PathVariable int id) {

        return categoryRepository.findById(id).isPresent() ? categoryRepository.findById(id).get() : null;
    }

    //edit a category
    @PostMapping("/edit")
    public Category editCategory(Category category) {
        return categoryRepository.save(category);
    }

    //delete a category by id
    @GetMapping("/delete/{id}")
    public Category deleteCategory(@PathVariable int id) {
        if(categoryRepository.findById(id).isPresent()){
            categoryRepository.deleteById(id);
        }
        return null;
    }
}
