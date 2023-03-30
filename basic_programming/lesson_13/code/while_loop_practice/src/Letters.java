import java.util.Scanner;

public class Letters {
    public static void main(String[] args) {
        System.out.println("Цифры числа");
        // Вводится слово с клавиатуры. Напечатаь, каждую букву слова с новой строки.
        // На входе - строка (слово)
        // На выходе - на каждой строчке одна буква этого слова
        // Ключевой алгоритм - опеделим длину строки и используем substring в цикле
        // длину слова будем уменьшать на каждом шаге на 1

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string: ");
        String st;
        st = scanner.next();
        int l = st.length();
        int i = 0;
        System.out.println("Length of string: " + l);

        while ( l > 0 ) {
            System.out.println(st.charAt(i));
            i++;
            l--;
        }

    }
}