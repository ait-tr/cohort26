import java.io.BufferedReader;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Практикум по символам");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите какой-нибудь символ с клавиатуры: ");
        int code = br.read();
        System.out.println(code);

        // Метод read() возвращает int, а не char. Для работы с кодом как с символом потребуется явное преобразование:
        char character = (char) code;
        System.out.println(character);
        System.out.println("Вы ввели символ " + character + ", его код " + code);
        System.out.println(); // отступ, пустая строка

//        Задать значение переменной типа char можно следующим способом:
        char a = 'A'; // Переменная а будет содержать латинскую букву А.

//        char a = 65;
//        Переменная а будет содержать латинскую букву А. Ее код как раз 65.
//        char a = 0x41;
//        Переменная а будет содержать латинскую букву А.
//        Ее код как раз 65, что равно 41 в шестнадцатеричной системе.
//        char a = 0x0041; // Два лишних нуля ничего не меняют.
//        char a ='\u0041'; // Указание на код Unicode, можно внутри строки

        System.out.println(a);

// Обратите внимание:, один символ — объект типа char — записывается в одинарных кавычках ('),
// а несколько символов — строка — в двойных (").

    }
}