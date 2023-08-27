package chap13;

import java.util.List;

public class Player {

    private List<Card> deck;
    private int chip;

    public Player(List<Card> deck) {
        this.deck = deck;
        chip = 1000;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public int getChip() {
        return chip;
    }
}
