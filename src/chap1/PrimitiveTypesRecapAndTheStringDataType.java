package chap1;

public class PrimitiveTypesRecapAndTheStringDataType {
    public static void main(String[] args) {
        /*
        * String: 문자열
        * String은 불변 클래스이다.
        * 따라서 String은 새로운 값을 할당할 때마다 새로운 객체를 생성한다.
        * 만약, String 객체에 + 연산자를 사용하면, 새로운 객체를 생성하여 기존 객체에 할당한다.
        * */

        String myString = "This is a string";
        System.out.println("myString is equal to " + myString);

        myString = myString + ", and this is more.";
        System.out.println("myString is equal to " + myString);

        myString = myString + "I wish I could use \"double quotes\" in my string.";
        System.out.println("myString is equal to " + myString);
    }
}
