package chap7;

import java.util.Arrays;

public class ArrayMain {
    public static void main(String[] args) {
        int[] myIntArray = new int[10];
        myIntArray[5] = 50;

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;
        System.out.println(myDoubleArray[2]);

        // 익명 배열 생성
        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
        System.out.println(firstTen.length);
        System.out.println("last = " + firstTen[firstTen.length - 1]);

        int[] newArray;
        // 선언할 때가 아니면 익명 배열 생성을 할 수 없다. 따라서 아래와 같이 해야한다.
        newArray = new int[]{5, 4, 3, 2, 1};

        // 배열 초기화를 하지 않을 경우 기본값으로 초기화된다.
        newArray = new int[5];
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
        // 배열은 자바의 특별한 클래스이다.
        // 따라서 Object를 상속받는다.
        System.out.println(newArray.getClass().getSuperclass());

        // 배열은 객체이기 때문에 참조값을 가진다. Object 클래스의 toString()이 출력된다.
        System.out.println(newArray);

        // 아래와 같이 Arrays의 static 메서드를 사용하면 배열의 내용을 출력할 수 있다.
        System.out.println(Arrays.toString(newArray));

        Object objectVariable = newArray;
        if(objectVariable instanceof int[]){
            System.out.println("objectVariable is an int[]");
        }

        // Object 클래스로 배열을 만들면 다양한 타입의 객체를 담을 수 있다.
        Object[] objectArray = new Object[3];
        objectArray[0] = "hello";
        objectArray[1] = new StringBuilder("world");

        // 배열도 객체이기 때문에 배열의 배열을 만들 수 있다.
        objectArray[2] = newArray;

    }
}
