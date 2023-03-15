import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        // Считывание большого числа
        System.out.println("Введите целое число ");
        int num1 = sc.nextInt();
        System.out.println("Введите целое число ");
        int num2 = sc.nextInt();
        System.out.println("Число " + num1 + " разделить на  число " + num2 + " получается частное " + num1/num2 + " и в остатке " + num1%num2);
    }
}