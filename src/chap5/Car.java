package chap5;

public class Car {
//    클래스는 패키지로 구분되어 있다.
//    Top-level 클래스는 public 또는 default로 선언되어야 한다.
//    public: 다른 패키지에서도 접근 가능
//    default: 같은 패키지에서만 접근 가능

//    클래스 멤버의 접근 제어자
//    public, protected, default, private가 있다.
//    protected: 같은 패키지에서 접근 가능하며, 다른 패키지에서는 상속 관계일 때만 접근 가능
//    private: 같은 클래스에서만 접근 가능

//    캡슐화
//    일반적으로 두 가지 의미로 사용된다.
//    1. 객체의 상태와 몇몇의 메서드를 감추고 외부에서는 객체의 상태를 변경할 수 없도록 하는 것
//    2. 객체의 상태와 행위를 하나로 묶고, 그 묶음을 관리하기 위한 기능을 제공하는 것

//    this
//    클래스의 필드와 매개변수를 구분하기 위해 사용한다.

    private String make;
    private String model;
    private String color;
    private int doors;
    private boolean convertible;

    private static int numberOfCars;

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    public static void setNumberOfCars(int numberOfCars) {
        Car.numberOfCars = numberOfCars;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        if(make == null)
            make = "Unknown";
        String lowerCaseMake = make.toLowerCase();
        switch (lowerCaseMake) {
            case "porsche", "ford", "honda" -> this.make = make;
            default -> this.make = "Unsupported";
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public void describeCar(){
        System.out.println(doors + "-Door " + color + " " + make + " " + model + " " + (convertible ? "Convertible" : ""));

    }
}
