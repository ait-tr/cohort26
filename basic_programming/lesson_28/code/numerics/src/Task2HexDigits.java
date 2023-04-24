import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2HexDigits {

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

  }
}
