package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Entities.Ingredient;
import com.capgemini.HEAR.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController  {

    @Autowired
    private IIngredientRepository ingredientRepository;

    /**
     * Ingredients: same methods as in category and subcategory
     * @return
     */

    @GetMapping("/all")
    public Iterable<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }

    @PostMapping("/add")
    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id){
        Optional<Ingredient> optionalIngredient = this.ingredientRepository.findById(id);
        if(optionalIngredient.isPresent()) {
            return ResponseEntity.ok(optionalIngredient.get());
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/edit")
    public Ingredient editIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    @GetMapping("/delete/{id}")
    public Ingredient deleteIngredient(@PathVariable int id){
        if(ingredientRepository.findById(id).isPresent()){
            ingredientRepository.deleteById(id);
        }
        return null;
    }
}
