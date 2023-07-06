package chap9.abstractchallenge;

public class Computer extends ProductForSale{
    public Computer(String type, String description, double price) {
        super(type, description, price);
    }

    @Override
    public void showDetails() {
        System.out.println(type + " " + description + " " + price);
    }
}
