package chap6.composition;

public class Main {
    public static void main(String[] args) {

        ComputerCase theCase = new ComputerCase("220B", "Dell", "240");
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, "2540 x 1440");
        MotherBoard theMotherBoard = new MotherBoard("BJ-200", "Asus", 4, 6, "v2.44");
        PersonalComputer thePC = new PersonalComputer("2208", "Dell", theCase, theMonitor, theMotherBoard);

//        thePC.getMonitor().drawPixelAt(10, 10, "red");
//        thePC.getMotherBoard().loadProgram("Windows OS");
//        thePC.getComputerCase().pressPowerButton();
        // get으로 마음대로 접근하지 못하게 막음
        // 캡슐화
        thePC.powerUp();

        System.out.println("=====================================");

        SmartKitchen kitchen = new SmartKitchen();

//        kitchen.getDishWasher().setHasWorkToDo(true);
//        kitchen.getBrewMaster().setHasWorkToDo(true);
//        kitchen.getIceBox().setHasWorkToDo(true);
//
//        kitchen.getDishWasher().doDishes();
//        kitchen.getIceBox().orderFood();
//        kitchen.getBrewMaster().brewCoffee();

        kitchen.setKitchenState(true, false, true);
        kitchen.doKitchenWork();
    }
}
