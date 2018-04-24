package com.capgemini.HEAR.model;

import java.util.List;

public class Dish extends Price {

    private List<Ingredient> ingredients;

    public Dish(String name, double price){
        super(name, price);
    }
}
