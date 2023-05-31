package homework_50;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2Set {

  // Прочитать с клавиатуры сначала количество целых чисел, а затем сами числа.
  // Сохранить эти числа в множестве.
  // Удалить из множества все нечётные числа.
  // Вывести получившееся множество.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Set<Integer> numbers = new HashSet<>();
    for (int i = 0; i < n; ++i) {
//      int x = scanner.nextInt();
//      numbers.add(x);
      numbers.add(scanner.nextInt());
    }

    // удаление: 2 способа
    // 1-й способ: перебор копии
//    Set<Integer> numbersCopy = new HashSet<>(numbers); // создаём копию numbers
//    for (int x : numbersCopy) { // перебираем копию
//      if (x % 2 != 0) {
//        numbers.remove(x); // меняем оригинал
//      }
//    }
    // 2-й способ: временное хранилище для всего, что надо удалить
    Set<Integer> oddNumbersToRemove = new HashSet<>();
    for (int x : numbers) { // перебираем числа
      if (x % 2 != 0) { // если число нечётное
        oddNumbersToRemove.add(x); // запоминаем его "для удаления"
      }
    }
    numbers.removeAll(oddNumbersToRemove);

    System.out.println(numbers);
  }
}
