package chap5;

public class ReferenceObjectInstanceClass {
    public static void main(String[] args) {
        Car car = new Car();
        Car anotherCar = car;

//        anotherCar는 단순히 car의 주소를 복사한 것이다. 따라서 car와 anotherCar는 같은 객체를 참조한다.
        System.out.println(car == anotherCar);
        car.setColor("red");

        System.out.println(anotherCar.getColor());

//        자바는 항상 메모리에서 객체를 참조하는 방식으로 동작한다.

//        객체는 생성되지만 참조되지 않는다면 가비지 컬렉터에 의해 메모리에서 제거된다.
        new Car();

    }
}
