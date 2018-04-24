package com.capgemini.HEAR.model;

public abstract class MenuItem extends Price {

    //MenuItem is a drink or a dish

    public MenuItem(String name, double price){
        super(name, price);
    }
}
