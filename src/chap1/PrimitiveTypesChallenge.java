package chap1;

public class PrimitiveTypesChallenge {
    public static void main(String[] args) {
        byte byteNumber = 10;
        short shortNumber = 200;
        int intNumber = 30000;
        int result = 30000;
        System.out.println(intNumber == result);

        long longNumber = 50000L + 10 * (byteNumber + shortNumber + intNumber);
    }
}
