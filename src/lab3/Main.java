package lab3;

// Колода карт состоит из 36 листов.
// Колода перемешивается, а затем раздается полностью двум игрокам: 1-ая карта – 1-ому игроку, 2-ая карта – 2-ому игроку,
// 3-ая карта – 1-ому игроку, 4-ая карта – 2-ому игроку и т. д.
// Напишите программу, используя объектно-ориентированную методологию,
// котроая создает объект колода, выводит колоду на экран, перемешивает колоду, вновь выводит на экран,
// создает объекты игроков, раздает карт игрокам, выводит на экран последовательности карт каждого игрока.
// Используйте для хранения колоды и последовательностей карт только один массив из 36 элементов.
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.printDeck();
        deck.mixDeck();
        System.out.println();
        deck.printDeck();

        Player playerOne = new Player();
        Player playerTwo = new Player();

        for (int i = 1; i <= 36; i++) {
            if (i % 2 == 0) {
                playerOne.addCard(deck.getCard());
            } else {
                playerTwo.addCard(deck.getCard());
            }
        }

        System.out.println("Player 1:");
        playerOne.getCards();
        System.out.println("Player 2:");
        playerTwo.getCards();
    }
}
