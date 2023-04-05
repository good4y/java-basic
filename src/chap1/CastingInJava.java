package chap1;

public class CastingInJava {

    public static void main(String[] args) {
        // 자바 컴파일러는 변수가 계산에 사용될 때 값을 평가하려고 시도하지 않기 때문에 값이 적절한 자료형인지 알지 못하며 오류가 발생한다.
        // int 보다 작은 자료형에서 산술 연산 시 int로 변환되어 수행된다. -> 정수 승격
        // 정수 승격은 byte, short, int, long, char인 정수 유형에만 적용된다.

        byte myMinByteValue = Byte.MIN_VALUE;

        /*
         * byte myNewByteValue =(myMinByteValue / 2);
         * myMinByteValue는 byte이고 2는 int이기 때문에 오류가 발생한다.
         * 자바에서는 myMinByteValue라는 변수값을 런타임 전까지 알 수 없기 때문에 명시적 형변환을 하지 않는다면 오류가 발생한다.
         * */

        byte myNewByteValue = (byte) (myMinByteValue / 2);

        // 아래 코드의 결과값은 -64 이지만, literal value로만 연산을 할 때 컴파일러는 결과를 바로 계산하여 결과값이 byte와 맞는지 비교할 수 있다.
        myNewByteValue = (-128 / 2);
        System.out.println(myNewByteValue);

        // Casting : 데이터 타입을 변환하는 것
        // Implicit casting : 자동으로 데이터 타입이 변환되는 것
        // Explicit casting : 개발자가 데이터 타입을 변환하는 것
        // byte > short > int > long > float > double
        // byte < short < int < long < float < double

        // Implicit casting
        byte myByteValue = 10;
        short myShortValue = myByteValue;
        int myIntValue = myShortValue;
        long myLongValue = myIntValue;

        // Explicit casting
        myByteValue = (byte) myLongValue;

    }

}