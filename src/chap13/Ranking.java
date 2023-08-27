package chap13;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FOUR_OF_A_KIND, FULL_HOUSE, FLUSH, THREE_OF_A_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD;

        private int countSameRank(List<Card> cards){
            int[] countRank = new int[13];
            for (Card card : cards) {
                countRank[card.rank()]++;
            }

            return Arrays.stream(countRank).max().getAsInt();
        }
    }
