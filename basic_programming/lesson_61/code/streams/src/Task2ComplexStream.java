import java.util.Arrays;
import java.util.stream.Collectors;

public class Task2ComplexStream {

  public static void main(String[] args) {
    int[] numbers = {4, 2, 3, 1, 5};
    String result = Arrays.stream(numbers)
        .sorted()
        .map(x -> x * x)
        .mapToObj(x -> Integer.toString(x))
        .collect(Collectors.joining(", "));
    System.out.println(result);
  }
}
