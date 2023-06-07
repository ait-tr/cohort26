public class Task4Fibonacci {

  // индексы:         0, 1, 2, 3, 4, 5,  6,  7,  8,  9
  // Числа Фибоначчи: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
  public static void main(String[] args) {
    System.out.println(fibonacci(9));
    System.out.println(fibonacci(10));
    System.out.println(fibonacci(11));
    System.out.println(fibonacci(12));
  }

  public static int fibonacci(int index) {
    if (index < 2) {
      return 1; // первые два числа
    }
    return fibonacci(index - 2) + fibonacci(index - 1);
  }
}
