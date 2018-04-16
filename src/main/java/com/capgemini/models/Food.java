package com.capgemini.models;

public class Food extends MenuItem {

    private Ingredient[] ingredients;

    public Food(String name, double price) {
        super(name, price);
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }
}
