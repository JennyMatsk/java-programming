package lab3;

import java.util.Random;

public class Deck {
    private Card[] cards;
    public static int cardsGot;

    public Deck() {
        int maxCards = 36;
        cards = new Card[maxCards];
        cardsGot = 0;

        for (int i = 0; i < maxCards; i++) {
            // Создание карт и заполнение массива
            cards[i] = new Card(Suit.values()[i / 9], Value.values()[i % 9]);
        }
    }

    public void mixDeck() {
        Random rnd = new Random();
        for (int i = 0; i < cards.length; i++) {
            int index = rnd.nextInt(i + 1);
            // Замена двух значений при помощи временной переменной
            Card tmp = cards[index];
            cards[index] = cards[i];
            cards[i] = tmp;
        }
    }

    public void printDeck() {
        for (Card i : cards) {
            System.out.println(i.getSuit() + " " + i.getValue());
        }
    }

    public Card getCard() {
        cardsGot++;
        return cards[cardsGot - 1];
    }
}
