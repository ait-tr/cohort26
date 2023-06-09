import java.util.Scanner;

public class Task2Sqrt {

  final static int PRECISION = 6;
  final static double ACCURACY = Math.pow(10, -(PRECISION + 1)); // accuracy = 10^-7 = 0.0000001

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите x: ");
    double x = scanner.nextDouble();
//    System.out.println("Корень из x: " + Math.sqrt(x));
//    System.out.println("Корень из x: " + sqrt(x));
    System.out.printf("Корень из x: %." + PRECISION + "f%n", Math.sqrt(x));
    System.out.printf("Корень из x: %." + PRECISION + "f%n", sqrt(x));
  }

  public static double sqrt(double x) {
    if (x < 1.0) {
      throw new IllegalArgumentException("Число должно быть больше или равно 1.0: " + x);
    }
    // бинарный поиск по ответу:
    // - корень будет где-то между 1 и x
    // - если "кандидат в квадрате" > x, то это слишком большой кандидат,
    //   ищем от left до кандидата (ищем там, где меньше)
    // - если "кандидат в квадрате" < x, то это слишком маленький кандидат,
    //   ищем от кандидата до right (ищем там, где больше)
    double left = 0;
    double right = x;

    // бинарный поиск по дробным числам должен остановиться, когда
    //   разница между границами меньше необходимой нам точности
    // между дробными числами необходимо избегать условий '==' и '!='
    //   (как буквально, так и по смыслу)
    while (right - left > ACCURACY) {
      double mid = (left + right) / 2.0;
      if (mid * mid > x) {
        // mid - слишком много
        right = mid;
      } else if (mid * mid < x) {
        // mid - слишком мало
        left = mid;
      } else {
        return mid; // не больше и не меньше, значит, это ответ
      }
    }
    return left; // можно и right, должны быть одинаковые
  }
}
