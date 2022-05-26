package lab3;

public class Player {
    // Объявление массива карт в руке
    private Card[] cards;
    // Объявление количетва карт в руке
    private int cardsCount;

    // Конструктор "начального" игрока
    public Player() {
        int maxCards = 18;
        cards = new Card[maxCards];
        int cardsCount = 0;
    }

    // Получение карты извне
    public Player(Card[] cards) {
        this.cards = cards;  // Получение объекта извне и хранение внутри другого компонента наз-ся агрегация
    }

    // Вывод последовательности карт в руке
    public void getCards() {
        for (Card i : cards) {
            System.out.println(i.getSuit() + " " + i.getValue());
        }
    }

    // Добавление карты в руку
    public void addCard(Card card) {
        cards[cardsCount] = card;
        cardsCount++;
    }
}
