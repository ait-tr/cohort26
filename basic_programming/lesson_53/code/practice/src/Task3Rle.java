import java.util.Scanner;

public class Task3Rle {

  // Run-length encoding (RLE) (aaabbcddddaaaaa = a3b2cd4a5)
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите строку для сжатия:");
    String line = scanner.nextLine();
    String result = rle(line);
    System.out.println("Результат сжатия:");
    System.out.println(result);
  }

  public static String rle(String line) {
    if (line.isEmpty()) {
      return "";
    }
    StringBuilder result = new StringBuilder();
    result.append(line.charAt(0));
    int counter = 1;
    for (int i = 1; i < line.length(); ++i) { // O(n)
      char prev = line.charAt(i - 1);
      char curr = line.charAt(i);
      if (curr == prev) { // если символ повторяется
        ++counter; // мы должны его посчитать
      } else {
        if (counter > 1) {
          result.append(counter); // добавляем в строку результата значение счётчика
        }
        result.append(curr); // добавляем текущий (новый) символ
        counter = 1; // сбрасываем счётчик (уже для нового символа) на 1
      }
    }
    if (counter > 1) {
      result.append(counter); // добавляем в строку результата последнее значение счётчика
    }
    return result.toString(); // O(n)
  }
}
