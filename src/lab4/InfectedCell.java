package lab4;

import java.util.Random;

public class InfectedCell extends HealthyCell {

    // Задаём  общее "время жизни" клетки
    private int lifeTime = 6;

    // Текущее "время жизни" клетки
    private int currentLifeTime = 0;

    // Вызываем базовый корнструктор клетки из класса-родителя HealthyCell
    public InfectedCell(int x, int y, Skin skin) {
        super(x, y, skin);
    }

    // С каждым обновлением увеличиваем текущее время жизни,
    // При необходимости заменяем эту клетку на новую имунную, заражаем соседей
    @Override
    public void update() {
        infect();
        currentLifeTime++;
        if (currentLifeTime >= lifeTime) {
            skin.setCell(new ImmuneCell(x, y, skin));
        }
    }

    @Override
    public String getCellSymbol() {
        return "\uD83E\uDD12";
    }

    // Заражение соседа с учётом вероятности 0,5
    private void infect() {
        HealthyCell[] neighbours = findHealthyNeighbours();
        for (int i = 0; i < neighbours.length; i++) {
            Random rnd = new Random();
            boolean success = rnd.nextBoolean();
            if (success) {
                int x = neighbours[i].x;
                int y = neighbours[i].y;
                skin.setCell(new InfectedCell(x, y, skin));
                break;
            }
        }
    }

    // Поиск здоровых соседей среди всех возможных, учитывая возможные границы поля.
    // Список соседей формируется по принципу обхода массива по часовой стрелке
    private HealthyCell[] findHealthyNeighbours() {
        int countOfPossibleNeighbours = 8;
        HealthyCell[] possibleNeighbours = new HealthyCell[countOfPossibleNeighbours];
        int[][] coords = new int[countOfPossibleNeighbours][2];
        coords[0][0] = -1;
        coords[0][1] = -1;
        coords[1][0] = -1;
        coords[1][1] = 0;
        coords[2][0] = -1;
        coords[2][1] = 1;
        coords[3][0] = 0;
        coords[3][1] = 1;
        coords[4][0] = 1;
        coords[4][1] = 1;
        coords[5][0] = -1;
        coords[5][1] = 0;
        coords[6][0] = 1;
        coords[6][1] = -1;
        coords[7][0] = 0;
        coords[7][1] = -1;

        Random rnd = new Random();
        int startPosition = rnd.nextInt(8);

        int currentPosition = startPosition;
        int counter = 0;
        int neighboursCount = 0;
        while (counter < 8) {
            int cellY = coords[currentPosition][0];
            int cellX = coords[currentPosition][1];
            if (x + cellX >= 0 && x + cellX != skin.getSize() && y + cellY >= 0 && y + cellY != skin.getSize()) {
                HealthyCell cellToCheck = skin.getCell(x + cellX, y + cellY);
                if (!(cellToCheck instanceof ImmuneCell) && !(cellToCheck instanceof InfectedCell)) {
                    possibleNeighbours[neighboursCount] = cellToCheck;
                    neighboursCount++;
                }
            }
            currentPosition++;
            if (currentPosition == 8) currentPosition = 0;
            counter++;
        }
        HealthyCell[] neighbours = new HealthyCell[neighboursCount];
        for (int i = 0; i < neighboursCount; i++) {
            neighbours[i] = possibleNeighbours[i];
        }
        return neighbours;
    }
}
