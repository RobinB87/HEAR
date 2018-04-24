package com.capgemini.HEAR.model;

public abstract class Base {

    private String name;

    public Base(){}

    public Base(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
