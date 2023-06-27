package chap7;

import java.util.Arrays;
import java.util.Random;

public class ArraysChallenge {
    public static void main(String[] args) {
        Random random = new Random();
        int[] newArray = new int[5];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = random.nextInt(100);
        }

        Arrays.sort(newArray);

        System.out.println(Arrays.toString(newArray));

        System.out.println(Arrays.toString(sortDescending(newArray)));
    }

    public static int[] sortDescending(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;

                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}