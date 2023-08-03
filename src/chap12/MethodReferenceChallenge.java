package chap12;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;



public class MethodReferenceChallenge {
    private record Person(String first) {

        public String last(String s){
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }
    public static void main(String[] args) {

        String[] firstNames = {"John", "Jane", "Jill", "Jack", "Jenny", "Anna", "Bob"};

        Person tim = new Person("Tim");

        // Make each name upper case
        Arrays.setAll(firstNames, i -> firstNames[i].toUpperCase());

        // add a random middle initial


        List<UnaryOperator<String>> fullNameMaker = List.of(
                String::toUpperCase,
                s -> s + " " + getRandomMiddleName(),
                s -> s + " " + new StringBuilder(s.split(" ")[0]).reverse(),
                tim::last,
                new Person("Mary")::last);

        applyChanges(firstNames, fullNameMaker);
    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions) {
        List<String> fullName = Arrays.asList(names);
        for (UnaryOperator<String> stringFunction : stringFunctions) {
            fullName.replaceAll(stringFunction);
            System.out.println(fullName);
        }

    }

    private static String getRandomMiddleName() {
        Random randomInitial = new Random();
        int a = randomInitial.nextInt('Z' - 'A') + 'A';
        return (char) a + ".";
    }
}
