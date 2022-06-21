package lab3;

// Перечисление возможных мастей
enum Suit {SPADES, CLUBS, DIAMONDS, HEARTS}

// Перечисление возможных значений карт
enum Value {SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

//Перечисление возможных владельцев карты
enum Owner {DECK, PLAYERONE, PLAYERTWO}

public class Card {
    // Хранит информацию о масти
    private Suit suit;
    // Хранит информацию о значении краты
    private Value value;
    // Хранит принадлежность игроку или колоде
    private Owner owner;

    // Коструктор карты, с получаемым извне значением и мастью
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    // Получение масти карты
    public Suit getSuit() {
        return suit;
    }

    //Получение значения карты
    public Value getValue() {
        return value;
    }

    //Получение владельца карты
    public Owner getOwner() {
        return owner;
    }
}
