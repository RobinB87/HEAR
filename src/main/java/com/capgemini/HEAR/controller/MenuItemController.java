package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Entities.Dish;
import com.capgemini.HEAR.model.Entities.Drink;
import com.capgemini.HEAR.repository.IDishRepository;
import com.capgemini.HEAR.repository.IDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menuitem")
public class MenuItemController {

    @Autowired
    private IDishRepository dishRepository;

    @Autowired
    private IDrinkRepository drinkRepository;

    @PostMapping("/dish/add")
    public Dish addDish(Dish dish){
       return dishRepository.save(dish);
    }

    @PostMapping("/drink/add")
    public Drink addDrink(Drink drink) {
        return drinkRepository.save(drink);
    }


//    @PostMapping("/api/drink/add")
//    public
}
