import java.util.Arrays;
import java.util.Scanner;

public class Main_Task2 {
    public static void main(String[] args) {
        System.out.println("Array practicum, task 1");
//        Запросить длину массива целых чисел у пользователя, занести данные в массив,
//        сделать "разворот" массива (последний элемент должен стать первым и т.д.).


        Scanner scanner = new Scanner(System.in);
        // считали с консоли размер массива
        System.out.println("Input aray size: ");
        int size = scanner.nextInt();
        // размер массива определяется в момент выполнения программы
        int[] myArray = new int[size];

        // читаем элементы массива, их вводит пользователь
        for (int i = 0; i < myArray.length; i++) {
            System.out.println("Input " + i + " element of array: ");
            myArray[i] = scanner.nextInt();
        }

        // печать введеного массива
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " | ");
        }

        System.out.println(); // new line

        // перестановка массива в обратном порядке
        // алгоритм: берем i-й элемент массива и заносим его в temp,
        // переносим в i-й элемент массива в конец массива
        // в конец массива ставим temp
        // проходим слева направо до середины массива
        for (int i = 0; i < myArray.length / 2; i++) {
            int temp = myArray[i];
            myArray[i] = myArray[myArray.length - 1 - i];
            myArray[myArray.length - 1 - i] = temp;
        }
        // печать массива методом от класса Arrays
        System.out.println(Arrays.toString(myArray));

    }
}