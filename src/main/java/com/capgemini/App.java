package com.capgemini;

import com.capgemini.models.Ingredient;
import com.capgemini.models.MenuItem;
import com.capgemini.models.SubMenu;
import com.capgemini.services.MenuService;

public class App {

    public static void main(String[] args) {

        MenuService menuService = new MenuService();

        for (SubMenu subMenu : menuService.getSubMenus()) {
            System.out.println(subMenu.getName());
            System.out.println("-------");

            for (MenuItem menuItem : menuService.getMenuItemBySubMenu(subMenu)) {
                System.out.println(menuItem.getName());

                for (Ingredient ingredient : menuService.getIngredientsByMenuItem(menuItem)) {
                    System.out.println("-" + ingredient.getName());
                }
                System.out.println("");
            }
            System.out.println("");
        }

    }
}
