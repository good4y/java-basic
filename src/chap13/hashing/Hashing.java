package chap13.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hashing {

    public static void main(String[] args) {

        String aText = "Hello";
        String bTest = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bTest, cText, dText, eText);

        hellos.forEach(s -> System.out.printf("%s hashcode: %d%n", s, s.hashCode()));

        Set<String> mySet = new HashSet<>(hellos);

        System.out.println("myset = " + mySet);
        System.out.println("# of elements in mySet: " + mySet.size());

        for (String s : mySet) {
            System.out.println(s + ": ");
            for (int i = 0; i < hellos.size(); i++) {
                if(s == hellos.get(i)) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println(" ");
        }

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
        cards.forEach(s -> System.out.println(s + ": " + s.hashCode()));

        // HashSet은 hashcode 메서드와 equals 메서드를 사용하여 중복 여부를 확인 후 저장한다.
        Set<PlayingCard> deck = new HashSet<>();
        for (PlayingCard c : cards) {
            if(!deck.add(c)){
                System.out.println("Duplicate card in deck: " + c);
            }
        }

        System.out.println(deck);

    }
}
