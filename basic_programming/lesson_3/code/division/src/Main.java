import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Целочисленное деление");
        Scanner sc = new Scanner(System.in);
        // Считывание числа
        System.out.println("Введите целое число - делимое ");
        int num1 = sc.nextInt();
        System.out.println("Введите второе целое - делитель ");
        int num2 = sc.nextInt();
        System.out.println("Частное" + num1/num2 + ", остаток " + num1%num2);
        //   / - это частное целых чисел - это целое число, целая часть от деления
        //   % - это деление с остатком, получается только остаток
    }
}