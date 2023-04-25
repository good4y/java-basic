package chap4;

public class ForChallenge {
    public static void main(String[] args) {
        int count = 0;

        for (int i = 10; count < 3 && i < 50; i++) {
            if(isPrime(i)){
                count++;
            }
        }

        int sum = 0;
        count = 0;

        for (int i = 1; i <= 1000; i++) {
            if(i % 3 == 0 && i % 5 ==0){
                sum += i;
                count++;
                System.out.println("i = " + i);
            }

            if(count == 5)
                break;
        }

        System.out.println("sum = " + sum);

    }

    public static boolean isPrime(int n){
        if(n <= 2){
            return n == 2;
        }

        for (int i = 2; i <= n/2; i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
