package chap2;

public class Challenge {
    public static void main(String[] args) {

        // 연산자 우선순위 테이블
        // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
        double firstDouble = 20.00d;
        double secondDouble = 80.00d;
        double firstResult = (firstDouble + secondDouble) * 100.00d;
        double secondResult = firstResult % 40.00d;
        boolean isRemainderZero = (secondResult == 0) ? true : false;
        System.out.println("isRemainderZero = " + isRemainderZero);
        if (!isRemainderZero) {
            System.out.println("Got some remainder");
        }
    }
}
