package lab1.remake;

// Парными простыми числами называются два простых числа, разность которых равна двум, например: 3 5; 5 7
// Напишите программу нахождения первых N таких пар. N задается в программе.
public class Lab1 {
    public static void main(String args[]) {
        int twinPrimeCounter = 0;
        int totalPrimesNeeded = 10;
        int currentNumberToCheck;
        int lesserTwin = 3;
        int greaterTwin = 5;
        boolean isPrime = false;
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