package chap7;

import java.util.Arrays;

public class ArrayReference {
    public static void main(String[] args) {

        // 참조 유형
        int[] myIntArray = new int[5];
        // myIntArray는 배열을 참조하는 참조 변수. 따라서, 같은 주소를 참조하고 있다.
        int[] anotherArray = myIntArray;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        anotherArray[0] = 1;

        // myIntArray와 anotherArray는 같은 배열을 참조하고 있기 때문에 같은 값을 가진다.
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        // 파라메터로 배열을 넘기면 참조를 넘기는 것이다.
        // 따라서, 배열의 값이 변경되면 원래 배열의 값도 변경된다.
        modifyArray(myIntArray);
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));
    }

    private static void modifyArray(int[] array){
        array[1] = 2;
    }
}
