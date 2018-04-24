package com.capgemini.HEAR.model;

public abstract class Price extends Base {

    private double price;

    public Price(String name, double price){
        super(name);
        this.price = price;
    }

}
