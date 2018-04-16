package com.capgemini;

import com.capgemini.data.MenuItemList;
import com.capgemini.models.Ingredient;
import com.capgemini.models.MenuItem;
import com.capgemini.models.SubMenu;
import com.capgemini.services.MenuService;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmileTest {

    private static MenuService _menuService;
    private static MenuItemList menuItemList;

    public EmileTest() {
        _menuService = new MenuService();
        menuItemList = new MenuItemList();
    }

    @Test
    public void getSubMenusTest() {
        // Check if the array has 1 or more items
        assertTrue(_menuService.getSubMenus().length > 0);

        // Check if the array is of object type: SubMenu[] (array Submenu)
        assertTrue(_menuService.getSubMenus() instanceof SubMenu[]);
    }

    @Test
    public void getIngredientsByMenuItemTest() {

        // Loop through the menuItemList
        for (MenuItem menuItem : menuItemList.items) {

            // Check if the ingredients of a menuItem are of object type: Ingredient[] (array Ingredient)
            assertTrue(_menuService.getIngredientsByMenuItem(menuItem) instanceof Ingredient[]);
        }
    }
}
