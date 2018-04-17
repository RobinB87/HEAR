package com.capgemini;

import com.capgemini.data.DataList;
import com.capgemini.models.Ingredient;
import com.capgemini.models.MenuItem;
import com.capgemini.models.SubMenu;
import com.capgemini.services.MenuService;

public class App {

    public static void main(String[] args) {

        MenuService menuService = new MenuService();
        DataList dataList = new DataList();

        for (int i = 0; i < 5; i++) {
            Ingredient newIng = new Ingredient("Ingredient" + i , i);
            dataList.ingredienten.add(newIng);
        }

        for (Ingredient ingr : dataList.ingredienten) {
            System.out.println(ingr.getName());
        }


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
