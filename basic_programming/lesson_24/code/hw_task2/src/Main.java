import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Remove negative numbers from the set");
//        Написать программу, которая:
//        - прочитает с клавиатуры количество вводимых чисел,
//        - прочитает с клавиатуры сами числа и соберёт их в множество,
//        - удалит из множества числа, большие 10 (здесь надо подумать!)
//        выведет полученные результаты на экран
//        Все числа, которые подаются на вход, целые.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size of set"); // приглашение пользователю
        int numElements = scanner.nextInt(); // количество вводимых чисел - элементов множества

        HashSet<Integer> numbers = new HashSet<>(); // инициируем множество

        // считываем и добавляем элементы множества
        for (int i = 0; i < numElements; i++) {
            System.out.println("Input integer number: ");
            numbers.add(scanner.nextInt());
        }
        // печатаем множество
        System.out.println(numbers);

        // здесь будут числа, которые мы хотим удалить
        HashSet<Integer> numbersToRemove = new HashSet<>();
        // используем цикл for each
        for (int n : numbers) {
            if (n > 10) {
                numbersToRemove.add(n);
            }
        }

        // печатаем множество чисел для удаления
        System.out.println(numbersToRemove);

        // удаляем из множества numbers все те числа, которые есть во множестве numbersToRemove
        for (int n : numbersToRemove) {
            numbers.remove(n); // удаляем элемпенты множества numbers
        }

        // печатаем обновленое множество numbers
        System.out.println(numbers);

    }
}