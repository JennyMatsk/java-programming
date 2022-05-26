package lab3;

public class Player {
    private Card[] cards;
    private int cardsCount;

    public Player() {
        int maxCards = 18;
        cards = new Card[maxCards];
        int cardsCount = 0;
    }

    public Player(Card[] cards) {
        this.cards = cards;  // Получение объекта извне и хранение внутри другого компонента наз-ся агрегация
    }

    public void getCards() {
        for (Card i : cards) {
            System.out.println(i.getSuit() + " " + i.getValue());
        }
    }

    public void addCard(Card card) {
        this.cards[cardsCount] = card;
        cardsCount++;
    }
}
