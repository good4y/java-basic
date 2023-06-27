package chap7;

public class VarArgs {
    public static void main(String... args) {
        System.out.println("hello world again");

        // split 메서드는 정규표현식으로 문자열을 나누어 배열로 반환한다.
        String[] splitStrings = "hello world again".split(" ");
        printText(splitStrings);

        System.out.println("_".repeat(20));
        printText("hello");

        System.out.println("_".repeat(20));
        printText("hello", "world", "again");

        System.out.println("_".repeat(20));
        printText();

        // String.join() 메서드는 가변인자를 받아 하나의 문자열로 합친다.
        String[] sArray = {"first", "second", "third", "fourth", "fifth"};
        System.out.println(String.join(",", sArray));
    }

    // Variable Arguments (가변인자)
    // 가변인자는 메서드의 파라메터로 배열을 받는 것과 같다.
    private static void printText(String... texts){
        for (String s : texts) {
            System.out.println(s);
        }
    }
}
