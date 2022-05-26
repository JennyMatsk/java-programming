package lab3;

public class Deck {
    private Card[] cards;
    public Deck(){
        int maxCards = 36;
        cards = new Card[maxCards];
        for (int i = 0; i < maxCards; i++){
            // Создание карт и заполнение массива
            cards[i] = new Card(Suit.E_DIAMONDS, Value.ONE); // при создании колоды и хранении Deck будут создаваться карты Card, что является композицией (создание и хранение одного объекта в другом)
            Put code here;
        }
    }
}
