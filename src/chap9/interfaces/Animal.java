package chap9.interfaces;

import java.util.Date;

enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if(this != GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] stages = values();

        // outofbound exception을 방지하기 위해 % 연산자를 사용한다.
        return stages[(ordinal() + 1) % stages.length];
    }
}

record DragonFly(String name, String type) implements FlightEnabled {
    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satellite implements OrbitEarth{

    FlightStages stage = FlightStages.GROUNDED;

    public void achieveOrbit() {
        transition("Achieving Orbit");
    }

    @Override
    public void takeOff() {
        transition("Taking Off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    public void transition(String description){
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}

interface OrbitEarth extends FlightEnabled {
    void achieveOrbit();

    // static 메서드는 자바8 이후 추가되었고 암시적으로 public이다.
    // Comparator.naturalOrder() 등 많은 유용한 메서드가 추가되었다.
    private static void log(String description){
        Date today = new Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description){
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stages) {
        FlightStages nextStage = FlightEnabled.super.transition(stages);
        logStage(stages, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}

// 인터페이스는 암시적으로 abstract이다.
interface FlightEnabled {

    // 인터페이스의 모든 빈 메서드는 암시적으로 public abstract이다.
    // 인터페이스의 모든 변수는 암시적으로 public static final이다.
    public static final double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    public abstract void takeOff();

    abstract void land();

    void fly();

    // 새로운 메서드를 추가하면 모든 구현체에서 해당 메서드를 구현해야 한다. -> 확장성이 떨어진다.
//    FlightStages transition(FlightStages stages);

    // default 메서드를 사용하면 기본 구현을 제공할 수 있다.
    default FlightStages transition(FlightStages stages){
//        System.out.println("Transition not implemented on " + getClass().getName());
//        return null;

        FlightStages nextStage = stages.getNextStage();
        System.out.println("Transitioning form " + stages + " to " + nextStage);
        return nextStage;
    }
}


interface Trackable {
    void track();
}

public abstract class Animal {
    public abstract void move();
}
