import java.util.ArrayList;
import java.util.List;

public class Task2MergeSortDebugPrint {

  static int shift = 0;

  // сортировка слиянием - Merge Sort
  // идея относится к классу Divide and Conquer - разделяй и властвуй
  // идея: разбить на несколько (часто 2) задач меньшего размера, решить, скомбинировать результаты
  // как только такая идея найдена, можно рекурсивно уменьшать размер до очевидного (например, 1)
  // идея сортировки: разбить на 2 части, отсортировать каждую, итог соединить в один массив.
  // основная часть решения - алгоритм соединения двух маленьких отсортированных массивов в один
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(List.of(4, 2, 5, 7, 3));
    System.out.println(numbers);
    numbers = sort(numbers); // сортировка not-in-place - не на месте
    System.out.println(numbers);
  }

  public static List<Integer> sort(List<Integer> numbers) {
    for (int i = 0; i < shift; ++i) {
      System.out.print(" ");
    }
    System.out.println("=== sort(" + numbers + ") ===");
    if (numbers.size() < 2) {
      for (int i = 0; i < shift; ++i) {
        System.out.print(" ");
      }
      System.out.println(numbers);
      return numbers; // выход из рекурсии - в списке ничего нет или один элемент
    }
    int mid = numbers.size() / 2;
    List<Integer> left = numbers.subList(0, mid); // 0 включая, mid не включая
    List<Integer> right = numbers.subList(mid, numbers.size()); // mid включая, .size() не включая

    ++shift;
    left = sort(left); // рекурсивная сортировка списка поменьше
    right = sort(right); // рекурсивная сортировка списка поменьше
    List<Integer> result = merge(left, right);
    --shift;
    for (int i = 0; i < shift; ++i) {
      System.out.print(" ");
    }
    System.out.println(result);
    return result;
  }

  /**
   * Слияние двух отсортированных списков в один
   *
   * @param list1 отсортированный по возрастанию список
   * @param list2 отсортированный по возрастанию список
   * @return отсортированный по возрастанию список, объединение list1 и list2
   */
  private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
    for (int i = 0; i < shift; ++i) {
      System.out.print(" ");
    }
    System.out.println("=== merge(" + list1 + ", " + list2 + ") ===");
    // зададим вместимость (не размер!) результата при создании, это немного ускорит процесс
    List<Integer> result = new ArrayList<>(list1.size() + list2.size());
    // list1 и list2 уже отсортированы
    // хотим слить [2, 4] и [3, 5, 7] в [2, 3, 4, 5, 7]
    // у нас будет позиция в каждом списке: i1 и i2
    // пока мы не дошли до конца, нужно сравнить list1[i1] и list2[i2] и добавить в результат
    // меньший из этих двух. После этого позицию необходимо сдвинуть для того списка, чей
    // элемент добавили.
    int i1 = 0;
    int i2 = 0;
    while (i1 < list1.size() || i2 < list2.size()) { // пока хотя бы один список не дочитан
      for (int i = 0; i < shift; ++i) {
        System.out.print(" ");
      }
      System.out.print("list1 = " + list1.subList(i1, list1.size()) + ", ");
      System.out.print("list2 = " + list2.subList(i2, list2.size()) + ", ");
      System.out.println("result = " + result);
      if (i1 < list1.size() && i2 < list2.size()) { // оба списка не дочитаны
        if (list1.get(i1) < list2.get(i2)) { // если элемент из первого должен быть следующим
          result.add(list1.get(i1));
          ++i1;
        } else { // не из первого - значит, из второго
          result.add(list2.get(i2));
          ++i2;
        }
      } else if (i1 < list1.size()) { // не дочитан первый (но не оба, значит, дочитан второй)
        result.add(list1.get(i1));
        ++i1;
      } else { // не дочитан второй (потому что не первый и не оба)
        result.add(list2.get(i2));
        ++i2;
      }

    }
    // вышли из цикла - оба списка дочитаны
    return result;
  }
}
