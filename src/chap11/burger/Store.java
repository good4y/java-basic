package chap11.burger;

import java.util.ArrayList;
public class Store {

    public static void main(String[] args) {

        Meal regularMeal = new Meal();
        regularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar");
        System.out.println(regularMeal);

        Meal USReqularMeal = new Meal(0.68);
        System.out.println(USReqularMeal);
        ArrayList<String> toppings = new ArrayList<>();
    }
}
