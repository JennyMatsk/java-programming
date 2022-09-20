package lab4;

public class Skin {
    public int size = 21;
    private HealthyCell[][] skin = new HealthyCell[size][size];
    private HealthyCell[][] updSkin = new HealthyCell[size][size];

    // Начальная генерация игрового поля, заполнение массива кожи инфицированной и здоровыми клетками,
    // И по прошествию единицы времени проведение обновления
    // Количество итераций = количество тиков, заданных программно в Main
    public void start(int n) {
        initSkin();
        printSkin();
        int counter = 0;
        while (counter < n) {
            update();
            counter++;
        }
        System.out.println(counter);
    }


    private void update() {
        for (int i = 0; i < skin.length; i++) {
            for (int j = 0; j < skin[i].length; j++) {
                if (skin[i][j].getCellSymbol() == updSkin[i][j].getCellSymbol()) {
                    skin[i][j].update();
                }
            }
        }
        copySkin();
        printSkin();
    }


    // Необходим для копирования текущего состояния в выводимое,
    // Дабы избежать некорректного обновления инфицированных клеток
    private void copySkin() {
        for (int i = 0; i < updSkin.length; i++) {
            System.arraycopy(updSkin[i], 0, skin[i], 0, size);
        }
    }

    // Необходим для корректной работы проверки на одинаковые клетки
    // После инициализации кожи
    private void copyUpdSkin() {
        for (int i = 0; i < skin.length; i++) {
            System.arraycopy(skin[i], 0, updSkin[i], 0, size);
        }
    }

    // Заполнение массива здоровыми и зараженной клетками
    private void initSkin() {
        for (int i = 0; i < skin.length; i++) {
            for (int j = 0; j < skin[i].length; j++) {
                if (i == size / 2 && j == size / 2) {
                    skin[i][j] = new InfectedCell(i, j, this);
                } else {
                    skin[i][j] = new HealthyCell(i, j, this);
                }
            }
        }
        copyUpdSkin();
    }

    // Вывод текущего состояния кожи на экран
    private void printSkin() {
        for (int i = 0; i < skin.length; i++) {
            for (int j = 0; j < skin[i].length; j++) {
                System.out.print(skin[i][j].getCellSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println("=========================================");
    }

    // Переопределение типа выбранной клетки
    public void setCell(HealthyCell cell) {
        int x = cell.x;
        int y = cell.y;
        updSkin[x][y] = cell;
    }

    public HealthyCell getCell(int x, int y) {
        return skin[x][y];
    }

    public int getSize() {
        return size;
    }
}
