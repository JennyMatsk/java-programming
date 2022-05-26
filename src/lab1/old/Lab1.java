package lab1.old;

// Парными простыми числами называются два простых числа, разность которых равна двум, например: 3 5; 5 7
// Напишите программу нахождения первых N таких пар. N задается в программе.
public class Lab1 {
    public static void main(String args[]) {
        int N = 5;
        // Количество простых чисел, записанных в массив
        int count_of_primes = 1;
        // Количество выведенных на экран пар
        int pairs_counter = 0;
        int[] prime_nums = new int[1000000];
        prime_nums[0] = 2;


        // Проходим по ряду натуральных чисел, заполняя массив простых чисел
        for (int i = 2; pairs_counter < N; i++) {
            // flag = true, если число простое
            // flag = false, если составное
            boolean flag = true;
            // Проверка является ли число составным
            for (int j = 0; j < count_of_primes; j++) {
                if (i % prime_nums[j] == 0) {
                    flag = false;
                    break;
                }
            }
            // Проверка числа на простоту
            if (flag && count_of_primes < prime_nums.length - 1) {
                prime_nums[count_of_primes] = i;
                // Проверка разницы между новым и предыдущим простым числом
                // При необходимости выводим новую пару
                if (i - prime_nums[count_of_primes - 1] == 2) {
                    System.out.println("[" + prime_nums[count_of_primes - 1] + ", " + i + "]");
                    pairs_counter++;
                }
                count_of_primes++;
            }
        }
    }
}