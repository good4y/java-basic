package chap5.string;

public class StringMethods1 {

    public static void main(String[] args) {

        printInformation("Hello, World!");
        printInformation("");
        printInformation(" \t  \n");

        String helloWorld = "Hello, World!";
        System.out.printf("index of r = %d %n", helloWorld.indexOf('r'));
        System.out.printf("index of World = %d %n", helloWorld.indexOf("World"));

        // indexOf()는 정방향 검색이다.
        // 찾고자 하는 문자가 없으면 -1을 반환한다.
        System.out.printf("index of l = %d %n", helloWorld.indexOf('l'));

        // lastIndexOf()는 역방향 검색이다.
        // 찾고자 하는 문자가 없으면 -1을 반환한다.
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l'));

        // 찾고자 하는 문자의 시작점을 다르게 지정할 수 있다.
        System.out.printf("index of l = %d %n", helloWorld.indexOf('l', 3));
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l', 8));

        // toLowerCase()는 모든 문자를 소문자로 변환한다.
        String helloWorldLower = helloWorld.toLowerCase();
        if(helloWorld.equals(helloWorldLower)) {
            System.out.println("Values match. exact match.");
        }

        // equalsIgnoreCase()는 대소문자를 구분하지 않고 비교한다.
        if(helloWorld.equalsIgnoreCase(helloWorldLower)) {
            System.out.println("Values match. Ignore case.");
        }

        if(helloWorld.startsWith("Hello")){
            System.out.println("Starts with Hello");
        }

        if(helloWorld.endsWith("World!")){
            System.out.println("Ends with World!");
        }

        if(helloWorld.contains("World!")){
            System.out.println("String contains World!");
        }

        // contentEquals()는 문자열의 내용이 같은지 비교한다.
        // equals()와는 다르게 CharSequence를 인자로 받아 다른 클래스의 문자열 객체도 비교할 수 있다.
        if(helloWorld.contentEquals(new StringBuffer("Hello, World!") )) {
            System.out.println("Values match. exact match.");
        }

    }

    public static void printInformation(String string){

        int length = string.length();
        System.out.printf("Length: %d %n", length);

        // isEmpty()는 문자열의 길이가 0인지 검사한다.
        if (string.isEmpty()){
            System.out.println("The string is empty.");
            return;
        }

        // isBlank()는 문자열의 길이가 0이거나 공백 문자로만 이루어져 있는지 검사한다.
        if (string.isBlank()){
            System.out.println("The string is blank.");
            return;
        }

        // charAt()는 문자열에서 특정 위치의 문자를 반환한다.
        System.out.printf("First character: %c %n", string.charAt(0));

        System.out.printf("Last character: %c %n", string.charAt(length - 1));
    }

}
