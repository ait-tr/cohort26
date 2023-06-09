import java.util.Scanner;

public class Task0Efficiency {

  // алгоритмы сортировки, которые стоит знать:
  // - пузырьком (bubble sort)
  // - сортировка слиянием (merge sort)
  // - быстрая сортировка (quick sort)
  // - сортировка вставками (insertion sort)
  // - сортировка выборкой (selection sort)
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите размер данных: ");
    int n = scanner.nextInt();
    printComplexity(n);
  }

  private static void printComplexity(int n) {
    System.out.printf("O(1)       ~ %d%n", 1);
    System.out.printf("O(log n)   ~ %.0f%n", Math.log(n));
    System.out.printf("O(n)       ~ %d%n", n);
    System.out.printf("O(n log n) ~ %.0f%n", n * Math.log(n));
    System.out.printf("O(n^2)     ~ %.0f%n", Math.pow(n, 2));
    System.out.printf("O(n^3)     ~ %.0f%n", Math.pow(n, 3));
    System.out.printf("O(2^n)     ~ %.0f%n", Math.pow(2, n));
    System.out.printf("O(n!)      ~ %.0f%n", fact(n));
    System.out.printf("O(n^n)     ~ %.0f%n", Math.pow(n, n));
  }

  // рекурсия -> StackOverflow (O(n) по памяти)
//  private static double fact(int n) {
//    // факториал = n! = 1 * 2 * ... * (n-1) * n = (n-1)! * n
//    if (n < 0) {
//      throw new IllegalArgumentException("Число не может быть отрицательным: " + n);
//    }
//    if (n <= 2) {
//      return n; // 1! = 1, 2! = 1 * 2 = 2
//    }
//    return n * fact(n - 1);
//  }

  private static double fact(int n) {
    double result = 1.0;
    for (int x = 1; x <= n; ++x) {
      result *= x;
    }
    return result;
  }
}
