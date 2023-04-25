import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        // Adding a String to the list of integers, which should not be allowed
        List rawList = integers;
        rawList.add("Not an integer");

        // Iterating over the list and performing an operation on the integers
        for (Integer i : integers) {
            // This will throw a ClassCastException at runtime when encountering the String
            System.out.println(i + 1);
        }
    }
}