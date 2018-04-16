package com.capgemini.models;

public abstract class BaseClass {

    private String name;

    public BaseClass(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
