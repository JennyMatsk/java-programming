package lab4;

// Перечисление всех возможных типов клеток
enum CellState {HEALTHY, IMMUNE, INFECTED}


// Класс родитель для всех типов клеток
public class Cell {
    protected int x, y;
    protected CellState state;

    public Cell(int x, int y, CellState state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    // Необходимо для дальнейшей реализации полиморфизма
    public void update() {
    }

}
