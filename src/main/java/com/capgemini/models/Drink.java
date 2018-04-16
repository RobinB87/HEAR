package com.capgemini.models;

public class Drink extends MenuItem {

    private int volume;

    public Drink(String name, double price) {
        super(name, price);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
