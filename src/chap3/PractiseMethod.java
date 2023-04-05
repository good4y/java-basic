package chap3;

public class PractiseMethod {
    public static void main(String[] args) {
        boolean a1 = PractiseMethod.shouldWakeUp1(false, 6);
        boolean a2 = PractiseMethod.shouldWakeUp2(false, 6);
        System.out.println("a = " + a1);
        System.out.println("a = " + a2);

        System.out.println(isTeen(0));
    }

    public static boolean shouldWakeUp2(boolean barking, int hourOfDay){
        if(barking && (hourOfDay > 0 && hourOfDay < 8) || (hourOfDay < 24 && hourOfDay > 22)){
            return true;
        }
        return false;
    }

    public static boolean shouldWakeUp1(boolean barking, int hourOfDay){
        if((hourOfDay > 0 && hourOfDay < 8) || (hourOfDay < 24 && hourOfDay > 22) && barking){
            return true;
        }
        return false;
    }

    public static boolean isTeen(int num1){
        return num1 >= 13 && num1 <= 19;
    }
}
