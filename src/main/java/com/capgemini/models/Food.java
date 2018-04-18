package com.capgemini.models;

import java.util.List;

public class Food extends MenuItem {

    private List<Ingredient> ingredients;

    public Food(String name, double price) {
        super(name, price);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
