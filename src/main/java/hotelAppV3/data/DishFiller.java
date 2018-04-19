package hotelAppV3.data;

import hotelAppV3.models.Dish;
import hotelAppV3.models.Ingredient;

import java.util.List;

public class DishFiller {

    IngredientsPerDishList ingredientsPerDishList = new IngredientsPerDishList();

    public List<Ingredient> getSpaghettiBolognese() {
        ingredientsPerDishList.spaghettiBolognese.add(new Ingredient("Spaghetti", 1.23));
        ingredientsPerDishList.spaghettiBolognese.add(new Ingredient("Tomato", 0.42));
        ingredientsPerDishList.spaghettiBolognese.add(new Ingredient("Minced Meat", 2.67));

        return ingredientsPerDishList.spaghettiBolognese;
    }

    public List<Ingredient> getCarpaccio() {
        ingredientsPerDishList.carpaccio.add(new Ingredient("Tenderloin", 4.54));
        ingredientsPerDishList.carpaccio.add(new Ingredient("Pine nuts", 1.33));
        ingredientsPerDishList.carpaccio.add(new Ingredient("Rucola", 0.43));

        return ingredientsPerDishList.carpaccio;
    }

    public List<Ingredient> getEnglishBreakfast() {
        ingredientsPerDishList.englishBreakfast.add(new Ingredient("Sausage", 1.89));
        ingredientsPerDishList.englishBreakfast.add(new Ingredient("Eggs", 0.56));
        ingredientsPerDishList.englishBreakfast.add(new Ingredient("Beans", 0.11));

        return ingredientsPerDishList.englishBreakfast;
    }
}
