package com.capgemini.models;

public abstract class PriceClass extends BaseClass {

    private double price;

    public PriceClass(String name, double price) {
        super(name);
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
