package com.capgemini.HEAR.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Price extends Base {

    private double costPrice;
    private double sellingPrice;

    public Price() {}

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }
}
