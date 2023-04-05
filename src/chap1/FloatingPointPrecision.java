package chap1;

public class FloatingPointPrecision {
    public static void main(String[] args) {
        int myIntValue = 5 / 3;
        System.out.println("myIntValue = " + myIntValue);

        float myFloatValue = 5f / 3f;
        System.out.println("myFloatValue = " + myFloatValue);

        double myDoubleValue = 5d / 3d;
        System.out.println("myDoubleValue = " + myDoubleValue);

        myDoubleValue = 5.00 / 3f;
        System.out.println("myDoubleValue = " + myDoubleValue);

//      부동소수점의 기본형은 double 이기 때문에 float형으로 형변환을 해주어야 한다.
        myFloatValue = (float) 5.00 / 3f;
        System.out.println("myFloatValue = " + myFloatValue);
         /*
         * 왜 double형이 대부분의 상황에서 유용한가?
         * 1. double형은 float형보다 더 큰 범위를 가지고 있기 때문에 더 정밀한 값을 표현할 수 있다. 따라서 대부분의 자바 라이브러리는 double형을 사용한다.
         * 2. 미세하지만 하드웨어에 따라 double형이 float형보다 더 빠르게 동작할 수 있다.
         *
         * 하지만 다음과 같은 상황에서 float이 더 유용할 수 있다.
         * 1. 메모리를 절약해야 하는 경우
         * 2. 데이터 전송 시 네트워크 대역폭을 절약해야 하는 경우
         * */

        System.out.println(convertPoundsToKilograms(200));
    }

    private static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.45359237;
    }
}
