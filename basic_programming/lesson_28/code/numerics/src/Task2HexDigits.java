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
      String digitStr = "";
      switch (digit) {
        case 10:
          digitStr = "A";
          break;
        case 11:
          digitStr = "B";
          break;
        case 12:
          digitStr = "C";
          break;
        case 13:
          digitStr = "D";
          break;
        case 14:
          digitStr = "E";
          break;
        case 15:
          digitStr = "F";
          break;
        default:
          digitStr = Integer.toString(digit);
          break;
      }
      System.out.println(
          "Разряд: " + order + ", цифра: " + digitStr); // выводим эту последнюю цифру
      // убираем последнюю цифру, находим целую часть от деления на основание
      number /= RADIX; // number = number / RADIX; // +=, -=, *=, /=
      ++order;
    }
  }
}
