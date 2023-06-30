package chap8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayAndArrayList {
    public static void main(String[] args) {
        String[] originalArray = new String[]{"First", "Second", "Third"};
        var originalList = Arrays.asList(originalArray);

        // originalList는 originalArray를 참조하고 있다.
        // 따라서, originalList의 값을 변경하면 originalArray의 값도 변경된다.
        originalList.set(0, "one");
        System.out.println("originalList = " + originalList);
        System.out.println("originalArray = " + Arrays.toString(originalArray));

        // Comparator.naturalOrder는 오름차순으로 정렬하고, String의 경우 알파벳 순서로 정렬한다.
        // 아스키 코드 순서로 정렬하여 대문자가 소문자보다 먼저 나온다.
        originalList.sort(Comparator.naturalOrder());
        System.out.println("originalArray = " + Arrays.toString(originalArray));

        // 실제로 Arrays.asList()는 ArrayList를 생성하는 것이 아니라 Arrays의 private static class인 ArrayList를 생성한다.
        // 따라서, originalList는 Arrays의 private static class인 ArrayList를 참조하고 있고 이는 크기가 고정되어 있다.
//        originalList.add("Fourth");

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println("newList = " + newList);

        // ArrayList.add()메서드 수행 시 이미 할당되어있는 크기를 넘어서는 경우 크기를 늘린 새로운 배열을 생성하고 기존의 배열을 복사한다.
        // 이 때, 현재 size + 1에 해당하는 값과 현재 사이즈의 >> 1 만큼의 값을 비교하여 더 큰 값을 새로운 배열의 크기로 지정한다.
        // size >> 1 수행 시 현재 사이즈의 절반에 해당하는 크기이다.
    }

}
