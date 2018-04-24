package com.capgemini.HEAR.model;

import java.util.ArrayList;
import java.util.List;

public class Category extends Base {

    //For example: breakfast, lunch, dinner

    public Category(){}

    private List<SubCategory> subCategories;

    public Category(String name, List<SubCategory> subCategories){
        super(name);
        this.subCategories = subCategories;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }
}
