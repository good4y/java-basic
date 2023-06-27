package chap7;

import java.util.Arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] myDoubleArray1 = new int[4][4];
        int[] myDoubleArray2[] = new int[4][4];

        for (int[] ints : myDoubleArray1) {
            System.out.println(Arrays.toString(ints));
        }

        for (int i = 0; i < myDoubleArray1.length; i++) {
            var innerArray = myDoubleArray1[i];
            for (int j = 0; j < innerArray.length; j++) {
                System.out.print(myDoubleArray1[i][j] + " ");
                myDoubleArray1[i][j] = (i * 10) + (j + 1);
            }
            System.out.println();
        }

        System.out.println("---------- ");
        for (var outer : myDoubleArray1){
            for (var element : outer){
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println(Arrays.deepToString(myDoubleArray1));

        System.out.println("multi dimensional");
        myDoubleArray1[1] = new int[]{1, 2, 3};
        System.out.println(Arrays.deepToString(myDoubleArray1));

        Object[] anyArray = new Object[3];
        System.out.println(Arrays.toString(anyArray));

        anyArray[0] = new int[][]{{1, 2, 3}, {1, 2}};
        System.out.println(Arrays.toString(anyArray));

        anyArray[1] = new String[][]{{"hello", "world"}, {"goodbye", "world"}};
        System.out.println(Arrays.deepToString(anyArray));

        anyArray[2] = new int[2][2][2];
        System.out.println(Arrays.deepToString(anyArray));

        for (Object o : anyArray) {
            System.out.println("Element type = " + o.getClass().getSimpleName());
            System.out.println("Element toString() = " + o);
            System.out.println(Arrays.deepToString((Object[]) o));
        }

        // 위와 같은 방식은 컴파일러가 타입을 체크하지 않기 때문에 런타임에 오류가 발생할 수 있다.
    }

}
