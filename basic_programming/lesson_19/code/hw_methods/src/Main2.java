import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Input string and numbers ONLY");

        Scanner scanner = new Scanner(System.in);

        // ввод имени
        String name = inputName();
        System.out.println("Hello, " + name + "!");

        // ввод числа
        int num = inputNumber();
        System.out.println("Number is: " + num);

    }
    // ___________ methods ________________

    // метод считывает имя (строку) и защищен от ввода строки в виде чисел с помощью регулярного выражения
    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        String inputName = ""; // это так инициализируется пустая строка
        System.out.println("Input name: ");
        inputName = scanner.nextLine();
        while (!inputName.matches("[ a-zA-Z]+")) {
            System.out.println("Invalid name, pls, try again.");
            inputName = scanner.nextLine();
        }
        return inputName;
    }

    // метод считывает целое число (строку) и защищен от ввода строки из букв с помощью регулярного выражения

    public static int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        String inputNumber = "";
  //      int number = 0;
        System.out.println("Input number: ");
        inputNumber = scanner.nextLine(); // считываем строку
        while (!inputNumber.matches("[0-9]+")) {
            System.out.println("Invalid number, pls, try again.");
            inputNumber = scanner.nextLine(); // считываем строку
        }
        return Integer.parseInt(inputNumber); // преобразование в тип int
    }



    // ___________ end of methods ________________
}