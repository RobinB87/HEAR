package hotelAppV3;

import hotelAppV3.data.DataList;
import hotelAppV3.data.DishFiller;
import hotelAppV3.models.Dish;
import hotelAppV3.models.Ingredient;
import hotelAppV3.models.Print;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to our restaurant!");
        System.out.println("");
        System.out.println("");

        DishFiller dishFiller = new DishFiller();
        Print print = new Print();

        DataList dataList = new DataList();
        dataList.dishList.add(new Dish("Spaghetti", 14.99, dishFiller.getSpaghettiBolognese()));
        dataList.dishList.add(new Dish("Carpaccio", 7.99, dishFiller.getCarpaccio()));
        dataList.dishList.add(new Dish("English Breakfast", 9.99, dishFiller.getEnglishBreakfast()));

        //print menu met IF / ELSE
        System.out.println("");
        System.out.println("IF/ELSE MENU");
        System.out.println("");
        for (Dish dish : dataList.dishList) {
            if (dish.getName() == "Spaghetti") {
                print.printDish(dish);
            } else if (dish.getName() == "Carpaccio") {
                print.printDish(dish);
            } else {
                print.printDish(dish);
            }
        }

        //print menu met SWITCH
        System.out.println("");
        System.out.println("SWITCH MENU");
        System.out.println("");
        for (Dish dish : dataList.dishList) {
            switch (dish.getName()) {
                case "Spaghetti":
                    print.printDish(dish);
                    break;
                case "Carpaccio":
                    print.printDish(dish);
                    break;
                default:
                    print.printDish(dish);
                    break;
            }
        }

        //Scanner (inputmethode)
        Scanner sc = new Scanner(System.in);
        boolean quit = false;

        List<Ingredient> addedIngredients = new ArrayList<>();

        while (!quit) {

            System.out.println("Add a dish or a drink? \nType: dish or drink to choose. \nType: quit to exit the input.");
            String menuItemType = sc.nextLine();

            if (menuItemType.equals("dish")) {
                System.out.println("What is the name of the dish?");
                String dishName = sc.nextLine();
                System.out.println("What is the price of the dish?");
                double dishPrice = sc.nextDouble();
                boolean quitIng = false;

                while (!quitIng) {

                    if (sc.nextLine().equals("quit")) {
                        quitIng = true;
                    } else {

                        System.out.println("What is an ingredient of the dish?");
                        String ingName = sc.nextLine();
                        System.out.println("What is the price?");
                        double ingPrice = sc.nextDouble();
                        addedIngredients.add(new Ingredient(ingName, ingPrice));
                    }
                }

            } else if (menuItemType.equals("drink")) {

            } else if (menuItemType.equals("quit")) {
                quit = true;
                System.out.println("Exiting input menu");
            } else {
                System.out.println("Error");
            }
        }
        System.out.flush();
    }
}
