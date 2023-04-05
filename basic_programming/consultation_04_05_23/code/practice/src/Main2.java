import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Алгоритм");
        //Имеется строка "Java is the best language!"
        //Вводится буква пользователем с консоли
        // Программа должна отреагировать:
        // есть и на каком месте
        // или нет - такой буквы нет

        // Алгоритм:
        // шаг 1 - задать переменную типа String , придумать ей имя(!), поместить в нее стороку
        // шаг 2 - определить длину строки
        // шаг 3 - запросить букву у пользователя
        // шаг 4 - запустить цикл, который будет пробегать по всей строке и
        // если символ в строке совпал с введенной буквой, то пишем, что есть и сообщаем индекс
        // если нет, то напишем, что такой буквы нет.

        String sentence = "Java is the best language!";

        int length = sentence.length();

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the letter? ");

        String letter = scanner.next();

        boolean letterIsFind = false;


        for (int i = 0; i < length; i++) {
            String ch = String.valueOf(sentence.charAt(i));
            if (letter.equals(ch)) {
                System.out.println("We find it! Index is: " + i);
                letterIsFind = true;
            }

        }

        if (!letterIsFind) {
            System.out.println("We didn't find it, sorry...");
        }
    }
}