package chap8;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListChallenge {
    public static void main(String[] args) {
        LinkedList<Town> towns = new LinkedList<>();
        addAndSort(towns, new Town("Adelaide", 1374));
        addAndSort(towns, new Town("Alice Springs", 2771));
        addAndSort(towns, new Town("Brisbane", 917));
        addAndSort(towns, new Town("Darwin", 3972));
        addAndSort(towns, new Town("Melbourne", 878));
        addAndSort(towns, new Town("Perth", 3945));
        towns.addFirst(new Town("Sydney", 0));

        ListIterator<Town> iterator = towns.listIterator();
        String menu = """
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                Enter Value:\s""";
        String input;
        boolean forward = true;

        System.out.print(menu);

        do {
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine().toUpperCase();
            switch (input) {
                case "F" -> {
                    if(!forward){
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Going forward to " + iterator.next().toString());
                    } else {
                        System.out.println("Reached the end of the list");
                    }
                }
                case "B" -> {
                    if (forward){
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Going backward to " + iterator.previous().toString());
                    } else {
                        System.out.println("Reached the beginning of the list");
                    }
                }
                case "L" -> {
                    for (Town town : towns) {
                        System.out.println(town.toString());
                    }
                }
                case "M" -> System.out.println(menu);
                case "Q" -> System.out.println("Quitting...");
                default -> {
                    System.out.println("Invalid input");
                    System.out.print(menu);
                }
            }
        } while (!input.equals("Q"));
    }

    private static void addAndSort(LinkedList<Town> towns, Town newTown) {

        int comparison;

        for (Town town : towns) {
            comparison = town.getDistanceFromSydney().compareTo(newTown.getDistanceFromSydney());
            switch (comparison) {
                case 0 -> {
                    System.out.println("Town already exists");
                    return;
                }
                case 1 -> {
                    towns.add(towns.indexOf(town), newTown);
                    return;
                }
                default -> {
                }
            }
        }
        towns.add(newTown);
    }
}


class Town {
    private String place;
    private Integer distanceFromSydney;

    public Town(String place, Integer distanceFromSydney) {
        this.place = place;
        this.distanceFromSydney = distanceFromSydney;
    }

    public Integer getDistanceFromSydney() {
        return distanceFromSydney;
    }

    @Override
    public String toString() {
        return "Town{" +
                "place='" + place + '\'' +
                ", distanceFromSydney=" + distanceFromSydney +
                '}';
    }
}
