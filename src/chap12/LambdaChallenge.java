package chap12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaChallenge {

    public static void main(String[] args) {

        String[] firstNames = {"John", "Jane", "Jill", "Jack", "Jenny", "Anna", "Bob"};

        Arrays.setAll(firstNames, i -> firstNames[i].toUpperCase());
        System.out.println(Arrays.toString(firstNames));

        List<String> backByArray = new ArrayList<>(Arrays.asList(firstNames));
        backByArray.replaceAll(s -> s + " " + getRandomChar('A', 'Z') + ". " + getReversedName(s));

        System.out.println(backByArray);

        backByArray.removeIf(s -> {
            String[] split = s.split(" ");
            return split[0].equals(split[2]);
        });

        backByArray.forEach(System.out::println);
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) (Math.random() * (endChar - startChar + 1) + startChar);
    }

    private static String getReversedName(String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
