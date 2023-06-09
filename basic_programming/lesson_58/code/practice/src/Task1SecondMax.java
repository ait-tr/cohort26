import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1SecondMax {

  // найти второй (!) максимальный элемент в последовательности целых чисел
  // (все элементы разные)
  // 5, 3, 7, 4, 9 = первый максимум - 9, второй максимум - 7
  // варианты решения:
  // - отсортировать и взять второй с конца - O(n log n) time, O(n) space
  // - найти первый максимум, удалить и найти первый оставшийся максимум - O(n) time, O(n) space
  // меньше, чем O(n) по времени, не получится - нам нужно прочитать n чисел.
  // Получится ли эффективнее по памяти?
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(List.of(5, 3, 7, 4, 9)); // O(n) time, O(n) space
    System.out.println(secondMax(numbers));
  }

  // варианты решения:

  // - отсортировать и взять второй с конца - O(n log n) time, O(n) space
  public static Integer secondMaxSort(List<Integer> numbers) {
    if (numbers.size() < 2) {
      System.out.println("В списке меньше двух элементов!");
      return null;
    }
    Collections.sort(numbers); // O(n log n) time
    // размер - numbers.size()
    // индексы - от 0 до (numbers.size() - 1)
    // индексы с конца:
    // - numbers.size() - 1 (последний)
    // - numbers.size() - 2 (предпоследний)
    // - ...
    // - 1 (второй)
    // - 0 (первый)
    return numbers.get(numbers.size() - 2); // предпоследний в отсортированном по возрастанию
  }

  // - найти первый максимум, удалить его и опять найти первый оставшийся максимум
  public static Integer secondMax(List<Integer> numbers) {
    if (numbers.size() < 2) {
      System.out.println("В списке меньше двух элементов!");
      return null;
    }
    int firstMax = Collections.max(numbers); // O(n) time
    // если удалить не Integer, а int, Java будет считать, что это индекс
    numbers.remove((Integer) firstMax);
    return Collections.max(numbers);
  }

  public static int firstMax(Scanner scanner) {
    int m = Integer.MIN_VALUE; // "рамочка"
    while (scanner.hasNextInt()) { // O(n) time, O(1) space
      int x = scanner.nextInt();
      m = Math.max(x, m);
    }
    return m; // первый максимум
  }

  // читать, обрабатывать и тут же забывать - не хранить входные данные
  // две "рамочки", как обычный максимум, но второй по величине
  // O(n) time, O(1) space
  public static int secondMax(Scanner scanner) {
    int m1 = Integer.MIN_VALUE; // "рамочка #1"
    int m2 = Integer.MIN_VALUE; // "рамочка #2"
    while (scanner.hasNextInt()) { // O(n) time, O(1) space
      int x = scanner.nextInt();
      //    ...   m2    m1    - было
      // варианты:
      // 1) ..x.. m2    m1    - не интересно
      // 2) ...   m2 x  m1    - надо сдвинуть только m2
        //  ...      m2 m1    - должно получиться
      // 3) ...   m2    m1 x  - надо сдвинуть обе рамочки
        //  ...         m2 m1 - должно получиться
      if (x > m1) { // 3-й вариант
        // если числа могут повторяться и нужно это повторение учесть, то `if (x >= m1)`
        m2 = m1; // сначала меняем m2, старое значение больше не нужно
        m1 = x;  // теперь меняем m1, его старое значение уже сохранено в m2
      } else if (x > m2) { // 2-й вариант - не больше m1, но больше m2
        m2 = x; // сдвигаем m2
      }
    }
    return m2;
  }
}
