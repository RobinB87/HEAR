package com.capgemini.HEAR.data;

import com.capgemini.HEAR.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataList {

    private List<Category> categories = new ArrayList<>();
    private List<SubCategory> subCategories = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Dish> dishes = new ArrayList<>();

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    //Constructor which gets the fillDishes method -> which gets the dishes
    public DataList() {
        this.fillDishes();
        this.fillSubCategories();
        this.fillCategories();
    }

    private void fillCategories() {
        this.breakfast();
        this.lunch();
    }

    private void breakfast() {
        List<SubCategory> subCategories = new ArrayList<>();
        subCategories.add(this.subCategories.get(0));
        this.categories.add(new Category("Breakfast", subCategories));
    }

    private void lunch() {
        List<SubCategory> subCategories = new ArrayList<>();
        subCategories.add(this.subCategories.get(1));
        this.categories.add(new Category("Lunch", subCategories));
    }

    private void fillSubCategories(){
        this.starter();
        this.mainCourse();
    }

    private void starter(){
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(this.dishes.get(1));
        this.subCategories.add(new SubCategory("Tosti's", menuItems));
    }

    private void mainCourse(){
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(this.dishes.get(0));
        this.subCategories.add(new SubCategory("Main course", menuItems));
    }


    private void fillDishes() {
        this.spaghetti();
        this.carpaccio();
    }

    //Methods to create dishes and ingredients for these dishes
    private void spaghetti() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Tomato", 0.23));
        ingredients.add(new Ingredient("Cheese", 1.34));
        ingredients.add(new Ingredient("Mozarrella", 1.99));

        this.dishes.add(new Dish("Spaghetti", 14.99, ingredients));
    }

    private void carpaccio() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Pine nuts", 0.99));
        ingredients.add(new Ingredient("Rucola", 0.34));
        ingredients.add(new Ingredient("Tenderloin", 4.88));

        this.dishes.add(new Dish("Carpaccio", 8.99, ingredients));
    }
}
