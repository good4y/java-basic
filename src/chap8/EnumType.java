package chap8;

import java.util.Random;

public class EnumType {
    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.THURSDAY;
        System.out.println(weekDay);

        for (int i = 0; i < 10; i++) {
            weekDay = getRandomDay();
//            // 기본적으로 name(), ordinal() 메서드를 제공한다.
//            // 각각 열거형 상수의 이름과 순서를 반환한다.
//            System.out.printf("Name is %s, Ordinal Value = %d%n", weekDay.name(), weekDay.ordinal());
//
//            if(weekDay == DayOfTheWeek.SUNDAY) {
//                System.out.println("Sunday is Holiday");
//            }

            switchDayOfWeek(weekDay);
        }

        for (Topping topping : Topping.values()) {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }
    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay){
        int weekDayInteger = weekDay.ordinal() + 1;
        switch(weekDay){
            case WEDNESDAY -> System.out.println("Wednesday is Day " + weekDayInteger);
            case SATURDAY -> System.out.println("Saturday is Day " + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) + weekDay.name().substring(1).toLowerCase() +
                    " is Day " + weekDayInteger);
        }
    }


    public static DayOfTheWeek getRandomDay(){
        int random = new Random().nextInt(7);

        // values() 메서드는 열거형 상수를 배열로 반환한다.
        var allDays = DayOfTheWeek.values();

        return allDays[random];
    }
}

enum DayOfTheWeek{
    // 열거형 상수는 모두 대문자로 작성한다.
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

enum Topping{
    // 각각의 열거형 상수는 클래스의 인스턴스이다.
    // 따라서 필드, 메서드, 생성자까지 가질 수 있다.
    MUSTARD, PICKLES, BACON, CHEDDAR, TOMATO;

    public double getPrice(){
        return switch (this){
            case MUSTARD -> 0.1;
            case BACON -> 0.5;
            case TOMATO -> 0.3;
            default -> 0.0;
        };
    }
}