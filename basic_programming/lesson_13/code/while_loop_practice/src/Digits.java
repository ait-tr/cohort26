import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        System.out.println("Цифры числа");
        // Вводится натуральное число. Напечатать, из каких цифр оно состоит.
        // Пример:
        // 5329 - это число
        // 5
        // 3
        // 2
        // 9
        // - это цифры, из которого состоит число

        // Что на входе: целое положительное число, запрашиваем у пользователя (тип int), использую Scanner
        // Что на выходе: на каждой строчке - одна цифра числа
        // Ключевой алгоритм:
        // 5329 - (5329/10 = 532 и 9 в остатке) - это правая цифра, отвечает за единицы
        // 5329 % 10 = 9 (это остаток от деления на 10 с остатком)
        // далее делое тоже самое 532, потом 53 и наконец 5 эти можно получать делением на 10
        // 5 / 10 = 0 - это условие выхода из цикла (его окончание)

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input positive integer number: ");
        int num = scanner.nextInt();
        System.out.println("Your input is: " + num);

        int digit = 0;
        int i = 1;

        while ( num > 0 ) {
           digit = num % 10; // деление на 10 с остатоком дает нам цифру числа
            System.out.println(i +  " digit is " + digit); // печатаем цифру
            num = num - digit; // уменьшили число на его единицы
            num = num/10; // убрали последний 0 в числе
            i++;
        }
        System.out.println("Digits in number: " + i);
    }
}
