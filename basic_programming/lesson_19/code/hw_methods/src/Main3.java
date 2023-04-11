import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Arithmetic operations - +, -, * , /");
        Scanner scanner = new Scanner(System.in);

        while (true) { // бесконечный цикл
            int a = inputNumber();
            int b = inputNumber();

            System.out.println("Choice operation: 1 - sum, 2 - subtraction, 3 - multiplication, 4 - division");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1: {
                    int res = sum(a, b); // вызов метода
                    System.out.println("Sum is: " + res);
                    break;
                }
                case 2: {
                    int res = subtraction(a, b);
                    System.out.println("Subtraction is: " + res);
                    break;
                }
                case 3: {
                    int res = multiplication(a, b);
                    System.out.println("Multiplication is: " + res);
                    break;
                }
                case 4: {
                    int res = division(a, b);
                    System.out.println("Division is: " + res + "(division integer numbers)");
                    break;
                }
                default : {
                    System.out.println("Wrong input.");
                }
            }
            System.out.println("Continue? y/n ");
            String choice = scanner.next();
            if (choice.equals("n")) {
                System.out.println("Thanks, pal! See you...");
                break; // выход из бесконечного цикла
            }
        }// закрытие цикла

    }
    // ___________ methods ________________

    // метод считывает имя (строку) и защищен от ввода строки в виде чисел с помощью регулярного выражения
    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        String inputName = "";
        System.out.println("Input name: ");
        inputName = scanner.nextLine();
        while (!inputName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid name, pls, try again.");
            inputName = scanner.nextLine();
        }
        return inputName;
    }

    // метод считывает целое число (строку) и защищен от ввода строки из букв с помощью регулярного выражения
    public static int inputNumber () {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = "";
        int number = 0;
        System.out.println("Input number: ");
        inputNumber = scanner.nextLine();
        while (!inputNumber.matches("[0-9]+")) {
            System.out.println("Invalid number, pls, try again.");
            inputNumber = scanner.nextLine();
        }
        return Integer.parseInt(inputNumber);
    }

    // метод складывает a и b
    public static int sum(int a, int b) {
        return a + b;
    }

    // метод возвращает разницу a и b
    public static int subtraction(int a, int b) {
        return a - b;
    }

    // метод возвращает произведение a и b

    public static int multiplication (int a, int b) {
        return a * b;
    }

    // метод возвращает частное a и b
    public static int division(int a, int b) {
        return a / b;
    }

    // ___________ end of methods ________________
}