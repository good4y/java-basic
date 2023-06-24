package chap6.oopmaster;

public class Main {
    public static void main(String[] args) {
        Item coke = new Item("drink", "coke", 1000);
        coke.setSize("L");
        coke.printItem();

        Side cheeseStick = new Side("side", "cheese stick", 1500);
    }
}
