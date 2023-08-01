package chap12;

import java.util.Arrays;
import java.util.function.Consumer;

public class MiniChallenge1 {

    public static void main(String[] args) {

        Consumer<String> printTheParts = (var s) -> {
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        printTheParts.accept("this is a test");

        Consumer<String> printWordsForEach = (var s) -> {
            String[] parts = s.split(" ");
            Arrays.asList(parts).forEach(p -> System.out.println(p));
        };
        System.out.println("-----------");
        printWordsForEach.accept("this is a test");

        Consumer<String> printWordsConcise = s -> Arrays.asList(s.split(" ")).forEach(System.out::println);
        System.out.println("-----------");
        printWordsConcise.accept("this is a test");
    }
}
