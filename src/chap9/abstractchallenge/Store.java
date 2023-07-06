package chap9.abstractchallenge;

import java.util.ArrayList;

public class Store {
    private static ArrayList<ProductForSale> products = new ArrayList<>();

    public void printOrder(){
        for (ProductForSale product : products) {
            System.out.print(product + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        products.add(new Computer("MacBook Pro", "14 inch, silver", 2000));
        products.add(new Computer("MacBook Air", "13 inch, space gray", 1500));

        products.add(new Phone("iPhone 12", "6.1 inch, blue", 1000));
        products.add(new Phone("iPhone 12 Pro", "6.1 inch, gold", 1200));
        listProducts();

        System.out.println("Order 1:");
        ArrayList<OrderItem> order1 = new ArrayList<>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        addItemToOrder(order1, 3, 1);
        printOrder(order1);
    }

    public static void listProducts(){
        for (ProductForSale product : products) {
            System.out.println("-".repeat(30));
            product.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> orderItems, int orderIndex, int quantity){
        orderItems.add(new OrderItem(quantity, products.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){
        double salesTotal = 0;
        for (OrderItem orderItem : order) {
            orderItem.product().printPricedItem(orderItem.quantity());
            salesTotal += orderItem.product().getSalesPrice(orderItem.quantity());
        }

        System.out.println("Sales total: " + salesTotal);
    }
}
