package com.capgemini.services;

import com.capgemini.data.IngredientLijst;
import com.capgemini.data.MenuItemList;
import com.capgemini.data.SubMenuLijst;
import com.capgemini.models.Ingredient;
import com.capgemini.models.MenuItem;
import com.capgemini.models.SubMenu;

public class MenuService {

    private Ingredient[] ingredientList = new IngredientLijst().supply;
    private SubMenu[] subMenus = new SubMenuLijst().subMenuList;
    private MenuItem[] menuItems = new MenuItemList().items;

    public MenuItem[] getMenuItemBySubMenu(SubMenu subMenu) {

        switch (subMenu.getName()) {
            case "Voorgerechten":
                return new MenuItem[]
                        {
                                menuItems[3],
                        };

            case "Hoofdgerechten":
                return new MenuItem[]
                        {
                                menuItems[0],
                                menuItems[1],
                                menuItems[2]
                        };

            case "Nagerechten":
                return new MenuItem[]
                        {
                                menuItems[4],
                                menuItems[5]
                        };
            case "Drankkaart":
                return new MenuItem[]
                        {
                                menuItems[6],
                                menuItems[7],
                                menuItems[8],
                                menuItems[9]
                        };

            default:
                return new MenuItem[] {};
        }
    }

    public Ingredient[] getIngredientsByMenuItem(MenuItem menuItem) {
        switch (menuItem.getName()) {
            case "Steak":
                return new Ingredient[] {
                        ingredientList[1],
                        ingredientList[4]
                };
            case "Pasta":
                return new Ingredient[] {
                        ingredientList[0],
                        ingredientList[4],
                        ingredientList[6]
                };
            case "Carpaccio":
                return new Ingredient[] {
                        ingredientList[5],
                        ingredientList[3]
                };
            default:
                return new Ingredient[] {};
        }
    }

    public SubMenu[] getSubMenus() {
        return subMenus;
    }
}
