import java.util.Scanner;

public class Task2PreRle {

  // Run-length encoding (RLE) (aaabbcddddaaaaa = a3b2cd4a5)
  // Промежуточная задача - PreRLE - убрать повторяющиеся подряд символы
  // (aaabbcddddaaaaa = abcda)
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите строку для сжатия:");
    String line = scanner.nextLine();
    String result = preRle(line);
    System.out.println("Промежуточный результат сжатия:");
    System.out.println(result);
  }

  public static String preRle(String line) {
    String result = "";
    Character prev = null; // никакого "предыдущего" ещё нет
    for (int i = 0; i < line.length(); ++i) {
      Character current = line.charAt(i);
      if (!current.equals(prev)) {
        result += current;
        prev = current;
      }
    }
    return result;
  }
}
