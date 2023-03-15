import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner sc = new Scanner(System.in);
        // Считывание большого числа
        System.out.println("Введите целое число ");
        int num = sc.nextInt();
        System.out.println("Введено число: " + num);
    }
}