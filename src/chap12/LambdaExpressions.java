package chap12;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

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

        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659});

        // Consumer 활용
        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lng:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("-----------");
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        coords.forEach(s -> processPoint(s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

        // Predicate 활용
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(System.out::println);

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        System.out.println("-----------");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        // Function의 활용
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("-----------");
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, i -> (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, i -> (i + 1) + ". " +
                switch(i) {
                    case 0 -> "one";
                    case 1 -> "two";
                    case 2 -> "three";
                    default -> "";
                });
        System.out.println(Arrays.toString(emptyStrings));

        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names, () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));
    }

    /*
    Consumer: 매개변수를 받지만 반환값이 없음 -> 소비
    Function: 매개변수도 받고, 반환값도 있음 -> 일반적 함수의 역할
    Predicate: 매개변수를 받아 boolean을 반환함 -> 조건식
    Supplier: 매개변수를 받지 않고, 반환값만 있음 -> 공급
     */
    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer){
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s){
        String[] selectedValues = new String[count];

        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}
