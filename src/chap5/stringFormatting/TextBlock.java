package chap5.stringFormatting;

public class TextBlock {
    // 멀티라인 문자열 리터럴에 대한 특별한 포맷
    // jdk 15부터 공식적으로 사용 가능하다.

    // \t : 탭
    // \n : 줄바꿈
    // \" : 큰 따옴표
    // \\ : 역슬래시


    public static void main(String[] args) {
        String bulletIt = "Print a Bulleted List:\n" +
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";

        System.out.println(bulletIt);


        // Text Block
        String textBlock = """
                Print a Bulleted List:
                                    \u2022 First Point
                                        \u2022 Sub Point
                                """;
        System.out.println(textBlock);

        int age = 35;
        // %d : 형식 지정자 (정수)
        System.out.printf("Your age is %d\n", age);

        int yearOfBirth = 2023 - age;
        System.out.printf("Age = %d, Year of Birth = %d\n", age, yearOfBirth);

        // %f : 소수 출력 (float)
        System.out.printf("Your age is %.2f%n", (float) age);


        // %d 앞에 숫자를 붙여 문자열을 형식화 -> 빈칸을 공백으로 채움
        for (int i = 1; i <= 100000; i *= 10) {
            System.out.printf("Printing %6d %n", i);
        }

        // JDK 15에 추가된 기능
        // formatting options
        // + 연산에 비해 가독성이 좋다.

        // formatted() 메소드를 이용하는것은 결국 String.format() 메소드를 사용하여 구현하는 것이므로 크게 의미가 없는 약간의 성능 저하가 있다.
        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        formattedString = "Your age is %d".formatted(age);
        System.out.println(formattedString);
    }

}
