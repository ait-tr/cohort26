import java.util.List;

public class Task1IndexOfMaxOdd {

  /**
   * Поиск индекса максимального нечётного числа в последовательности целых чисел
   *
   * @param numbers список целых чисел
   * @return индекс максимального нечётного числа или -1, если в последовательности нет нечётных
   * чисел
   */
  public static int indexOfMaxOdd(List<Integer> numbers) {
    int result = -1;
    for (int i = 0; i < numbers.size(); i++) {
      int x = numbers.get(i);
      int maxOdd = Integer.MIN_VALUE; // минимальное значение (будем увеличивать)
      if (result > 0) { // если до этого что-то находили
        maxOdd = numbers.get(result); // записываем найденное в рамочку
      }
      if (x % 2 != 0 && x > maxOdd) {
        result = i;
      }
    }
    return result; // не нашли нечётных чисел
  }
}
