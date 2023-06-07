package homework_55;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1Brackets {

  private static final Map<Character, Character> bracketsMap = new HashMap<>();
  static { // последовательность команд, которые выполнятся один раз при запуске программы
    bracketsMap.put(')', '(');
    bracketsMap.put('}', '{');
    bracketsMap.put(']', '[');
    bracketsMap.put('>', '<');
  }

  // Усовершенствовать код файла `Task1Brackets`, избавиться от дублирования кода.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    boolean correct = checkBrackets(line);
    System.out.println(correct);
  }

  // сложность - O(n) по времени, максимум O(n) по дополнительной памяти
  public static boolean checkBrackets(String brackets) {
    Deque<Character> openedBrackets = new ArrayDeque<>(); // максимум n/2 памяти (скобок) = O(n)
//    for (char c : brackets.toCharArray()) { // или по индексам и `brackets.charAt(i)`
    for (int i = 0; i < brackets.length(); ++i) { // .toCharArray - O(n) дополнительной памяти
      char curr = brackets.charAt(i);
      switch (curr) {
        case '(', '{', '[', '<':
          openedBrackets.offerLast(curr);
          break;
        case ')', '}', ']', '>': {
          Character lastOpened = openedBrackets.pollLast();
//          if (lastOpened == null || lastOpened.charValue() != bracketsMap.get(curr).charValue()) {
          if (lastOpened == null || !lastOpened.equals(bracketsMap.get(curr))) {
            return false; // последовательность сломалась
          }
          break;
        }
        // все "не скобки" мы решили проигнорировать
      }
    }
    // всё проверили и ни разу не сломались
    return openedBrackets.isEmpty(); // если не осталось открытых (и не закрытых) скобок
  }
}
