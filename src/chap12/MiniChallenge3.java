package chap12;

import java.util.function.Supplier;

public class MiniChallenge3 {

    public static void main(String[] args) {

        // 람다식은 함수의 지연된 실행을 표현할 수 있다.
        Supplier<String> iLoveJava = () -> "I love Java!";

        // Supplier는 get() 메서드를 갖고 있어, 람다식을 실행할 수 있다.
        String supplierResult = iLoveJava.get();

        System.out.println(supplierResult);
    }
}
