package chap4;

public class TheSwitchStatement {
    public static void main(String[] args) {
        int switchValue = 1;

        String a = "123";
        int b = Integer.parseInt(a);
        int c = Integer.valueOf(a);

        switch(switchValue){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Value was 3, 4, or 5");
                break;
            default:
                System.out.println("Value was not 1, 2, 3, 4, or 5");
                break;
        }

        // enhanced switch statement
        switch (switchValue){
            case 1 -> System.out.println("Value was 1");
            case 2 -> System.out.println("Value was 2");
            case 3, 4, 5 -> System.out.println("Value was 3, 4, or 5");
            default -> System.out.println("Value was not 1, 2, 3, 4, or 5");
        }
    }

    public static String getQuarter(String month){
        switch (month){
            case "January", "February", "March":{
                System.out.println("1st Quarter");
                return "1st Quarter";
            }
            case "April":
            case "May":
            case "June":
                return "2nd Quarter";
            case "July":
            case "August":
            case "September":
                return "3rd Quarter";
            case "October":
            case "November":
            case "December":
                return "4th Quarter";
            default:
                return "Invalid month";
        }


    }

    // 연산이 필요한 경우 yield 키워드를 사용한다.
    public static String getQuarterEnhanced(String month){
        return switch (month){
            case "January", "February", "March" -> "1st Quarter";
            case "April", "May", "June" -> "2nd Quarter";
            case "July", "August", "September" -> "3rd Quarter";
            case "October", "November", "December" ->  "4th Quarter";
            default -> {
                System.out.println("Unexpected value: " + month);
                yield "Invalid month";
            }
        };
    }
}
