import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2HexDigits {

  private static final int RADIX = 16; // Основание системы счисления

  // hexadecimal - шестнадцатеричные
  // Задача:
  // Прочитать с клавиатуры десятичное число и вывести цифры его шестнадцатеричной записи
  // в столбик, по одной в каждой строке
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите число: ");
    try {
      int number = Integer.parseInt(bufferedReader.readLine());
      printHexDigits(number);
    } catch (NumberFormatException e) {
      System.out.println("Неправильный формат целого числа: " + e.getMessage());
    }
  }

  private static void printHexDigits(int number) {
    System.out.println("Цифры числа " + number + ":");
    number = Math.abs(number); // для целей деления и перебора чисел убрали знак
    int order = 0;
    while (number > 0) { // пока в числе есть цифры
      int digit = number % RADIX; // последняя цифра - остаток от деления на основание (10)
      String digitStr = switch (digit) {
        case 10 -> "A";
        case 11 -> "B";
        case 12 -> "C";
        case 13 -> "D";
        case 14 -> "E";
        case 15 -> "F";
        default -> Integer.toString(digit);
      };
      System.out.println(
          "Разряд: " + order + ", цифра: " + digitStr); // выводим эту последнюю цифру
      // убираем последнюю цифру, находим целую часть от деления на основание
      number /= RADIX; // number = number / RADIX; // +=, -=, *=, /=
      ++order;
    }
  }
}
