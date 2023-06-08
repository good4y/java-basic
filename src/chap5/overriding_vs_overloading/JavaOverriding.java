package chap5.overriding_vs_overloading;

public class JavaOverriding {
    // 메서드 오버라이딩
    // 메서드 오버라이딩은 상위 클래스가 가지고 있는 메서드를 하위 클래스가 같은 시그니처로 재정의해서 사용하는 기술이다.
    // 런타임 시점에 JVM에 의해 동적 바인딩을 한다.
    // @Override는 생략해도 된다. 하지만 @Override를 사용하여 오버라이딩을 한다는 것을 명시적으로 표현하는 것이 좋다.
    // static 메서드는 오버라이딩할 수 없다.

    // 같은 이름과 같은 매개변수를 가져야 한다.
    // 리턴 타입은 같거나 하위 타입이어야 한다.
    // 접근 제어자는 상위 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
    // 오직 자식 클래스에서만 오버라이딩할 수 있다.
    // 생성자와 private 메서드는 오버라이딩할 수 없다.
    // final 메서드는 오버라이딩할 수 없다.
    // super 키워드를 사용하여 상위 클래스의 메서드를 호출할 수 있다.
    // 예외는 상위 클래스의 메서드보다 넓은 범위로 변경할 수 없다.

    class Dog{
        public void bark(){
            System.out.println("멍멍");
        }

        public void move(){
            System.out.println("이동합니다.");


        }

        @Override
        public Dog clone() throws CloneNotSupportedException {
            Dog clone = (Dog) super.clone();
            return new Dog();
        }
    }

    class GermanShepherd extends Dog{
        @Override
        public void bark() {
            System.out.println("컹컹컹");
        }

        public void move(){
            super.move();
            System.out.println("빠르게 이동합니다.");
        }
    }
}
