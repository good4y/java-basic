package chap4;

public class SwitchChallenge {
    public static void main(String[] args) {

    }
    public static void pritntDayOfWeek(int day){
        String dayOfWeek = switch(day){
            case 0 -> {yield "Sunday";}
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid day";
        };
        System.out.println(dayOfWeek);
    }

    public static void traditionalSwitch(String phonetic){
        switch (phonetic) {
            case "A":
                System.out.println("Able");
                break;
            case "B":
                System.out.println("Baker");
                break;
            case "C":
                System.out.println("Charlie");
                break;
            case "D":
                System.out.println("Dog");
                break;
            case "E":
                System.out.println("Easy");
                break;
            case "F":
                System.out.println("Fox");
                break;
            default:
                System.out.println(phonetic + " is Not Found");

        }
    }
}
