package chap13;

import java.util.*;

public class CollectionsMethods {

    public static void main(String[] args) {

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Ace of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        // cards 객체는 52개의 공간을 할당할 수 있지만, 실제로는 아무것도 없는 상태이다.
        // 따라서 컬렉션의 상태를 변화시키는 fill과 같은 메서드를 사용하면 아무런 변화도 일어나지 않는다.
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("card size = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Ace of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "kings of Clubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        // 만약 cards 리스트에 요소가 없다면 복사할 공간이 없기 때문에 에러가 발생한다.
        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        // shuffle 메서드는 랜덤한 순서로 리스트를 섞는다.
        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        // reverse 메서드는 리스트의 요소를 역순으로 정렬한다.
        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck", 4);

        Comparator<Card> sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed: ", 13);

        // subList 메서드는 리스트의 일부를 반환한다.
        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

        // indexOfSubList 메서드는 리스트에서 서브리스트의 첫 번째 요소의 인덱스를 반환한다.
        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        // disjoint 메서드는 두 리스트가 공통된 요소가 없는지 확인한다.
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);

        boolean disjoint1 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = " + disjoint1);


        // binarySearch 메서드는 리스트에서 특정 요소의 인덱스를 반환한다.
        // 이 메서드는 리스트가 정렬되어 있어야 한다.
        deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex = " + foundIndex);
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        // replaceAll 메서드는 리스트에서 특정 요소를 다른 요소로 바꾼다.
        // 결과값으로 boolean을 반환한다.(요소를 바꾸었으면 true, 바꾸지 못했으면 false)
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        if(Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
            System.out.println("Replaced");
        } else {
            System.out.println("Not replaced");
        }

        // frequency 메서드는 리스트에서 특정 요소의 개수를 반환한다.
        System.out.println("Ten of Clubs Cards = " + Collections.frequency(deck, tenOfClubs));

        // min, max 메서드는 리스트에서 가장 작은 요소와 가장 큰 요소를 반환한다.
        System.out.println("Best Card = " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgorithm));

        Comparator<Card> sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by suit, rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        // rotate 메서드는 int 값만큼 리스트를 회전시킨다.
        Collections.rotate(copied, 2);
        System.out.println("UnRotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + 2 + ": " + copied);

        Collections.rotate(copied, -4);
        System.out.println("UnRotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + -4 + ": " + copied);

        // swap 메서드는 두 요소의 위치를 바꾼다.
        copied = new ArrayList<>(deck.subList(0, 13));
        for (int i = 0; i < copied.size() / 2; i++) {
            Collections.swap(copied, i, copied.size() - i - 1);
        }
        System.out.println("Manual reversed : " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.reverse(copied);
        System.out.println("Using reverse :" + copied);
    }
}
