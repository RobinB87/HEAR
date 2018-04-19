package hotelAppV3.models;

import java.util.List;

public class Dish extends MenuItem{

    private List<Ingredient> ingredients;

    public Dish(String name, double price, List<Ingredient> ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }


}
