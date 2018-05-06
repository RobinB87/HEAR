package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Entities.Ingredient;
import com.capgemini.HEAR.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController  {

    @Autowired
    private IIngredientRepository ingredientRepository;

    @GetMapping("/all")
    public Iterable<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }

    @PostMapping("/add")
    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    //get id
    //edit
    //delete
}
