package chap1;

public class PrimitiveTypes {
    /*
     * class : 객체를 구성하는 설계도
     * Wrapper Class : 기본 자료형을 객체로 사용하기 위한 클래스
     * OverFlow : 자료형의 최대값을 넘어서는 경우
     * UnderFlow : 자료형의 최소값을 넘어서는 경우
     * */

    public static void main(String[] args) {
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer Minimum Value = " + myMinIntValue);
        System.out.println("Integer Maximum Value = " + myMaxIntValue);

        System.out.println("Busted MAX value = " + (myMaxIntValue + 1));
        System.out.println("Busted MIN value = " + (myMinIntValue - 1));

//        int myMaxIntTest = 2_147_483_648; integer number too large
    }
}
