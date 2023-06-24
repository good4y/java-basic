package chap6.oopmaster;

public class Meal {
    private Burger burger;
    private Drink drink;
    private Side side;

    public Meal() {
        this(new Burger("Burger", "beef", 10000), new Drink(), new Side());
    }

    public Meal(Burger burger, Drink drink, Side side) {
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }



    public void totalPrice() {
        System.out.println(burger.getPrice() + drink.getPrice() + side.getPrice());
    }

    @Override
    public String toString() {
        return "Meal{" +
                "burgerPrice=" + burger.getPrice() +
                ", drinkPrice=" + drink.getPrice() +
                ", sidePrice=" + side.getPrice() +
                '}';
    }
}

class Item {
    private String type;
    private String name;
    private double price;
    private String size;

    public Item(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return switch (size.toUpperCase()) {
            case "S" -> price * 0.8;
            case "L" -> price * 1.2;
            default -> getPrice();
        };
    }

    public String getName() {
        return name;
    }

    public static void printItem(String name, double price){
        System.out.printf("%20s : %6.2f원\n", name, price);
    }

    public void printItem(){
        printItem(getName(), getTotalPrice());
    }

    public void setSize(String size) {
        this.size = size;
    }
}

class Burger extends Item {
    protected Topping[] toppings;

    public Burger(String type, String name, int price) {
        super(type, name, price);
        toppings = new Topping[3];
    }

    public void addTopping(Topping topping) {
        if (toppings[2] != null) {
            System.out.println("더 이상 토핑을 추가할 수 없습니다.");
            return;
        }

        for (int i = 0; i < toppings.length; i++) {
            if (toppings[i] == null) {
                toppings[i] = topping;
                break;
            }
        }
    }
}

class DeluxBurger extends Burger {
    public DeluxBurger(String type, String name, int price) {
        super(type, name, price);
        toppings = new Topping[5];
    }
}

class Topping extends Item {
    public Topping(String type, String name, int price) {
        super(type, name, price);
    }
}

class Drink extends Item {

    public Drink() {
        super("drink", "coke", 1000);
    }

}

class Side extends Item {

    public Side(){
        super("side", "fries", 1500);
    }
    public Side(String type, String name, double price) {
        super(type, name, price);
    }
}
