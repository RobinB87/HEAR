package com.capgemini.HEAR.model;

import java.util.ArrayList;
import java.util.List;

public class Dish extends Price {

    public Dish(){}

    private List<Ingredient> ingredientList = new ArrayList<>();

    public Dish(String name, double price, ArrayList<Ingredient> ingredientList){
        super(name, price);
        this.ingredientList = ingredientList;
    }
}
