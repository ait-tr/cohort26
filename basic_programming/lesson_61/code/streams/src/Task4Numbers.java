import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task4Numbers {

  // задача: читая с клавиатуры числа, найти сумму "вторых 10 чисел" - от 11-го до 20-го
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // лямбда-функцию можно заменить ссылкой на метод в двух случаях:
    // x -> f(x)   // ссылка на f  // единственный аргумент метода - `x`
    // x -> x.f()  // ссылка на f  // у метода нет аргументов, и этот метод вызывается у `x`
    // как выглядит ссылка на метод:
    // вызов статического метода: `Класс::метод()`
    // вызов не-статического метода: `объект::метод()`
    // (объект можно получить "как обычно", например, `System.out`, у которого вызывают `println()`:
    // `System.out::println`
    int result = IntStream.generate(scanner::nextInt)
        .skip(10)   // пропустить первые 10 чисел
        .limit(10)  // этот поток начинается с 11-го, как с начала
         // - ограничиваем 10 числами, до 20-го включительно
        .sum();
    System.out.println(result);

    // не делайте так
//    System.out.println(IntStream.generate(new Scanner(System.in)::nextInt).skip(10).limit(10).sum());
    int result2 = 0;
    int i = 0;
    while (true) {
      int x = scanner.nextInt(); // scanner::nextInt
      ++i;
      if (i < 11) { // .skip(10)
        continue;
      }
      if (i > 20) { // .limit(10)
        break;
      }
      result2 += x;
    }
    System.out.println(result2);
  }

  public static int sumSecondTen(List<Integer> numbers) {
    return numbers.stream()
        .skip(10)
        .limit(10)
        .mapToInt(Integer::intValue)
        .sum();
  }
}
