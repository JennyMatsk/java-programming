package lab2;

import java.util.Random;

//Дан целочисленный двумерный массив размера M×N, заполненный построчно случайными значениями в диапазоне от –99 до 99.
// Этот массив вывести на экран.
// Заменить исходный массив новым, в котором удалены все столбцы, содержащие только положительные элементы.
// Получившийся массив вывести на экран. Если требуемых столбцов нет, то вывести массив без изменений.
// Считать, что в массиве всегда есть хотя бы один отрицательный элемент. M и N задаются в main()
public class Lab2 {

    // Получение произвольного числа в заданных границах (start, end)
    public static int getRandomNumberInRange(int start, int end) {
        // Диапазон генеруемых случайных чисел
        int diff = end - start;
        Random random = new Random();
        int randomNum = random.nextInt(diff + 1);
        // Вписываем получившееся число в заданные рамки
        randomNum = randomNum + start;
        return randomNum;
    }

    // Создание произвольного двумерного массива по заданным параметрам длины и ширины (N, M)
    public static int[][] create2DRandomArray(int N, int M) {
        int[][] randomArray = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                randomArray[i][j] = getRandomNumberInRange(-99, 99);
            }
        }
        return randomArray;
    }

    // Отмечаем какие столбцы полученного на входе массива положительны
    public static boolean[] findPositiveColumns(int[][] array2D) {
        boolean[] isColPositive = new boolean[array2D[0].length];

        for (int i = 0; i < array2D[0].length; i++) {
            for (int j = 0; j < array2D.length; j++) {
                isColPositive[i] = true;
                if (array2D[j][i] <= 0) {
                    isColPositive[i] = false;
                    break;
                }
            }
        }
        return isColPositive;
    }

    // Получение количества столбцов с только положительными числами
    public static int getPositiveColumnsCount(boolean[] isColPositive) {
        int countOfPosColumns = 0;

        for (int i = 0; i < isColPositive.length; i++) {
            if (isColPositive[i] == true) {
                countOfPosColumns++;
            }
        }
        return countOfPosColumns;
    }

    // Создание нового массива на основе полученного на входе, но без столбцов с только положительными элементами
    public static int[][] deletePositiveColumns(int[][] array2D) {
        boolean[] isColPositive = findPositiveColumns(array2D);
        int positiveColumnsCount = getPositiveColumnsCount(isColPositive);
        int newWidth = array2D[0].length - positiveColumnsCount;
        int[][] array2DWithoutPosCol = new int[array2D.length][newWidth];

        for (int i = 0; i < array2D.length; i++) {
            int skipColumns = 0;
            for (int j = 0; j < array2D[i].length; j++) {
                if (isColPositive[j]) {
                    skipColumns++;
                } else {
                    array2DWithoutPosCol[i][j - skipColumns] = array2D[i][j];
                }
            }
        }
        return array2DWithoutPosCol;
    }

    // Вывод двумерного массива, полученного на входе в метод
    public static void print2DArray(int[][] array2D) {
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.print('\n');
        }
    }


    public static void main(String[] args) {
        int N = 3;
        int M = 5;
        int[][] randomArray = create2DRandomArray(N, M);
        print2DArray(randomArray);
        System.out.println();
        print2DArray(deletePositiveColumns(randomArray));
    }
}
