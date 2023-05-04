package homework_34;

public class Triangle {

  // Создайте класс `Triangle` (треугольник), принимающий три целых значения - длины трёх сторон
  // треугольника.
  //
  // В конструкторе нужно проверить введённые значения на корректность (например, длины не могут
  // быть отрицательными).
  //
  // В классе должен быть описан отдельный статический метод
  // `public static boolean checkSides(int a, int b, int c)`,
  // который должен проверить неравенство треугольника.
  //
  // Этот метод необходимо использовать в конструкторе.
  //
  // При провале любой из проверок нужно вывести на экран соответствующее сообщение или выкинуть
  // исключение.
  private final int sideA;
  private final int sideB;
  private final int sideC;

  public Triangle(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0) {
      throw new IllegalArgumentException("Стороны не могут не быть положительными");
    }
    if (!checkSides(a, b, c)) {
      throw new IllegalArgumentException("Не выполняется условие треугольника");
    }
    sideA = a;
    sideB = b;
    sideC = c;
  }

  public static boolean checkSides(int a, int b, int c) {
    return a < (b + c) && b < (a + c) && c < (b + a);
  }

  public int getSideA() {
    return sideA;
  }

  public int getSideB() {
    return sideB;
  }

  public int getSideC() {
    return sideC;
  }
}
