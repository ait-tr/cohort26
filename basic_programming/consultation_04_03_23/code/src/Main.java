import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Задача - перевести вводимую строку из цифр в целое число
        System.out.println("Перевод строки, состоящей из цифр, в целое число");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string contains digits only");
        String stDigits = scanner.next();
        System.out.println("Your input "+stDigits);

        int l = stDigits.length();
        char ch1 = stDigits.charAt(0);
        System.out.println("1st inputed digit "+ch1);

        char chL = stDigits.charAt(l - 1);
        System.out.println("Last inputed digit "+chL);

        int resulut = (int) (Double.parseDouble(stDigits));

        System.out.println("The number is "+resulut);
        int d = resulut * 100;
        System.out.println("* 100  is "+d);
    }

}