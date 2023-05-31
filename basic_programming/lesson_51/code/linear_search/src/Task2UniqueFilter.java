import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2UniqueFilter {

  // Прочитать с клавиатуры сначала количество целых чисел, а затем сами числа.
  // Вывести только уникальные чётные числа (без повторений).
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Set<Integer> printed = new HashSet<>(); // максимум O(n) по памяти
    for (int i = 0; i < n; ++i) { // O(n) по времени
      int x = scanner.nextInt();
      // мало проверить чётность, надо проверить уникальность
      if (x % 2 == 0 && !printed.contains(x)) { // если чётное и не печатали // для HashSet - O(1)
        System.out.println(x); // то напечатать
        printed.add(x); // добавить в множество распечатанных // для HashSet - O(1)
      }
    }
  }
}
