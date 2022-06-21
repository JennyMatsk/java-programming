package lab4;

public class HealthyCell extends Cell {

    // Вызываем базовый корнструктор клетки из класса-родителя Cell, заменяя значение состояния на "здоров"
    public HealthyCell(int x, int y) {
        super(x, y, CellState.HEALTHY);
    }

    public void update() {
    }
}
