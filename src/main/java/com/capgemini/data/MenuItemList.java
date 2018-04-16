package com.capgemini.data;

import com.capgemini.models.Drink;
import com.capgemini.models.Food;
import com.capgemini.models.MenuItem;

public class MenuItemList {

    public MenuItem[] items = new MenuItem[] {
        new Food("Steak", 15),
            new Food("Pasta", 10),
            new Food("Lobster", 35),
            new Food("Carpaccio", 7.5),
            new Food("Dame Blanche", 5),
            new Food("Kaasplankje", 15),
            new Drink("Koffie", 3.5),
            new Drink("Melk", 1.5),
            new Drink("Schultenbrau", 0.5),
            new Drink("Vino", 3)


    };
}
