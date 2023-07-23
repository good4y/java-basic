package chap11.nestedclasses.burger;


import java.util.ArrayList;
import java.util.List;

// nested class는 outer class의 인스턴스에 종속되어 있다.
// 따라서 항상 outer class와 암시적으로 연결되어 있다.
// 이런 특징 때문에 외부 참조로 인한 메모리 누수가 발생할 수 있다.
// 이를 방지하기 위해 nested class를 static으로 선언하면 outer class의 인스턴스에 종속되지 않는다.
public class Meal {

    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;

    public Meal(){
        this(1);
    }
    private double conversionRate;

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Burger("regular");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }

    public double getTotal(){

        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total Due: ", getTotal());
    }

    public void addToppings(String... selectedToppings){
        burger.addToppings(selectedToppings);
    }

    private class Item{

        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {

            return "%10s%15s $%.2f".formatted(name, type, getPrice(price, conversionRate));
        }

        // 자바 16버전 이전에는 내부 클래스에서 static 선언을 할 수 없었다.
        // 만약, 내부 클레스에 정적 필드가 선언되어 있다면, 다음과 같은 역설적 상황이 발생한다.
        // 1. 단일 외부 클래스의 인스턴스에 종속되는 내부 클래스의 static 필드여야 하는지?
        // 2. 모든 외부 클래스의 인스턴스에서 공유되는 static 필드여야 하는지?
        private static double getPrice(double price, double rate){
            return price * rate;
        }
    }
    private class Burger extends Item{

        private enum Extra{
            AVOCADO, BACON, CHEESE, KETCHUP, MAYO, MUSTARD, PICKLES;

            private double getPrice(){
                return switch (this){
                    case AVOCADO -> 1.0;
                    case BACON, CHEESE -> 1.5;
                    default -> 0;
                };
            }
        }
        private List<Item> toppings = new ArrayList<>();

        public Burger(String name) {
            super(name, "burger", 5.0);
        }

        public double getPrice(){

            double total = super.price;
            for (Item topping : toppings) {
                total += topping.price;
            }
            return total;
        }

        private void addToppings(String... selectedToppings){

            for (String selectedTopping : selectedToppings) {
                try {
                    Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
                    toppings.add(new Item("topping", topping.name().toLowerCase(), topping.getPrice()));
                }catch (IllegalArgumentException e){
                    System.out.println("No topping found for " + selectedTopping);
                }
            }
        }

        @Override
        public String toString(){

            StringBuilder itemized = new StringBuilder(super.toString());
            for (Item topping : toppings) {
                itemized.append("\n").append(topping);
            }

            return itemized.toString();
        }
    }
}
