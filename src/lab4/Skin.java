package lab4;

public class Skin {
    public static int size = 21;
    private Cell[][] skin = new Cell[size][size];

    public void start() {
        initSkin();
        printSkin();
        int counter = 0;
        while (!isHealthy()) {
            update();
            counter++;
        }
        System.out.println(counter);
    }

    private void update() {
        for (int i = 0; i < skin.length; i++) {
            for (int j = 0; j < skin[i].length; j++) {
                skin[i][j].update();
            }
        }
        printSkin();
    }

    private void initSkin() {
        for (int i = 0; i < skin.length; i++) {
            for (int j = 0; j < skin[i].length; j++) {
                if (i == size / 2 && j == size / 2) {
                    skin[i][j] = new InfectedCell(i, j, this);
                } else {
                    skin[i][j] = new HealthyCell(i, j);
                }
            }
        }
    }

    public void printSkin() {
        for (int i = 0; i < skin.length; i++) {
            for (int j = 0; j < skin[i].length; j++) {
                System.out.print(getCellSymbol(skin[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println("=========================================");
    }

    public void setCell(int x, int y, CellState cellState) {
        if (cellState == CellState.HEALTHY) {
            skin[x][y] = new HealthyCell(x, y);
        } else if (cellState == CellState.IMMUNE) {
            skin[x][y] = new ImmuneCell(x, y, this);
        } else if (cellState == CellState.INFECTED) {
            skin[x][y] = new InfectedCell(x, y, this);
        }
    }

    public Cell getCell(int x, int y) {
        return skin[x][y];
    }

    public int getSize() {
        return size;
    }

    private boolean isHealthy() {
        boolean isHealthy = true;
        for (int i = 0; i < skin.length; i++) {
            for (int j = 0; j < skin[i].length; j++) {
                if (skin[i][j].state != CellState.HEALTHY) {
                    isHealthy = false;
                    break;
                }
            }
        }
        return isHealthy;
    }

    protected String getCellSymbol(Cell cell) {
        switch (cell.state) {
            case HEALTHY:
                return "+";
            case IMMUNE:
                return "=";
            case INFECTED:
                return "-";
            default:
                return "E";
        }
    }
}
