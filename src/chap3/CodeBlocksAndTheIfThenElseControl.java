package chap3;

public class CodeBlocksAndTheIfThenElseControl {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("highScore = " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        System.out.println("calculateScore() = " + calculateScore(gameOver, score, levelCompleted, bonus));
    }

    // 메서드: 코드 블록을 재사용하기 위해 사용
    // 메서드 시그니처: 메서드 이름과 파라미터 목록
    // 파라메터 목록이 다르다면 같은 이름을 가진 메서드를 여러 개 만들 수 있다.
    // 다른 언어에서 메서드는 파라메터에 기본 값을 가질 수 있지만 자바에서는 기본 값을 가질 수 없다.

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        if(gameOver){
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
        }

        return -1;
    }
}
