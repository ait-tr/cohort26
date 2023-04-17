import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        Написать программу, которая:
//        - прочитает с клавиатуры количество вводимых чисел,
//        - прочитает с клавиатуры сами числа и соберёт их в множество,
//        - удалит из множества числа, большие 10 (здесь надо подумать!)
//        выведет полученные результаты на экран
//        Все числа, которые подаются на вход, целые.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number");
        int numElements = scanner.nextInt(); // количество элементов
        int num = 0; // числа - элементы множества
        HashSet<Integer> numbers = new HashSet<>();

        for (int i = 0; i < numElements; i++) {
            num = scanner.nextInt();
            numbers.add(num);
        }


    }
}