package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Entities.Dish;
import com.capgemini.HEAR.model.Entities.Drink;
import com.capgemini.HEAR.repository.IDishRepository;
import com.capgemini.HEAR.repository.IDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping("/api/menuitem")
public class MenuItemController {

    @Autowired
    private IDishRepository dishRepository;

    @Autowired
    private IDrinkRepository drinkRepository;


    /**
     * Dishes: same methods as in category and subcategory
     * @param dish
     * @return
     */

    @PostMapping("/dish/add")
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @GetMapping("/dish/all")
    public Iterable<Dish> getDishes() {
        return dishRepository.findAll();
    }

    @GetMapping("/dish/get/{id}")
    public Dish getDish(@PathVariable int id){
        return dishRepository.findById(id).isPresent() ? dishRepository.findById(id).get() : null;
    }

    @PostMapping("/dish/edit")
    public Dish editDish(Dish dish){
        return dishRepository.save(dish);
    }

    @GetMapping("/dish/delete/{id}")
    public Dish deleteDish(@PathVariable int id){
        if(dishRepository.findById(id).isPresent()){
            dishRepository.deleteById(id);
        }
        return null;
    }


    /**
     * Drinks: same methods as in category and subcategory
     * @param drink
     * @return
     */

    @PostMapping("/drink/add")
    public Drink addDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    @GetMapping("/drink/all")
    public Iterable<Drink> getDrinks() {
        return drinkRepository.findAll();
    }

    @GetMapping("/drink/get/{id}")
    public Drink getDrink(@PathVariable int id){
        return drinkRepository.findById(id).isPresent() ? drinkRepository.findById(id).get() : null;
    }

    @PostMapping("/drink/edit")
    public Drink editDrink(Drink drink){
        return drinkRepository.save(drink);
    }

    @GetMapping("/drink/delete/{id}")
    public Drink deleteDrink(@PathVariable int id){
        if(drinkRepository.findById(id).isPresent()){
            drinkRepository.deleteById(id);
        }
        return null;
    }
}
