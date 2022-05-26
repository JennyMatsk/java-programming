package lab3;

public class Player {
    private Card[] cards;

    public Player(){
        int maxCards = 0;
        cards = new Card[maxCards];
    }
    public Player(Card[] cards) {
        this.cards = cards;  // Получение объекта извне и хранение внутри другого компонента наз-ся агрегация
    }

    public Card[] getCards() {
        return cards;
    }

    public void addCard(Card card) {

    }
}
