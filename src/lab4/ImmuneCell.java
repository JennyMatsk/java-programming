package lab4;

public class ImmuneCell extends Cell {

    // Задаём  общее "время жизни" клетки
    private static int lifeTime = 4;

    // Текущее "время жизни" клетки
    private int currentLifeTime = 0;
    Skin skin;

    // Ссылаемся на класс Skin, дабы иметь возможность ссылаться на конкретную клетку кожи
    public ImmuneCell(int x, int y, Skin skin) {
        super(x, y, CellState.IMMUNE);
        this.skin = skin;
    }

    // С каждым обновлением увеличиваем текущее время жизни, при необходимости заменяем класс эту клетку на новую здоровую
    public void update() {
        currentLifeTime++;
        if (currentLifeTime > lifeTime) {
            skin.setCell(x, y, CellState.HEALTHY);
        }
    }
}
