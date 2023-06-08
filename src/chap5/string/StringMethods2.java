package chap5.string;

public class StringMethods2 {
    public static void main(String[] args) {
        String birthDate = "25/11/1982";
        int startingIndex = birthDate.indexOf("1982");
        System.out.println("startingIndex = " + startingIndex);
        System.out.println("Birth year = " + birthDate.substring(startingIndex));

        // substring() 메서드는 시작 인덱스부터 끝 인덱스 직전까지의 문자열을 반환한다.
        System.out.println("Month = " + birthDate.substring(3, 5));

        // join() 메서드는 인자로 전달된 문자열을 delimiter로 구분하여 하나의 문자열로 만든다.
        String newDate = String.join("/", "25", "11", "1982");
        System.out.println("newDate = " + newDate);


        // concat() 메서드는 인자로 전달된 문자열을 호출한 문자열 뒤에 붙인다.
        // 아래 코드는 4개의 String 객체가 생성된다.
        newDate = "25";
        newDate = newDate.concat("/");
        newDate = newDate.concat("11");
        newDate = newDate.concat("/");
        newDate = newDate.concat("1982");
        System.out.println("newDate = " + newDate);

        // The string concatenation operator + implicitly creates a new String object when the result is not a constant expression.
        // https://docs.oracle.com/javase/specs/jls/se17/html/jls-4.html#jls-4.3.3
        // 피연산자(String)와 다른 타입의 객체와 + 연산 수행 시 String 타입으로 변환 후 concatenation 수행
        // 따라서 총 3개의 String 객체가 생성된다. (피연산자, 변환된 피연산자, 결과)
        newDate = "25" + "/" + "11" + "/" + "1982";
        System.out.println("newDate = " + newDate);

        // 위 두 코드는 같은 결과를 반환하지만, 각각의 연산 마다 새로 String 객체를 생성하여 메모리를 낭비한다.

        // 메서드 체이닝
        newDate = "25".concat("/").concat("11").concat("/").concat("1982");
        System.out.println(newDate);

        // Replace() 메서드는 첫 번째 인자로 전달된 문자 또는 문자열을 두 번째 인자로 전달된 문자 또는 문자열로 바꾼다.
        System.out.println(newDate.replace('/', '-'));
        System.out.println(newDate.replace("2", "00"));

        // 아래 메서드는 문자를 넣을 수 없다.
        // 정규식을 이용하여 문자열을 바꾸는 메서드
        System.out.println(newDate.replaceFirst("/", "-"));
        System.out.println(newDate.replaceAll("/", "---"));

        // repeat() 메서드는 문자열을 인자로 전달된 수만큼 반복하여 반환한다.
        System.out.println("ABC\n".repeat(3));
        System.out.println("-".repeat(20));

        // indent() 메서드는 문자열의 각 라인에 인자로 전달된 수만큼의 공백을 추가한다.
        System.out.println("ABC\n".repeat(3).indent(8));
        System.out.println("-".repeat(20));

        // indent() 메서드는 인자로 전달된 수가 음수일 경우, 문자열의 각 라인에 인자로 전달된 수만큼의 공백을 제거한다.
        System.out.println("    ABC\n".repeat(3).indent(-2));
        System.out.println("-".repeat(20));
    }
}
