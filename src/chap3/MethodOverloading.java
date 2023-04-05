package chap3;

public class MethodOverloading {
    /*
     * 메서드 오버로딩: 같은 이름의 메서드를 여러 개 만들 수 있다.
     * 메서드 오버로딩의 조건
     * 1. 메서드 이름이 같아야 한다.
     * 2. 파라미터 목록이 달라야 한다. 단순히 파라미터의 이름이 다른것은 컴파일 에러.
     * 3. 메서드 이름이 같더라도 리턴 타입이 다르면 컴파일 에러.
     * */

    public static void main(String[] args) {
        System.out.println("New score is " + calculateScore("Tim", 500));
        System.out.println("New score is " + calculateScore(75));

        System.out.println("5ft, 8in = " + calcFeetAndInchesToCentimeters(5, 8) + "cm");
        System.out.println("157cm = " + calcFeetAndInchesToCentimeters(157) + "cm");
    }

    private static double calcFeetAndInchesToCentimeters(int inches) {
        return inches * 2.54;
    }
    private static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        return calcFeetAndInchesToCentimeters((feet * 12) + inches);
    }


    public static int calculateScore(String playerName, int score){
        System.out.println("Player " + playerName + " scored " + score + " points.");
        return score * 1000;
    }

    public static int calculateScore(int score){
        System.out.println("Unnamed player scored " + score + " points.");
        return score * 1000;
    }

    public static void calculateScore(){
        System.out.println("No player name, no player score.");
    }
}
