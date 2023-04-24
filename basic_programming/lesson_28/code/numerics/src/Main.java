import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  // константы - числа, которые используются в коде в разных местах
  // необходимо дать им осмысленное имя
  // пишем в классе, ПЕРЕД методами:
  // private static final тип ИМЯ_КОНСТАНТЫ = значение;
  private static final int RADIX = 10; // Основание системы счисления

  // Задача:
  // Прочитать с клавиатуры число и вывести его цифры в столбик, по одной в каждой строке
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите число: ");
    try {
      int number = Integer.parseInt(bufferedReader.readLine());
      printDigits(number);
    } catch (NumberFormatException e) {
      System.out.println("Неправильный формат целого числа: " + e.getMessage());
    }
  }

  private static void printDigits(int number) {
    System.out.println("Цифры числа " + number + ":");
    number = Math.abs(number); // для целей деления и перебора чисел убрали знак
    int order = 0;
    while (number > 0) { // пока в числе есть цифры
      int digit = number % RADIX; // последняя цифра - остаток от деления на основание (10)
      System.out.println("Разряд: " + order + ", цифра: " + digit); // выводим эту последнюю цифру
      // убираем последнюю цифру, находим целую часть от деления на основание
      number /= RADIX; // number = number / RADIX; // +=, -=, *=, /=
      ++order;
    }
  }
}
