package chap6.encapsulation;

/*
 * TODO 캡슐화를 해야하는 이유
 *    - 클래스 내부의 필드 보호
 *    - 역할 분리
 *
 */

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.fullName = "Kim";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        player.health = 200; // 문제 1. 필드 접근을 직접 허용하여 메서드의 역할을 뺏음 (체력이 100 이상 안되는것)
        player.loseHealth(11);
        System.out.println("Remaining health = " + player.healthRemaining());

        System.out.println("=====================================");

        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Kim", 200, "Sword");
        enhancedPlayer.loseHealth(100);
        System.out.println("Initial health is " + enhancedPlayer.healthRemaining());

        System.out.println("=====================================");

        Printer printer = new Printer(50, true);
        System.out.println("Initial page count = " + printer.getPagesPrinted());

        int pagesPrinted = printer.printPages(5);
        System.out.printf("Current Job Pages: %d, Printer Total: %d %n", pagesPrinted, printer.getPagesPrinted());

        pagesPrinted = printer.printPages(10);
        System.out.printf("Current Job Pages: %d, Printer Total: %d %n", pagesPrinted, printer.getPagesPrinted());
    }
}