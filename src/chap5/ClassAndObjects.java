package chap5;

public class ClassAndObjects {
    /*
    * OOP란?
    * 데이터와 코드를 포함하는 소프트웨어 객체를 이용하여 실제 세계를 모델링하는 프로그래밍 패러다임
    * 클래스는 객체를 만들기 위한 설계도이다.
    * 클래스는 상태(state) 와 행위(behavior)를 가진다.
    * 상태는 User라는 테이블이 있다고 가정할 때, 이름, 성별, 나이 등의 속성을 말한다.
    * 행위는 User라는 테이블이 있다고 가정할 때, 먹는 행위를 하거나, 걷는 등 실제로 할 수 있는 행위를 말한다.
    * */
    public static void main(String[] args) {
        Car car = new Car();
        car.describeCar();
        // 클래스의 필드는 명시적으로 초기화하지 않으면 기본값으로 초기화된다.
        // 기본값은 다음과 같다.
        // boolean: false
        // byte, short, int, long: 0
        // float, double: 0.0
        // char: '\u0000'
        // 참조 타입: null

        // 각 필드는 Private으로 선언되어 있으므로, 외부에서 접근할 수 없다.
        // car.make = "Ford";  -- error
        // 따라서 클래스의 필드에 접근하기 위해서는 getter와 setter를 사용해야 한다.
        // Getter와 Setter메서드는 각각 private 필드의 값을 제어하고 접근하고 보호하기 위한 메서드이다.
        // 프로퍼티 접근 방식의 또다른 장점은 메서드 하나로 여러 동작을 할 수 있게 한다는 것이다.



        car.setMake("Porsche");
        car.setModel("911");
        car.setColor("Red");
        car.setDoors(2);
        car.setConvertible(true);
        car.describeCar();
    }

}
