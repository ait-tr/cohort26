import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите любое слово");
        String letter = sc.next();
        char firstLetter = letter.charAt(0);
        System.out.println("Первая буква это - " + firstLetter);

        // Считывание y/n в любом регистре
        System.out.println("Продолжим? y/n ");
        char choice = sc.next().toLowerCase().charAt(0);
        System.out.println("Выбор пользователя: " + choice);

    }
}