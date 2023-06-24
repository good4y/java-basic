package chap6.polymorphism;

public class Car {
    String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine(){
        System.out.println("Car -> startEngine");
    }

    public void drive(){
        System.out.println("Car -> drive, type is " + getClass().getSimpleName());
        runEngine();
    }

    protected void runEngine(){
        System.out.println("Car -> runEngine");
    }
}

class GasPoweredCar extends Car{
    double avgKmPerLitre;
    int cylinders = 6;

    public GasPoweredCar(String description) {
        super(description);
    }

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("Gas -> All %d cylinders are fired up, Ready!%n", cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Gas -> Engine is running at %.2f km per litre%n", avgKmPerLitre);
    }
}

class ElectricCar extends Car{
    double avgKmPerCharge;
    int batterySize = 6;

    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        System.out.printf("BEV -> switch %d kWh battery on, Ready!\n", batterySize);
    }

    @Override
    protected void runEngine() {
        System.out.printf("BEV -> usage under the average: %.2f \n", avgKmPerCharge);
    }
}

class HybridCar extends Car{
    double avgKmPerCharge;
    int batterySize;
    private int cylinders = 6;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double avgKmPerCharge, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("Hybrid -> switch %d kWh battery on, Ready!\n", batterySize);
        System.out.printf("Hybrid -> All %d cylinders are fired up, Ready!%n", cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Hybrid -> usage under the average: %.2f \n", avgKmPerCharge);
    }
}