package com.capgemini.HEAR.model;

public abstract class Price extends Base {

    private double price;

    public Price(){}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Price(String name, double price){
        super(name);
        this.price = price;
    }

}
