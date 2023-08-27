package chap13;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {
    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage() {
            return switch (this) {
                case CLUB -> 9827;
                case DIAMOND -> 9830;
                case HEART -> 9829;
                case SPADE -> 9824;
            };
        }
    }

    public static Card getNumericCard(Suit suit, int number) {
        return new Card(suit, String.valueOf(number), number);
    }

    public static Card getFaceCard(Suit suit, char abbrev) {
        return new Card(suit, String.valueOf(abbrev), switch (abbrev) {
            case 'J' -> 11;
            case 'Q' -> 12;
            case 'K' -> 13;
            case 'A' -> 14;
            default -> throw new IllegalArgumentException();
        });
    }

    public static List<Card> getStandardDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                deck.add(getNumericCard(Suit.values()[i], j));
            }

            for (char c : new char[]{'J', 'Q', 'K', 'A'}) {
                deck.add(getFaceCard(Suit.values()[i], c));
            }
        }

        return deck;
    }

    public static void printDeck(List<Card> deck) {
        printDeck(deck, "Current Deck", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows) {

        System.out.println("-".repeat(30));
        if(description != null){
            System.out.println(description);
        }
        int cardsInRow = deck.size() / rows;
        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

    @Override
    public String toString() {
        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }
}
