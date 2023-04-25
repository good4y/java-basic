package chap5;

public class StaticInstance {
//    클래스 변수: 클래스가 메모리에 로드될 때 생성되는 변수
//    클래스 변수는 모든 객체가 공유하는 변수이다.
//    클래스 변수는 갯수를 세거나, 특별한 id값을 부여하거나 PI와 같은 상수를 저장할 때 사용한다.
//    인스턴스 변수: 객체가 생성될 때 생성되는 변수

//    클래스 메서드
//    클래스 메서드는 인스턴스 메서드와 변수에 접근할 수 없다.
//    this 키워드를 사용할 수 없다. this 키워드는 현재 클래스의 인스턴스를 가리키는 참조 변수이기 때문이다.
//    클래스 메서드는 Class.method() 형태로 호출하거나 같은 클래스 내에서 method() 형태로 호출할 수 있다.
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        car1.setNumberOfCars(1);
        car2.setNumberOfCars(2);
        System.out.println(car1.getNumberOfCars());

    }
}
