package com.capgemini.data;

import com.capgemini.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class DataList {

    public List<Ingredient> ingredienten = new ArrayList<>();

    public void fillList(Ingredient ingredient) {
        this.ingredienten.add(ingredient);
    }
}
