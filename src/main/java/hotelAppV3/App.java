package hotelAppV3;

import hotelAppV3.data.DataList;
import hotelAppV3.models.Ingredient;
import hotelAppV3.print.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to our restaurant!");
        System.out.println("");
        System.out.println("");

        Print print = new Print();
        DataList dataList = new DataList();

        //print
        print.printDishes(dataList.getDishList());
        print.printDrinks(dataList.getDrinkList());

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
