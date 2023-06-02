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
    int result = -1; // индекс самого большого найденного нечётного
    for (int i = 0; i < numbers.size(); i++) {
      int x = numbers.get(i);
      // если (число нечётное И (нечётных чисел ещё не было ИЛИ число больше известного максимума))
      // если (число нечётное И (результат не менялся ИЛИ число больше известного максимума))
      if (x % 2 != 0 && (result == -1 || x > numbers.get(result))) {
        result = i;
      }
    }
    return result; // не нашли нечётных чисел
  }
}
