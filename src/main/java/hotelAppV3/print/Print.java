package hotelAppV3.print;

import hotelAppV3.models.Dish;
import hotelAppV3.models.Drink;
import hotelAppV3.models.Ingredient;

import java.util.List;

public class Print {

    public void printDish(Dish dish) {

        System.out.println("");
        System.out.println(dish.getName() + " - " + dish.getPrice());
        System.out.println("-------------------------");
        for (Ingredient ingr : dish.getIngredients()) {
            System.out.println(ingr.getName() + " - " + ingr.getPrice());
        }
    }

    public void printDishes(List<Dish> dishList) {
        System.out.println("");
        for (Dish dish : dishList) {
            if (dish.getName() == "Spaghetti") {
                this.printDish(dish);
            } else if (dish.getName() == "Carpaccio") {
                this.printDish(dish);
            } else {
                this.printDish(dish);
            }
        }
    }

    public void printDrink(Drink drink) {
        System.out.println(drink.getName() + " - " + drink.getPrice());
    }

    public void printDrinks(List<Drink> drinkList) {
        System.out.println("");
        for (Drink drink : drinkList) {
            this.printDrink(drink);
        }
        System.out.println("");
    }
}
