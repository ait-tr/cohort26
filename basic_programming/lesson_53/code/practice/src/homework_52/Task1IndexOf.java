package homework_52;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1IndexOf {

  public static void main(String[] args) {
    int r = (Integer.MAX_VALUE + Integer.MAX_VALUE / 2) / 2;
    System.out.println(r);
    Scanner scanner = new Scanner(System.in);
    List<Integer> numbers = readSortedList(scanner);
    System.out.print("Введите элемент для поиска: ");
    int x = scanner.nextInt();
    int i = indexOf(numbers, x);
    // "indexOf(numbers, x) = i"
    System.out.println("indexOf(" + numbers + ", " + x + ") = " + i);
  }

  private static List<Integer> readList(Scanner scanner) {
    List<Integer> result = new ArrayList<>();
    System.out.print("Введите размер списка: ");
    int size = scanner.nextInt();
    System.out.println("Введите элементы списка:");
    for (int i = 0; i < size; ++i) {
      result.add(scanner.nextInt());
    }
    scanner.nextLine(); // дочитываем последнюю строку до конца
    return result;
  }

  private static List<Integer> readSortedList(Scanner scanner) {
    List<Integer> result = readList(scanner);
    Collections.sort(result); // сортируем по возрастанию
    Collections.reverse(result); // переворачиваем - получается отсортированный по убыванию
    return result;
  }

  /**
   * Бинарный поиск элемента в отсортированном по убыванию списке
   *
   * @param numbers отсортированный по убыванию список
   * @param target  число для поиска в списке
   * @return индекс элемента в списке или -1, если элемент не найден
   */
  private static int indexOf(List<Integer> numbers, int target) {
    int left = 0;
    int right = numbers.size(); // правая граница - не включая

    while (left < right - 1) { // пока диапазон больше, чем один элемент
      int mid = left + (right - left) / 2; // вместо `(left + right) / 2`
      // left + (right - left) / 2 =
      // left + (right / 2 - left / 2) =
      // left + right / 2 - left / 2 =
      // left - left / 2 + right / 2 =
      // (left - left / 2) + right / 2 =
      // left / 2 + right / 2 =
      // (left + right) / 2
      int midX = numbers.get(mid);
      if (midX < target) { // n, ..target.., midX, ..., 1
                           // left, ...,     mid, ...,    right
        right = mid;       // left, ...,     right
      } else if (midX > target) { // n, ....,   midX, ..target.., 1
                                  // left, ..., mid, ...,           right
        left = mid + 1;           // ...,            left, ...,     right
      } else {
        return mid;
      }
    }
    // остался один кандидат: элемент с индексом left (right на один больше и не включая)
    if (numbers.get(left) == target) {
      return left;
    }
    return -1; // если не нашли элемент
  }
}
