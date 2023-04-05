package chap1;

public class StartingOutWithExpressions {
    /*
     * 자바 코드는 대소문자를 구분한다.
     * 예약어는 항상 소문자로 구성된다.
     * */
    public static void main(String[] args) {
        int myFirstNumber = (10 + 5) + (2 * 10);
        System.out.println(myFirstNumber);

        int mySecondNumber = 12;
        int myThirdNumber = 6;

        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;
        System.out.println(myTotal);

        int myLastOne = 1000 - myTotal;
        System.out.println(myLastOne);
    }
}
