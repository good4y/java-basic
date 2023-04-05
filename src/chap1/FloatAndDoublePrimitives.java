package chap1;

public class FloatAndDoublePrimitives {
    public static void main(String[] args) {

        /*
        * float: 32비트 부동소수점 숫자
        * double: 64비트 부동소수점 숫자
        * 자바에서는 기본적으로 double을 사용한다.
        * 그 이유는 정확한 데이터 타입을 사용하는 것이 메모리를 절약하는 것보다 중요하기 때문이다.
        * */
        float minFloatValue = Float.MIN_VALUE;
        float maxFloatValue = Float.MAX_VALUE;

        System.out.println("Float Minimum Value = " + minFloatValue);
        System.out.println("Float Maximum Value = " + maxFloatValue);

        double minDoubleValue = Double.MIN_VALUE;
        double maxDoubleValue = Double.MAX_VALUE;

        System.out.println("Double Minimum Value = " + minDoubleValue);
        System.out.println("Double Maximum Value = " + maxDoubleValue);

        float otherFloatValue = (float) 2.25;
    }
}
