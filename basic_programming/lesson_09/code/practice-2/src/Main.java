import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика на оператор if () ... else ");
    // Проверка на чет/нечет
       Scanner sc = new Scanner(System.in);
       System.out.println("Введите целое число: ");
       int num = sc.nextInt();
       if (num%2 == 0) {
           // если истина
           System.out.println(num + " Вы ввели ЧЕТНОЕ число ");
       } else {
           // если ложь
           System.out.println(num + " Вы ввели НЕЧЕТНОЕ число ");
       }
    // Проверка на делимость на 5
        System.out.println("Введите целое число: ");
        int num1 = sc.nextInt();
        if (num1 % 5 == 0) {
            // если истина
            System.out.println("Вы ввели число " + num1 + " оно делится на 5");
        } else {
            // если ложь
            System.out.println("Вы ввели число " + num1 + " оно не делится на 5");
        }
    }
}