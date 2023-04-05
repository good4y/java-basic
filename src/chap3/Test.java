package chap3;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int a = 1; // primitive type
        Integer b = 1; // wrapper class
        List<Integer> list = List.of(1, 2, 3);

        // constant pool
        Integer c = 1;  //힙메모리 -> integer cache

        Integer d = 200;
        Integer e = 200; // 힙메모리

        System.out.println(b == c);
        System.out.println(d == e); // 목요일 8 시
    }
}