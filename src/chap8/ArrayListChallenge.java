package chap8;

import java.util.*;

public class ArrayListChallenge {
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();
        String userMenu = """
                Available actions:
                0 - to shutdown
                1 - to add item(s) to list(comma delimited list)
                2 - to remove any items (comma delimited list)
                Enter a number for wich action you want to do:\s""";
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.print(userMenu);
            input = sc.nextLine();
            switch (input) {
                case "0" -> System.out.print("Shutting down...");
                case "1" -> {
                    System.out.print("Add item : ");
                    String inputItem = sc.nextLine().toUpperCase();
                    if(groceryList.contains(inputItem)){
                        System.out.println("Item already exists");
                        System.out.println("groceryList: " + groceryList);
                        break;
                    }
                    groceryList.add(inputItem);
                    groceryList.sort(Comparator.naturalOrder());
                    System.out.println("groceryList: " + groceryList);
                }
                case "2"-> {
                    System.out.print("Remove item : ");
                    String inputItem = sc.nextLine().toUpperCase();
                    groceryList.remove(inputItem);
                    System.out.println("groceryList: " + groceryList);
                }
                default -> System.out.println("Invalid input");
            }
        }
        while (!input.equals("0"));
    }
}
