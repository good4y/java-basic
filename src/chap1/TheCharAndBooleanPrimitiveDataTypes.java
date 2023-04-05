package chap1;

public class TheCharAndBooleanPrimitiveDataTypes {
    public static void main(String[] args) {
    /*
    * char: 2바이트 또는 16비트 유니코드 문자
    * 자바에서는 문자와 유니코드를 자동으로 매핑하여 처리한다.
    * 유니코드는 0 ~ 65535까지의 숫자를 가지고 있다.
    * unicode table: https://unicode-table.com/ko/
    * */

        // D = U+0044, 68
        char myChar = 'D';
        System.out.println(myChar);
        myChar = 68;
        System.out.println(myChar);
        myChar = '\u0044';
        System.out.println(myChar);

        // challenge
        char myUnicodeChar = '\u003F';
        char mySimpleChar = '?';
        char myDecimalChar = 63;
        System.out.println("myDecimalChar = " + myDecimalChar);
        System.out.println("myUnicodeChar = " + myUnicodeChar);
        System.out.println("mySimpleChar = " + mySimpleChar);


        /*
        * boolean: true 또는 false, 0 또는 1, on 또는 off
        * 접두사 'is' 또는 'has'를 붙여서 사용하는 것이 관례이다.
        * */

        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;

    }
}
