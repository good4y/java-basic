package chap7;

import java.util.Arrays;
import java.util.Random;

public class UsingArrays {
    public static void main(String[] args) {

        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));

        // Arrays.sort는 배열을 오름차순으로 정렬하고 void를 반환한다.
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));

        // Arrays.fill은 배열을 특정 값으로 채우고 void를 반환한다.
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        // Arrays.copyOf는 배열을 복사하고 복사한 배열을 반환한다.
        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        // copyOf 메서드는 새로운 배열을 만들기 때문에 원본 배열을 변경해도 복사한 배열에는 영향을 주지 않는다.
        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(fourthArray));

        // 부분 복사
        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(smallerArray));

        // 전체 복사 + @
        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray));

        // Arrays.binarySearch는 배열에서 특정 값을 찾고 인덱스를 반환한다.
        // ** 이진 탐색을 사용하기 때문에 배열이 정렬되어 있어야 한다.
        String[] sArray = {"Able", "Baker", "Charlie", "Dog", "Easy"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));

        // binarySearch는 찾는 값이 없으면 음수를 반환한다.
        if(Arrays.binarySearch(sArray, "Charlie") >= 0){
            System.out.println("Charlie found : " +  Arrays.binarySearch(sArray, "Charlie"));
        }

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {1, 2, 3, 4, 5};

        // equals 메서드는 두 배열의 동등성 비교를 한다.
        if(Arrays.equals(s1, s2)){
            System.out.println("s1 and s2 are equal");
        }
    }

    private static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];

        for (int i = 0; i < len; i++) {
            newInt[i] = random.nextInt(100);
        }

        return newInt;
    }
}
