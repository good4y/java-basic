package chap9.interfaces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
//        flier.move();
//        tracked.move();

//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.land();

        inFlight(flier);
        inFlight(new Jet());
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;

        System.out.printf("Miles traveled: %.2f km or %.2f miles\n", kmsTraveled, milesTraveled);

        ArrayList<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(bird);

        List<FlightEnabled> betterFliers = new LinkedList<>();
        betterFliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        triggerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable trackable) {
            trackable.track();
        }
        flier.land();
    }

    private static void triggerFliers(List<FlightEnabled> flightEnableds){
        for (FlightEnabled flightEnabled : flightEnableds) {
            flightEnabled.takeOff();
        }
    }

    private static void landFliers(List<FlightEnabled> flightEnableds){
        for (FlightEnabled flightEnabled : flightEnableds) {
            flightEnabled.land();
        }
    }

    private static void flyFliers(List<FlightEnabled> flightEnableds){
        for (FlightEnabled flightEnabled : flightEnableds) {
            flightEnabled.fly();
        }
    }
}
