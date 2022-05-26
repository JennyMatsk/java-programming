package lab3;

enum Suit {E_SPADES, E_CLUBS, E_DIAMONDS, E_HEARTS}

enum Value {ONE}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }
}
