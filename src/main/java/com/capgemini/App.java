package com.capgemini;

import com.capgemini.lists.DataLists;
import com.capgemini.models.Food;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DataLists dataList = new DataLists();
        boolean quit = false;

        while (!quit) {
            System.out.println("Add a dish or a drink? \nType: dish or drink to choose \ntype quit to exit the loop.");
            String menuItemType = sc.nextLine();

            if (menuItemType.equals("dish")) {
                System.out.println("What is the name of the dish?");
                String dishName = sc.nextLine();
                System.out.println("What is the price of the dish?");
                double dishPrice = sc.nextDouble();
                dataList.foodList.add(new Food(dishName, dishPrice));
            } else if (menuItemType.equals("drink")) {

            } else if (menuItemType.equals("quit")) {
                quit = true;
                System.out.println("Exiting loop");
            } else {
                System.out.println("Error");
            }
        }

        System.out.flush();

        for (Food food : dataList.foodList) {

            System.out.println(food.getName() + " - " + food.getPrice());
        }


    }
}
