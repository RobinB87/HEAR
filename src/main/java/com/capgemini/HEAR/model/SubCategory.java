package com.capgemini.HEAR.model;

import java.util.List;

public class SubCategory extends Base {

    private List<MenuItem> menuItems;

    public SubCategory(){}

    public SubCategory(String name, List<MenuItem> menuItems){
        super(name);
        this.menuItems = menuItems;
    }
}
