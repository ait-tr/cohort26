public class Main1 {
public static void main(String[] args) {
        System.out.println("Arrays practicum - continue");

//    Даны оценки двух учеников за четверть:
//    Ученик1: 5, 3, 3, 4, 5, 4, 5, 5
//    Ученик2: 3, 4, 5, 5, 2, 5, 4
//    Найдите средний балл для каждого ученика и выясните, кто из них лучше учится.
// Алгоритм:
// Шаг 1 - задать массив оценок 1-го ученика,  marks1 = {5, 3, 3, 4, ... };
// Шаг 2 - задать массив оценок 2-го ученика,  marks2 = {3, 4, 5, 5, ... };
// Для каждого ученика надо вычислить сумму его оценок
// и разделить ее на количество оценок (это длина массива)
// нужна переменная average1, average2
// Сравниваем две переменные, делаем вывод

        int[] marks1 = new int[8];
        marks1 = new int[]{5, 5, 5, 4, 5, 4, 5, 5}; // задаем массив

        int[] marks2 = new int[7];
        marks2 = new int[]{3, 4, 5, 5, 2, 5, 4}; // задаем массив

        // цикл for для суммы оценок 1-го ученика
        int sum1 = 0;
        for (int i = 0; i < marks1.length; i++) { // marks1.length - это автоматическое определенеие длины массива
                sum1 = sum1 + marks1[i];
        }

        // цикл while для суммы оценок 2-го ученика
        int sum2 = 0;
        int j = 0;
        while (j < marks2.length) { // marks2.length - это автоматическое определенеие длины массива
                sum2 = sum2 + marks2[j];
                j++;
        }

        double average1 = (double) (sum1) / (double)(marks1.length); // (double) - это приведение типа от int к double
        double average2 = (double)(sum2) / (double) (marks2.length); //

        System.out.println(average1);
        System.out.println(average2);

        if (average1 > average2) {
                System.out.println( "1-й ученик учится лучше, его средний бал: " + average1 );
        } else {
                System.out.println( "2-й ученик учится лучше, его средний бал: " + average2 );
        }

        }
}