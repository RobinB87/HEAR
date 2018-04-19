package hotelAppV3.data;

import hotelAppV3.models.Drink;
import hotelAppV3.models.Dish;
import hotelAppV3.models.Ingredient;
import hotelAppV3.models.SubMenu;

import java.util.ArrayList;
import java.util.List;

public class DataList {

    //Lists
    public List<Ingredient> ingredientList = new ArrayList<>();
    public List<Drink> drinkList = new ArrayList<>();
    public List<Dish> dishList = new ArrayList<>();

    //Array
    public SubMenu[] subMenuList = new SubMenu[]{
            new SubMenu("Breakfast"),
            new SubMenu("Lunch"),
            new SubMenu("Dinner"),
            new SubMenu("Drinks")
    };

    //DinnerMenu - Starter Main Dessert?
}
