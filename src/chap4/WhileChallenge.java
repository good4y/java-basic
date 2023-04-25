package chap4;

public class WhileChallenge {
    public static void main(String[] args) {
        int number = 4;
        int finish = 20;
        int odd = 0;
        int even = 0;

        while (number <= finish){
            number++;
            if (!isEvenNumber(number)){
                odd++;
                continue;
            }
            System.out.println(number);
            even++;
        }

        System.out.println("even = " + even);
        System.out.println("odd = " + odd);
    }

    public static boolean isEvenNumber(int number){
        return number % 2 == 0;
    }
}
