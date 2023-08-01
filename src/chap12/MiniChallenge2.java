package chap12;

import java.util.function.UnaryOperator;

public class MiniChallenge2 {

    public static void main(String[] args) {

        String source = "1234567890";

        // challenge 2
        String result = everySecondChar(source);
        System.out.println(result);

        // challenge 3
        System.out.println("-----------");
        UnaryOperator<String> everySecondChar = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply(source));

        // challenge 4, 5
        System.out.println("---------");
        System.out.println(everySecondCharEnhanced(source, everySecondChar));


    }

    public static String everySecondChar(String source) {

        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharEnhanced(String source, UnaryOperator<String> unaryOperator){
        return unaryOperator.apply(source);
    }
}
