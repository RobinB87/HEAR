package hotelAppV3.models;

public class Print {

    public void printDish(Dish dish) {

        System.out.println("");
        System.out.println(dish.getName() + " - " + dish.getPrice());
        System.out.println("-------------------------");
        for (Ingredient ingr : dish.getIngredients()) {
            System.out.println(ingr.getName() + " - " + ingr.getPrice());
        }
    }
}
