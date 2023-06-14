import java.util.Arrays;
import java.util.stream.Collectors;

public class Task2ComplexStream {

  public static void main(String[] args) {
    int[] numbers = {4, 2, 3, 1, 5};
    String result = Arrays.stream(numbers)
        .filter(x -> x % 2 != 0)            // оставляем нечётные
        .sorted()                           // сортируем
        .map(x -> x * x)                    // превращаем в квадраты
        .mapToObj(Integer::toString)        // превращаем IntStream в Stream<String>
        .collect(Collectors.joining(", ")); // склеиваем через ", " в одну строку
    System.out.println(result);
  }
}
