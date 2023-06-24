package chap6.polymorphism;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("red");
        runRace(car);

        Car ferrari = new GasPoweredCar("red", 15.4, 6);
        runRace(ferrari);

        Car tesla = new ElectricCar("red", 568, 75);
        runRace(tesla);

        Car ferrariHybrid = new HybridCar("red", 16, 8, 8);
        runRace(ferrariHybrid);
    }

    private static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
