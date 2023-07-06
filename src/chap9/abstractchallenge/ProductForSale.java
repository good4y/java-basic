package chap9.abstractchallenge;

public abstract class ProductForSale {
    protected String type;
    protected String description;
    protected double price;

    public ProductForSale(String type, String description, double price){
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public void printPricedItem(int quantity){
        System.out.println(quantity + " qty at " + price + " each " + type + " " + description);
    }

    public double getSalesPrice(int quantity){
        return quantity * price;
    }

    public abstract void showDetails();
}
