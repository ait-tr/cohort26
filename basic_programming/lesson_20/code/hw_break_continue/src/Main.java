import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Homework - break, continue");

//        Задача 1
//        Вводится натуральное число n с клавиатуры. Подсчитать сумму всех
//        натуральных чисел меньших n, за исключением чисел, кратных числу 3.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input positive integer number: ");
        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i < n; i++) {
            if (i % 3 == 0) {
                continue;
            }
            sum = sum + i;
            System.out.println("Index: " + i + " Sum: " + sum); // промежуточная печать
        }
        System.out.println("Sum is of numbers less then " + n + " w/out multiply of 3 is: " + sum);
        System.out.println();

//        Хозяйка налепила для гостей 30 пельменей. В один из пельменей она положила монету,
//        которая увеличивает вес пельменя на 15 грамм.
//        Напишите программу, которая ищет счастливый пельмень.

        int[] dumplings = new int[30];

        for (int i = 0; i < dumplings.length; i++) {
            dumplings[i] = (int)(Math.random() * (23 - 18 + 1) + 18); // задумываем веса пельменей в диапазоне 18-23 грамма
        }
        System.out.println(Arrays.toString(dumplings)); // напечатали для контроля веса пельменей
        int luckyDumplingIndex = (int)(Math.random() * (29 - 0 + 1) + 0);// задумываем индекс счастливого пельменя
        dumplings[luckyDumplingIndex] = dumplings[luckyDumplingIndex] + 15; // вкладываем в счастливый пельмень монету 15 грамм
        System.out.println(Arrays.toString(dumplings)); // напечатали для контроля веса пельменей после закладки монеты
        int index = 0; // переменная для индекса счастливого пельменя
        // перебираем все пельмени, ищем "тяжелый", обрываем цикл как только он найден
        for (int i = 0; i < dumplings.length; i++) {
            if (dumplings[i] == dumplings[luckyDumplingIndex]) {
                index = i;
                break;
            }
        }
        System.out.println();
        System.out.println("Index of Lucky Dumpling is: " + index);

    }
}

