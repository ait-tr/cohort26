import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1DeleteFromList {

  // Прочитать с клавиатуры сначала количество чисел, а затем сами числа.
  // Сохранить эти числа в списке.
  // Удалить из списка все чётные числа.
  // Вывести получившийся список.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
//      int x = scanner.nextInt();
//      numbers.add(x);
      numbers.add(scanner.nextInt());
    }
  }
}
