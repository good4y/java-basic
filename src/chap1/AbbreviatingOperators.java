package chap1;

public class AbbreviatingOperators {
    public static void main(String[] args) {
        int result = 1;
        result += 1;
        System.out.println(result);

        result -= 1;
        System.out.println(result);

        result *= 2;
        System.out.println(result);

        result /= 2;
        System.out.println(result);

        System.out.println(result++); // 1
        System.out.println(result); // 2

        System.out.println(++result); // 3
        System.out.println(result); // 3
    }
}
