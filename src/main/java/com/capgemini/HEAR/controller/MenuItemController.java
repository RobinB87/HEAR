package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Entities.Dish;
import com.capgemini.HEAR.model.Entities.Drink;
import com.capgemini.HEAR.repository.IDishRepository;
import com.capgemini.HEAR.repository.IDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menuitem")
public class MenuItemController {

    @Autowired
    private IDishRepository dishRepository;

    @Autowired
    private IDrinkRepository drinkRepository;

    @PostMapping("/dish/add")
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @GetMapping("/dish/all")
    public Iterable<Dish> getDishes() {
        return dishRepository.findAll();
    }

    //get id
    //edit
    //delete


    @PostMapping("/drink/add")
    public Drink addDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    @GetMapping("/drink/all")
    public Iterable<Drink> getDrinks() {
        return drinkRepository.findAll();
    }

    //get id
    //edit
    //delete

}
