package lab4;

public class ImmuneCell extends HealthyCell {

    // Задаём  общее "время жизни" клетки
    private int lifeTime = 4;

    // Текущее "время жизни" клетки
    private int currentLifeTime = 0;

    // Вызываем базовый конструктор клетки из класса-родителя HealthyCell
    // Ссылаемся на класс Skin, дабы иметь возможность ссылаться на конкретную клетку кожи
    public ImmuneCell(int x, int y, Skin skin) {
        super(x, y, skin);
    }

    // С каждым обновлением увеличиваем текущее время жизни, при необходимости заменяем класс эту клетку на новую здоровую
    @Override
    public void update() {
        currentLifeTime++;
        if (currentLifeTime >= lifeTime) {
            skin.setCell(new HealthyCell(x, y, skin));
        }
    }

    @Override
    public String getCellSymbol() {
        return "\uD83D\uDE91";
    }
}
