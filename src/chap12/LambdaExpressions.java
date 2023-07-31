package chap12;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressions {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("-----------");
        list.forEach((var myString) -> System.out.println(myString));

        System.out.println("-----------");
        // 람다식에서 참조유형이 지정된 매개변수를 사용할 때는 괄호를 사용해야 한다.
        list.forEach((var myString) -> {
            // 람다식에서 지역변수를 사용할 때는 final이거나 final처럼 사용되어야 한다.
            String prefix = "nato ";
            char first = myString.charAt(0);
            System.out.println(prefix + myString + " means " + first);
        });
        // prefix = "NATO "; // 컴파일 에러

        // 매개변수로 5, 2의 int 값을 받지만, 제너릭 타입에서는 wrapper class인 Integer를 사용하여 auto boxing이 일어난다.
        // 중괄호를 이용하여 return 문이 있는 람다식을 사용할 수 있다.
        int result = calculator((var a, var b) -> {return a + b;}, 5, 2);
        var result2 = calculator((var a, var b) -> a / b, 10.0, 2.5);
        var result3 = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "kramden");

    }

    public static <T> T calculator(Operation<T> function, T value1, T value2){

        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}
