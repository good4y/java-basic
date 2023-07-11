package chap10.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // compareTo : 기존값과 비교하여 기존값이 비교값에 비해 작으면 음수, 같으면 0, 크면 양수를 반환한다.
    // 문자열 비교 시 ASCII 코드값을 비교하고, 길이의 차이가 있을 때는 기존값이 길면 양수, 비교값이 길면 음수를 반환한다.
    public static void main(String[] args) {

        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five, (val == 0 ? "==" : (val < 0 ? "<" : ">")), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA", "bananaa", "banan"};

        for (String s : fruit) {
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana, (val == 0 ? "==" : (val < 0 ? "<" : ">")), s, val);
        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        System.out.println("A:"+(int)'A' + " " + "a:" + (int)'a');
        System.out.println("B:"+(int)'B' + " " + "b:" + (int)'b');
        System.out.println("P:"+(int)'P' + " " + "p:" + (int)'p');

        Student kim = new Student("김");
        Student[] students = {new Student("홍"), new Student("김"), new Student("이")};

        // Student 클래스에 Comparable 인터페이스를 구현하지 않았기 때문에 오류가 발생한다.
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        System.out.println("result = " + kim.compareTo(students[1]));

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter);
        System.out.println(Arrays.toString(students));
    }
}
