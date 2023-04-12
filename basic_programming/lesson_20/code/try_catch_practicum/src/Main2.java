import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Example with division");

        String choice = "";
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("Input a: ");
                int a = scanner.nextInt();
                System.out.println("Input b: ");
                int b = scanner.nextInt();
                int c = division(a, b);
                System.out.println("a divided b = " + c);
            } catch (ArithmeticException error) {
                System.out.println("Error: " + error.getMessage());
            } catch (InputMismatchException error) {
                System.out.println("Вы ввели буквы вместо числа " + error.getMessage());
            }
            System.out.println("Continue? y/n ");
            choice = scanner.next();
            if (choice.equals("n")) {
                System.out.println("Thanks! Buy-buy...");
                break;
            }
        }

    }
    public static int division(int x, int y) {
        return x / y;
    }
}