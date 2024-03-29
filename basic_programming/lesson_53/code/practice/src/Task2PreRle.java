import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2PreRle {

  // Run-length encoding (RLE) (aaabbcddddaaaaa = a3b2cd4a5)
  // Промежуточная задача - PreRLE - убрать повторяющиеся подряд символы
  // (aaabbcddddaaaaa = abcda)
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите строку для сжатия:");
    String line = scanner.nextLine();
    String result = preRleShort(line);
    System.out.println("Промежуточный результат сжатия:");
    System.out.println(result);
  }

  public static String preRle(String line) {
//    String result = "";
    StringBuilder result = new StringBuilder();
    Character prev = null; // никакого "предыдущего" ещё нет
    for (int i = 0; i < line.length(); ++i) { // n раз - O(n * n) для String, O(n) для StringBuilder
      Character current = line.charAt(i); // O(1)
      if (!current.equals(prev)) { // O(1)
//        result += current; // O(n) для String += String / char
        result.append(current); // O(1) для StringBuilder.append(String / char)
        prev = current; // O(1)
      }
    }
//    return result; // O(1)
    return result.toString(); // O(n)
  }

  public static String preRleList(String line) {
    List<Character> result = new ArrayList<>();
    Character prev = null; // никакого "предыдущего" ещё нет
    for (int i = 0; i < line.length(); ++i) { // n раз - O(n)
      Character current = line.charAt(i); // O(1)
      if (!current.equals(prev)) { // O(1)
        result.add(current); // O(1)
        prev = current; // O(1)
      }
    }
    char[] preString = new char[result.size()]; // O(1)
    for (int i = 0; i < result.size(); ++i) { // n раз - O(n)
      preString[i] = result.get(i); // O(1) для ArrayList
    }
    return new String(preString); // O(n)
  }

  public static String preRleShort(String line) {
    if (line.isEmpty()) {
      return "";
    }
    StringBuilder result = new StringBuilder();
    result.append(line.charAt(0));
    for (int i = 1; i < line.length(); ++i) { // (n - 1) раз - O(n)
      if (line.charAt(i) != line.charAt(i - 1)) { // O(1)
        result.append(line.charAt(i)); // O(1)
      }
    }
    return result.toString(); // O(n)
  }
}
