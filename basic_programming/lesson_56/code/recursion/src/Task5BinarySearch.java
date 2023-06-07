import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task5BinarySearch {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(List.of(3, 5, 2, 7, 9));
    Collections.sort(numbers); // 2, 3, 5, 7, 9
    System.out.println(binarySearch(numbers, 3)); // индекс 1
  }

  public static int binarySearch(List<Integer> numbers, int target) {
    return binarySearch(numbers, target, 0, numbers.size() - 1);
  }

  /**
   * Поиск target в списке numbers
   *
   * @param numbers отсортированный по возрастанию список чисел для поиска
   * @param target цель поиска
   * @param left левая граница диапазона поиска (включая)
   * @param right правая граница диапазона поиска (включая)
   * @return индекс target в списке numbers или -1, если такого элемента там нет
   */
  public static int binarySearch(List<Integer> numbers, int target, int left, int right) {
    if (left == right) { // выход из рекурсии - конец поиска
      if (numbers.get(left) == target) {
        return left;
      }
      return -1;
    }
    int mid = left + (right - left) / 2;
    int midX = numbers.get(mid);
    if (midX < target) {
      return binarySearch(numbers, target, mid + 1, right); // сузил область поиска
    }
    if (midX > target) {
      return binarySearch(numbers, target, left, mid - 1);
    }
    // если не меньше и не больше, то равно
    return mid; // мы нашли элемент
  }
}
