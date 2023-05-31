import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1Filter {

  // Прочитать с клавиатуры сначала количество целых чисел, а затем сами числа.
  // Вывести только чётные числа.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
//    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      int x = scanner.nextInt();
      // - сложить в коллекцию, удалить лишнее // O(n) по времени и памяти
      // - сложить в коллекцию, отфильтровать при выводе // O(n) по времени и памяти
//      numbers.add(x);
      // - сразу выводить // O(n) по времени, O(1) по памяти
      if (x % 2 == 0) {
        System.out.println(x);
      }
    }
//    for (int x : numbers) {
//      if (x % 2 == 0) {
//        System.out.println(x); // фильтр при выводе
//      }
//    }
  }
}
