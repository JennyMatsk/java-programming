package lab3;

import java.util.Random;

public class Deck {
    // Объявление массива карт в колоде
    private Card[] deck;
    // Объявление количества взятых из колоды карт
    public int cardsGot;

    // Конструктор не перемешанной колоды карт
    public Deck() {
        int maxCards = 36;
        deck = new Card[maxCards];
        cardsGot = 0;

        for (int i = 0; i < maxCards; i++) {
            // Создание карт и заполнение массива
            deck[i] = new Card(Suit.values()[i / 9], Value.values()[i % 9]);
        }
    }

    //  Метод перемешивания колоды карт
    public void mixDeck() {
        Random rnd = new Random();
        for (int i = 0; i < deck.length; i++) {
            int index = rnd.nextInt(i + 1);
            // Замена двух значений при помощи временной переменной
            Card tmp = deck[index];
            deck[index] = deck[i];
            deck[i] = tmp;
        }
    }

    // Вывод на экран колоды карт
    public void printDeck() {
        for (Card i : deck) {
            System.out.println(i.getSuit() + " " + i.getValue());
        }
    }

    // Получение карты из колоды
    public Card getCard() {
        cardsGot++;
        return deck[cardsGot - 1];
    }
}
