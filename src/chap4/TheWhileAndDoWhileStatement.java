package chap4;

public class TheWhileAndDoWhileStatement {
    public static void main(String[] args) {
        int i = 0;
        while(i <= 5) {
            System.out.println("i = " + i);
            i++;
        }

        int j = 0;
        boolean isReady = false;
        do {
            if(j > 5){
                break;
            }
            if(j == 3){
                continue;
            }
            System.out.println("j = " + j);
            j++;
            isReady = j > 0;
        }while (isReady);
    }
}
