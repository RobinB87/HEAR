package hotelAppV3.data;

import hotelAppV3.models.Dish;
import hotelAppV3.models.Drink;
import hotelAppV3.models.Ingredient;
import hotelAppV3.models.SubMenu;

import java.util.ArrayList;
import java.util.List;

public class DataList {

    //Main lists
    private List<Dish> dishList = new ArrayList<>();
    private List<Drink> drinkList = new ArrayList<>();

    public SubMenu[] subMenuList = new SubMenu[]{
            new SubMenu("Breakfast"),
            new SubMenu("Lunch"),
            new SubMenu("Dinner"),
            new SubMenu("Drinks")
    };

    //Add drinks to the dishList
    public void finalDishList() {
        this.spaghettiBologneseIngredients();
        this.carpaccioIngredients();
        this.englishBreakfastIngredients();
        this.dishList.add(new Dish("Spaghetti", 14.99, spaghettiBologneseIngredients));
        this.dishList.add(new Dish("Carpaccio", 7.99, carpaccioIngredients));
        this.dishList.add(new Dish("English Breakfast", 9.99, englishBreakfastIngredients));
    }

    public List<Dish> getDishList() {
        this.finalDishList();
        return this.dishList;
    }

    //Lists per dish with ingredients
    private List<Ingredient> spaghettiBologneseIngredients = new ArrayList<>();
    private List<Ingredient> carpaccioIngredients = new ArrayList<>();
    private List<Ingredient> englishBreakfastIngredients = new ArrayList<>();

    //Add drinks to the drinklist
    public void finalDrinkList() {
        this.drinkList.add(new Drink("Peroni", 4.99));
        this.drinkList.add(new Drink("Merlot", 3.99));
        this.drinkList.add(new Drink("Sauvignon Blanc", 3.99));
    }

    public List<Drink> getDrinkList(){
        this.finalDrinkList();
        return this.drinkList;
    }

    //Ingredients per dish
    public void spaghettiBologneseIngredients() {
        spaghettiBologneseIngredients.add(new Ingredient("Carrot", 0.23));
        spaghettiBologneseIngredients.add(new Ingredient("Onion", 0.11));
        spaghettiBologneseIngredients.add(new Ingredient("Pasta", 0.45));
    }

    public void carpaccioIngredients() {
        carpaccioIngredients.add(new Ingredient("Tenderloin", 4.54));
        carpaccioIngredients.add(new Ingredient("Pine nuts", 1.33));
        carpaccioIngredients.add(new Ingredient("Rucola", 0.43));
    }

    public void englishBreakfastIngredients() {
        englishBreakfastIngredients.add(new Ingredient("Sausage", 1.89));
        englishBreakfastIngredients.add(new Ingredient("Eggs", 0.56));
        englishBreakfastIngredients.add(new Ingredient("Beans", 0.11));
    }
}
