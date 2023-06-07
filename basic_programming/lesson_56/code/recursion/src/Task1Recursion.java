import java.util.ArrayList;
import java.util.List;

public class Task1Recursion {

  // Рекурсия (recursion) - см. Рекурсия
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    reversePrintRecurse(numbers);
  }

  // вывести элементы списка в обратном порядке
  // 1 вариант: итеративный (с перебором)
  public static void reversePrint(List<Integer> numbers) {
    for (int i = numbers.size() - 1; i >= 0; --i) {
      System.out.println(numbers.get(i));
    }
  }

  // 2 вариант: рекурсивный (с рекурсией)
  public static void reversePrintRecurse(List<Integer> numbers) {
    reversePrintRecurse(numbers, numbers.size() - 1);
  }

  // рекурсия здесь!
  public static void reversePrintRecurse(List<Integer> numbers, int lastIndex) {
    if (lastIndex < 0) {
      return; // выход из рекурсии
    }
    System.out.println(numbers.get(lastIndex));
    // if (lastIndex > 0) { // правильный шаг рекурсии
    reversePrintRecurse(numbers, lastIndex - 1);
  }
}
