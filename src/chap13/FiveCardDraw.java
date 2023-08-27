package chap13;

import java.util.*;

public class FiveCardDraw {

    /*
        1. 카드 덱 생성.
        2. 카드를 섞는다.
        3. 플레이어 수를 임의로 정한 후 플레이어 수만큼 카드를 나눠준다.
        4. 각 플레이어의 카드를 평가한다.
    */
    public static void main(String[] args) {


        // 1. 카드 덱 생성.
        List<Card> cards = Card.getStandardDeck();

        // 2. 카드를 임의로 섞는다.
        cardShuffle(cards);
        Card.printDeck(cards);

        // 3. 플레이어 수를 임의로 정한 후 플레이어 수만큼 5장씩 카드를 나눠준다.
        // 5장 주기
        int totalPlayer = 4;
        List<List<Card>> playersDeck = new ArrayList<>(totalPlayer);
        for (int i = 0; i < totalPlayer; i++) {

            playersDeck.add(cards.subList(i * 5, (i + 1) * 5));
        }

        System.out.println(playersDeck);

        // 4. 평가
        Comparator<Card> sortByRankAndThenSuit = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        playersDeck.forEach(s -> {
            s.sort(sortByRankAndThenSuit);
            System.out.println(s);
        });

    }

    private static List<Card> cardShuffle(List<Card> cards){

        int min = 20;
        int max = 35;

        Random random = new Random();
        Collections.shuffle(cards);
        Collections.rotate(cards, random.nextInt(max - min) + min);
        return cards;
    }

//    public static List<Card> cardDraw(List<Player> players, List<Card> cards){
//
//    }
}
