import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Arithmetic operations");
        Scanner scanner = new Scanner(System.in);


    }
    // ___________ methods ________________

    // метод считывает имя (строку) и защищен от ввода строки в виде чисел с помощью регулярного выражения
    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        String inputName = "";
        System.out.println("Input name: ");
        inputName = scanner.next();
        while (!inputName.matches("[a-zA-Z]+")) {
            System.out.println("Invalid name, pls, try again.");
            inputName = scanner.next();
        }
        return inputName;
    }

    // метод считывает целое число (строку) и защищен от ввода строки из букв с помощью регулярного выражения
    public static int inputNumber () {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = "";
        int number = 0;
        System.out.println("Input number: ");
        inputNumber = scanner.next();
        while (!inputNumber.matches("[0-9]+")) {
            System.out.println("Invalid number, pls, try again.");
            inputNumber = scanner.next();
        }
        return Integer.parseInt(inputNumber);
    }

    // метод складывает a и b


    // метод возвращает разницу a и b


    // метод возвращает произведение a и b


    // метод возвращает частное a и b


    // ___________ end of methods ________________
}