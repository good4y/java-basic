package chap7;

import java.util.Arrays;
import java.util.Scanner;

public class ElemantChallenge {

    public static void main(String[] args) {
        int[] array = readIntegers();
        System.out.println(Arrays.toString(array));
        System.out.println("Min = " + findMin(array));

        int min = findMin(array);
        System.out.println("Min = " + min);

        reverse(array);
        System.out.println("reversed: " + Arrays.toString(array));

        int[] reversedArray = reverseCopy(array);
        System.out.println("reversedCopy: " + Arrays.toString(reversedArray));
    }

    public static int[] readIntegers(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] split = input.split(",");
        int[] values = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            values[i] = Integer.parseInt(split[i].trim());
        }

        return values;
    }

    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE;

        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }

        return min;
    }

    private static void reverse(int[] array){
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }

    private static int[] reverseCopy(int[] array){

        int[] reversedArray = new int[array.length];
        int maxIndex = array.length - 1;
        for (int i : array) {
            reversedArray[maxIndex--] = i;
        }
        return reversedArray;
    }

}

