package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.DTO.DishDTO;
import com.capgemini.HEAR.model.DTO.DrinkDTO;
import com.capgemini.HEAR.model.Entities.Dish;
import com.capgemini.HEAR.model.Entities.Drink;
import com.capgemini.HEAR.model.Entities.SubCategory;
import com.capgemini.HEAR.repository.IDishRepository;
import com.capgemini.HEAR.repository.IDrinkRepository;
import com.capgemini.HEAR.repository.ISubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/menuitem")
public class MenuItemController {

    @Autowired
    private IDishRepository dishRepository;

    @Autowired
    private IDrinkRepository drinkRepository;

    @Autowired
    private ISubCategoryRepository subCategoryRepository;


    /**
     * Dishes: same methods as in category and subcategory
     * @param dish
     * @return
     */

    @PostMapping("/dish/add/{subcategoryId}")
    public Dish addDish(@PathVariable int subcategoryId, Dish dish) {

        SubCategory subCategory = subCategoryRepository.findById(subcategoryId).isPresent() ? subCategoryRepository.findById(subcategoryId).get() : null;
        dish.setSubCategory(subCategory);
        subCategory.addDish(dish);
        subCategoryRepository.save(subCategory);

        return dish;
    }

    @GetMapping("/dish/all")
    public Iterable<Dish> getDishes() {
        return dishRepository.findAll();
    }

    @GetMapping("/dish/formatted/all")
    public List<DishDTO> getDishesDTO() {
        List<DishDTO> dishDTOList = new ArrayList<>();

        for(Dish dish : dishRepository.findAll()) {
            DishDTO dto = new DishDTO(dish);
            dishDTOList.add(dto);
        }

        return dishDTOList;
    }

    @GetMapping("/dish/get/{id}")
    public Dish getDish(@PathVariable int id){
        return dishRepository.findById(id).isPresent() ? dishRepository.findById(id).get() : null;
    }

    @GetMapping("/dish/formatted/get/{id}")
    public DishDTO getDishDto(@PathVariable int id) {
        return new DishDTO(dishRepository.findById(id).isPresent() ? dishRepository.findById(id).get() : null);
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
    @PostMapping("/drink/add/{subcategoryId}")
    public Drink addDrink(@PathVariable int subcategoryId, Drink drink) {

        SubCategory subCategory = subCategoryRepository.findById(subcategoryId).isPresent() ? subCategoryRepository.findById(subcategoryId).get() : null;
        drink.setSubcategory(subCategory);
        subCategory.addDrink(drink);
        subCategoryRepository.save(subCategory);

        return drink;
    }

    @GetMapping("/drink/all")
    public Iterable<Drink> getDrinks() {
        return drinkRepository.findAll();
    }

    @GetMapping("/drink/formatted/get{id}")
    public DrinkDTO getDrinkDto(@PathVariable int id){
        return new DrinkDTO(drinkRepository.findById(id).isPresent() ? drinkRepository.findById(id).get() : null);
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
