package lab4;

import java.util.Random;

public class InfectedCell extends Cell {

    // Задаём  общее "время жизни" клетки
    private static int lifeTime = 6;

    // Текущее "время жизни" клетки
    private int currentLifeTime = 0;
    Skin skin;

    public InfectedCell(int x, int y, Skin skin) {
        super(x, y, CellState.INFECTED);
        this.skin = skin;
    }

    // С каждым обновлением увеличиваем текущее время жизни, при необходимости заменяем класс эту клетку на новую имунную, заражаем соседей
    public void update() {
        infect();
        currentLifeTime++;
        if (currentLifeTime > lifeTime) {
            skin.setCell(x, y, CellState.IMMUNE);
        }
    }

    private Cell[] findHealthyNeighbours() {
        int countOfPossibleNeighbours = 8;
        Cell[] possibleNeighbours = new Cell[countOfPossibleNeighbours];
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i >= 0 && x + i != skin.getSize() && y + j >= 0 && y + j != skin.getSize()) {
                    Cell cellToCheck = skin.getCell(x + i, y + j);
                    if (cellToCheck.state == CellState.HEALTHY) {
                        possibleNeighbours[count] = cellToCheck;
                        count++;
                    }
                }
            }
        }
        Cell[] neighbours = new Cell[count];
        for (int i = 0; i < count; i++) {
            neighbours[i] = possibleNeighbours[i];
        }
        return neighbours;
    }

    private void infect() {
        Cell[] neighbours = findHealthyNeighbours();
        for (int i = 0; i < neighbours.length; i++) {
            Random rnd = new Random();
            boolean success = rnd.nextBoolean();
            if (success) {
                int x = neighbours[i].x;
                int y = neighbours[i].y;
                skin.setCell(x, y, CellState.INFECTED);
                break;
            }
        }
    }
}
