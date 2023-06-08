package chap5.overriding_vs_overloading;

public class JavaOverloading {
    // 메서드 오버로딩
    // 메서드 오버로딩은 같은 이름의 메서드를 여러 개 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술이다.
    // 중복된 코드를 줄여 준다.

    // 메서드 오버로딩은 컴파일 시점에 정적 바인딩을 한다.
    // 정적 바인딩은 컴파일 시점에 어떤 메서드를 호출할지 결정하는 것이다.
    // 컴파일러가 메서드 이름과 매개변수를 보고 호출할 메서드를 결정한다.

    // 보통 단일 클래스에서 오버로딩을 많이 사용하지만, 상속 관계에 있는 클래스에서도 오버로딩을 사용할 수 있다.

    // 메서드 이름은 동일해야한다.
    // 매개변수의 개수 또는 타입이 달라야 한다.
    // 반환 타입이 다를 수 있다.
    // 접근 제어자가 다를 수 있다.
    // 예외처리를 다르게 할 수 있다.

    class Dog{
        public void bark(){
            System.out.println("멍멍");
        }

        private void bark(String bark){
            System.out.println(bark);
        }

        protected String bark(int bark){
            return "멍멍";
        }

        public void bark(long bark) throws Exception{
            System.out.println("멍멍");
        }
    }
}
