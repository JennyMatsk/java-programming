package lab1.remake;

// Парными простыми числами называются два простых числа, разность которых равна двум, например: 3 5; 5 7
// Напишите программу нахождения первых N таких пар. N задается в программе.

public class Lab1 {
    public static void main(String args[]) {
        // Счётчик найденных парных простых чисел
        int twinPrimeCounter = 0;
        // Количество парных чисел, которые необходимо найти
        int totalPrimesNeeded = 10;
        // Промежуточноле число для проверки простоты
        int currentNumberToCheck;
        // Меньшее парное простое число
        int lesserTwin = 3;
        // Большее простое число
        int greaterTwin = 5;
        // Индикатор является ли число простым
        boolean isPrime = false;
        // Основной цикл будет работать пока не найдём необходимое количество пар
        // Вложенный цикл будет работать дважды, проверяя на простоту сначала меньшее, а потом большее число из пары
        // Если нашли два простых числа (разница между числами всегда равна двум), то выводим результат
        while (twinPrimeCounter < totalPrimesNeeded) {
            currentNumberToCheck = lesserTwin;
            for (int j = 0; j < 2; j++) {
                for (int i = 2; i < currentNumberToCheck; i++) {
                    if (currentNumberToCheck % i == 0) {
                        isPrime = false;
                        break;
                    }
                    isPrime = true;
                }
                currentNumberToCheck = greaterTwin;
            }
            if (isPrime) {
                System.out.print(" (" + lesserTwin + ", " + greaterTwin + ")");
                twinPrimeCounter++;
            }
            lesserTwin++;
            greaterTwin++;
        }
    }
}