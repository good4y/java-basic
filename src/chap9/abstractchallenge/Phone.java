package chap9.abstractchallenge;

public class Phone extends ProductForSale{

    public Phone(String type, String description, double price) {
        super(type, description, price);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + type + " is " + description + " and costs " + price);
        System.out.println(type + " " + description + " " + price);
    }
}
