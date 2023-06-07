public class Task3Pow {

  public static void main(String[] args) {
    System.out.println("5 ^ 7 = " + pow(5, 7));
  }

  /**
   * Возведение x в степень p
   *
   * @param x аргумент для возведения в степень
   * @param p степень (неотрицательная)
   * @return x в степени p
   */
  public static int pow(int x, int p) {
    if (p < 0) { // условие-стражник для проверки корректности аргументов
      throw new IllegalArgumentException("отрицательная степень: " + p);
    }
    // x^0 = 1
    if (p == 0) { // условие-стражник для выхода из рекурсии
      return 1;
    }
    // x^5 = x^4 * x
    // x^p = x^(p-1) * x
    return pow(x, p - 1) * x;
  }
}
