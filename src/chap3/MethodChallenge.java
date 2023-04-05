package chap3;

public class MethodChallenge {
    public static void main(String[] args) {

        // 경계 테스트를 진행함으로써 메소드가 정상적으로 작동하는지 확인한다.
        // 경계 테스트란 메소드가 정상적으로 작동하는지 확인하기 위해 문제가 발생할 수 있는 경계값을 테스트하는 것을 의미한다.
        int highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Tim", highScorePosition);

        highScorePosition = calculateHighScorePosition(999);
        displayHighScorePosition("Bob", highScorePosition);

        highScorePosition = calculateHighScorePosition(499);
        displayHighScorePosition("Percy", highScorePosition);

        highScorePosition = calculateHighScorePosition(100);
        displayHighScorePosition("Gilbert", highScorePosition);

        highScorePosition = calculateHighScorePosition(25);
        displayHighScorePosition("James", highScorePosition);
    }

    public static void displayHighScorePosition(String playerName, int position){
        System.out.println(playerName + " managed to get into position " + position + " on the high score list.");
    }

    public static int calculateHighScorePosition(int score){
       if(score >= 1000){
              return 1;
         } else if(score >= 500){
              return 2;
         } else if(score >= 100 && score < 500){ // 31번 째 줄에 의해 경계값 조건으로 500을 넣지 않아도 된다.
              return 3;
         } else {   // else 문은 생략 가능하다.
              return 4;
       }
    }
}
