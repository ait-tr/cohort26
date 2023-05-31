package homework_50;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2Set {

  // Прочитать с клавиатуры сначала количество целых чисел, а затем сами числа.
  // Сохранить эти числа в множестве.
  // Удалить из множества все нечётные числа.
  // Вывести получившееся множество.
  public static void main(String[] args) { // O(n) по времени, O(n) по памяти
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Set<Integer> numbers = new HashSet<>(); // O(n) по памяти
    for (int i = 0; i < n; ++i) { // n раз, каждый раз по O(1), итого - O(1 * n) = O(n)
//      int x = scanner.nextInt();
//      numbers.add(x);
      numbers.add(scanner.nextInt()); // O(1) по времени
    }

    // удаление: 2 способа
    // 1-й способ: перебор копии
//    Set<Integer> numbersCopy = new HashSet<>(numbers); // создаём копию numbers - O(n) по времени,
//    // O(n) по памяти
//    for (int x : numbersCopy) { // перебираем копию - n элементов, для каждого O(1), итого O(n)
//      if (x % 2 != 0) { // O(1)
//        numbers.remove(x); // меняем оригинал // O(1)
//      }
//    }
    // O(n) + O(2 * n) = O(3 * n) = O(n)
    // 2-й способ: временное хранилище для всего, что надо удалить
    Set<Integer> oddNumbersToRemove = new HashSet<>(); // O(1) по времени, O(n / 2) = O(n) по памяти
    for (int x : numbers) { // перебираем оригинал // O(1 * n) = O(n)
      if (x % 2 != 0) { // если число нечётное // O(1)
        oddNumbersToRemove.add(x); // меняем временную коллекцию // O(1)
        // запоминаем его "для удаления"
      }
    }
//    for (int x : oddNumbersToRemove) { // перебираем временную коллекцию // O(n / 2) = O(n)
//      numbers.remove(x); // меняем оригинал // O(1)
//    }
    numbers.removeAll(oddNumbersToRemove); // O(n / 2) = O(n)
    // (на самом деле O(m), где m - количество нечётных чисел)

    System.out.println(numbers); // O(n / 2) = O(1/2 * n) = O(0.5 * n) = O(n)
    // O(n) + O(n) = O(n)
  }
}
