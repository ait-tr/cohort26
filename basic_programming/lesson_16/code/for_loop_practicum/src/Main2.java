import java.util.Scanner;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Array turnover");
//        Запросить длину массива целых чисел у пользователя, занести данные в массив,
//        сделать "разворот" массива (последний элемент должен стать первым и т.д.).

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size of array: ");
        int size = scanner.nextInt();

        int[] myArray = new int[size]; // определили массив

        // вводим с клавиатуры элементы массива в цикле
        for (int i = 0; i < myArray.length; i++) {
            System.out.println("Input " + i + " element of array: ");
            myArray[i] = scanner.nextInt();
        }

        // распечатали массив в строчку с разделителем |
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " | ");
        }

        System.out.println(); // переход на новую строчку

        // Алгоритм разворота массива
        // берем первый элемент массива и откладываем его в переменную temp
        // берем последний элемент массива и переносим его в первый
        // в последний элемент массива положить temp
        // двигаемся слева направо к середине массива
        for (int i = 0; i < myArray.length / 2; i++) {
            int temp = myArray[i];
            myArray[i] = myArray[myArray.length - 1 - i]; // первый элемент массива = последнему
            myArray[myArray.length - 1 - i] = temp;
        }
        // распечатали массив в строчку с разделителем |
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " | ");
        }
        System.out.println();
        System.out.println(Arrays.toString(myArray)); // печать массива методом класса Arrays

    }
}