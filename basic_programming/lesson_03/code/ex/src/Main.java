import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!"); // это для вывода на консоль (на печать)

//        Reader inputStreamReader = new InputStreamReader(System.in); // готовим ввод с клавиатуры
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // готовим ввод с клавиатуры

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите первое число: "); // Это приглашение к вводу
        String num1 = br.readLine(); //читаем строку с клавиатуры
        System.out.println("Вы ввели " + num1 + " - это первое число"); // Это соосбщение пользователю
        int n1 = Integer.parseInt(num1); //преобразовываем строку в число.

        System.out.println("Введите второе число: "); // Это приглашение к вводу
        String num2 = br.readLine(); //читаем строку с клавиатуры
        System.out.println("Вы ввели " + num2 + " - это второе число"); // Это соосбщение пользователю
        int n2 = Integer.parseInt(num2); //преобразовываем строку в число.

        System.out.println("1-е число " + n1 + " умножить на второе число " + n2 + " = " + (n1 * n2) );
        System.out.println(" Спасибо! ");
    }
}
// Более компактная запись:
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String name1 = br.readLine(); // читаем строку
//        String sAge1 = br.readLine(); // читаем строку
//        int nAge1 = Integer.parseInt(sAge); // преобразовываем строку в целое число




/*
        int x = 100;
        int y = 300;

        int z = x + y;
        System.out.println("Сумма двух чисел: " + z);

        String st = "100"; // это последовательность символов
        int a = 1; // это число

        System.out.println("Объединение " + st + a); // то контактенация (объединение) значений двух переменных
*/
