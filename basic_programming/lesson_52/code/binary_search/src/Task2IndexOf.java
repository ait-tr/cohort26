import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task2IndexOf {

  public static void main(String[] args) {
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
    Collections.sort(result);
    return result;
  }

  /**
   * Бинарный поиск элемента в отсортированном по возрастанию списке
   *
   * @param numbers отсортированный по возрастанию список
   * @param target  число для поиска в списке
   * @return индекс элемента в списке или -1, если элемент не найден
   */
  private static int indexOf(List<Integer> numbers, int target) {
    int left = 0; // левая граница индексов (включая)
    int right = numbers.size(); // правая граница индексов (не включая)
    while (left < right - 1) { // пока расстояние больше одного элемента
      int mid = (left + right) / 2; // индекс среднего элемента
      int midElem = numbers.get(mid); // сам средний элемент
      if (midElem < target) { // середина меньше, чем то, что нам нужно; то, что нам нужно, справа
        left = mid + 1; // сдвигаем левую границу вправо
      } else if (midElem > target) { // середина больше цели, цель слева
        right = mid - 1; // сдвигаем правую границу влево
      } else { // не меньше и не больше, значит, нашли
        return mid; // досрочно нашли ответ
      }
    }
    // сузили границы поиска до одного элемента: [left, right) - значит, проверяем индекс left
    if (numbers.get(left) == target) {
      return left;
    }
    // последний вариант не подошёл, числа в списке нет
    return -1;
  }
}
