import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Rectangle perimeter:");
//        Расчет периметра прямоугольника, защита от ввода символов вместо числа
//        и ввода отрицательных чисел.
//        Запросить у пользователя длину и ширину прямоугольника.

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input length: ");
            try {
                int a = scanner.nextInt();
                while (a <= 0) {
                    System.out.println("Incorrect input, try again.");
                    a = scanner.nextInt();
                }
                System.out.println("Input width: ");
                int b = scanner.nextInt();
                while (b <= 0) {
                    System.out.println("Incorrect input, try again.");
                    b = scanner.nextInt();
                }
                int p = perimeter(a, b);

                System.out.println("Perimeter is: " + p);
            } catch (InputMismatchException error) {
                System.out.println("Incorrect input " + error.getMessage());
            }
            System.out.println("Continue? y/n ");
            String choice = scanner.next();
            if (choice.equals("n")) {
                System.out.println("Thanks! Bye-bye...");
                break;
            }

        } // end of while loop

    }
    public static int perimeter(int x, int y) {
        return 2 * ( x + y);
    }

}