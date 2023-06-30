package chap8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boxing {
    public static void main(String[] args) {
        Integer boxedInt = Integer.valueOf(15); // 불필요한 박싱
        Integer deprecatedBoxing = new Integer(15); // sdk 9부터 deprecated
        int unboxedInt = boxedInt.intValue(); // 불필요한 언박싱

        // auto boxing
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;

        System.out.println(autoBoxed.getClass().getName());

        // 각 메서드는 다른 형태의 double을 반환하지만 JVM에서 자동으로 박싱, 언박싱을 수행한다.
        Double resultBoxed = getLiteralDoublePrimitive();
        double resultUnboxed = getDoubleObject();

        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));

        System.out.println(wrapperArray[0].getClass().getName());

        Character[] charArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(charArray));

        var lists = getList(1, 2, 3, 4, 5);
        var ourList = List.of(1, 2, 3, 4, 5);
        System.out.println(ourList);
    }

    private static ArrayList<Integer> getList(int... varargs){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : varargs) {
            list.add(i);
        }
        return list;
    }

    private static int returnAnInt(Integer i) {
        return i;
    }

    private static Integer returnAnInteger(int i) {
        return i;
    }

    private static Double getDoubleObject() {
        return Double.valueOf(100.00);
    }

    private static double getLiteralDoublePrimitive() {
        return 100.00;
    }
}
