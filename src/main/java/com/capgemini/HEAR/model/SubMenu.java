package com.capgemini.HEAR.model;

import java.util.List;

public abstract class SubMenu extends Base {

    private List<MenuItem> menuItems;

    public SubMenu(){}

    public SubMenu(String name){
        super(name);
    }

}
