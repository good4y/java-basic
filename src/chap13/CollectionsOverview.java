package chap13;

import java.util.*;

public class CollectionsOverview {

    public static void main(String[] args) {

        Collection<String> list = new HashSet<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(List.of(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        list.removeIf(s -> s.startsWith("G"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));
    }
}
