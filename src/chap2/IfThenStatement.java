package chap2;

public class IfThenStatement {
    public static void main(String[] args) {
        boolean isAlien = false;

        if (isAlien == false)
            System.out.println("It is not an alien!");
        System.out.println("And I am scared of aliens");

//      할당 연산자
        int topScore = 80;
        if (topScore == 100)
            System.out.println("You got the high score!");

        if (topScore != 100)
            System.out.println("You got the high score!");

        if (topScore > 100)
            System.out.println("You got the high score!");


        // logical AND
        int secondTopScore = 60;
        if ((topScore > secondTopScore) && (topScore < 100))
            System.out.println("Greater than second top score and less than 100");


        // logical OR
        if ((topScore > 90) || (secondTopScore <= 90))
            System.out.println("One of these tests is true");

        boolean isCar = false;

//      실제로 isCar 객체에 true를 할당해버림.
//      따라서 if문은 항상 true를 반환하게 된다.
        if (isCar = true) {
            System.out.println("This is not supposed to happen");
        }

//      기본적으로 boolean 사용 시 !isCar과 같은 방식으로 not 연산자를 사용하는것을 추천한다.
//      1. 실수로 = 을 이용한 할당 연산자를 사용하는 것을 방지할 수 있다.
//      2. 코드의 가독성을 높일 수 있다.
        if (!isCar) {
            System.out.println("This is what I wanted");
        }

//      삼항 연산자
        boolean wasCar = isCar ? true : false;
        if (wasCar) {
            System.out.println("wasCar is true");
        }

//      연습문제
        int ageOfClient = 20;
        String ageTest = ageOfClient >= 18 ? "Adult" : "Not an adult";
        System.out.println(ageTest);

        String makeOfCar = "BMW";
        boolean isDomestic = makeOfCar == "BMW" ? true : false;
        isDomestic = makeOfCar != "BMW";
    }
}
