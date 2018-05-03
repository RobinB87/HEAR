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

    @GetMapping("/")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
}
