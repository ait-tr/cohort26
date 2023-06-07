package homework_55;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1Brackets {

  // дана последовательность открывающих и закрывающих скобок,
  // надо определить, корректна ли она (для каждой ли скобки есть пара)
  // варианты решения:
  // - две переменных (счётчики) и линейный перебор
  //   контр-пример: )))((( - последовательность некорректна
  // примеры:
  // - ()()()
  // - ((()())())
  // - ((()))
  // решение:
  // для одинаковых (например, круглых) скобок сработает простой счётчик:
  // - растёт при появлении открытой
  // - уменьшается при появлении закрытой
  // - как только падает ниже нуля - последовательность некорректна
  // для разных скобок:
  // варианты решения:
  // - несколько счётчиков, для каждого вида скобок свой:
  // примеры:
  // - ()[]
  // - ([])
  // - ([)] - несколько счётчиков не сработают, нельзя закрывать внешнюю скобку раньше,
  //   чем закрыта внутренняя - последовательность некорректна
  // решение:
  // стек с отрытыми скобками - закрываться должна ПОСЛЕДНЯЯ открытая
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    boolean correct = checkBrackets(line);
    System.out.println(correct);
  }

  // Усовершенствовать код файла `Task1Brackets`, избавиться от дублирования кода.

  // сложность - O(n) по времени, максимум O(n) по дополнительной памяти
  public static boolean checkBrackets(String brackets) {
    Map<Character, Character> bracketsMap = new HashMap<>();
    bracketsMap.put(')', '(');
    bracketsMap.put('}', '{');
    bracketsMap.put(']', '[');
    bracketsMap.put('>', '<');
    Deque<Character> openedBrackets = new ArrayDeque<>(); // максимум n/2 памяти (скобок) = O(n)
//    for (char c : brackets.toCharArray()) { // или по индексам и `brackets.charAt(i)`
    for (int i = 0; i < brackets.length(); ++i) { // .toCharArray - O(n) дополнительной памяти
      char curr = brackets.charAt(i);
      switch (curr) {
        case '(':
        case '{':
        case '[':
        case '<':
          openedBrackets.offerLast(curr);
          break;
        case ')':
        case '}':
        case ']':
        case '>': {
          // poll одновременно убирает из стека и отдаёт нам
          Character lastOpened = openedBrackets.pollLast(); // если открывающих скобок нет, null
          // если скобки нет или она неправильная
          // bracketsMap - "правильные" скобочки, по закрывающей получаем открывающую
          if (lastOpened == null || !lastOpened.equals(bracketsMap.get(curr))) {
            return false; // последовательность сломалась
          }
          break;
        }
        default:
          // не скобка, можно выкинуть ошибку, вернуть false или проигнорировать
          // мы решили проигнорировать
          break;
      }
    }
    // всё проверили и ни разу не сломались
    return openedBrackets.isEmpty(); // если не осталось открытых (и не закрытых) скобок
  }
}
