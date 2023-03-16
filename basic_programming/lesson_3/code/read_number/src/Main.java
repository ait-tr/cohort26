import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Конвертор евро в доллары");
        Scanner sc = new Scanner(System.in);
        // Считывание числа
        System.out.println("Введите количество долларов ");
        double dollars = sc.nextDouble(); // переменная dollars типа double
        System.out.println("Это составляет: " + dollars / 1.06  + " евро.");

    }
}