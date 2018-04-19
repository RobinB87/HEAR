package hotelAppV3.data;

import hotelAppV3.models.Dish;
import hotelAppV3.models.Drink;
import hotelAppV3.models.Ingredient;

public class DataFiller {

    DataList dataList = new DataList();
    IngredientsPerDishList ingredientsPerDishList = new IngredientsPerDishList();

    public void fillIngredient(Ingredient igr) {
        dataList.ingredientList.add(new Ingredient("Carrot", 0.23));
        dataList.ingredientList.add(new Ingredient("Onion", 0.11));
        dataList.ingredientList.add(new Ingredient("Pasta", 0.45));
    }

    public void fillDrink(Drink drink) {
        dataList.drinkList.add(new Drink("Peroni", 4.99));
        dataList.drinkList.add(new Drink("Merlot", 3.99));
        dataList.drinkList.add(new Drink("Sauvignon Blanc", 3.99));
    }

    public void fillDish(Dish dish) {
        dataList.dishList.add(new Dish("Spaghetti", 14.99, ingredientsPerDishList.spaghettiBolognese));
        dataList.dishList.add(new Dish("Carpaccio", 7.99, ingredientsPerDishList.carpaccio));
        dataList.dishList.add(new Dish("English Breakfast", 9.99, ingredientsPerDishList.englishBreakfast));
    }

}
