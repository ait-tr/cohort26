import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Task1DeleteFromList {

  // Прочитать с клавиатуры сначала количество чисел, а затем сами числа.
  // Сохранить эти числа в списке.
  // Удалить из списка все чётные числа.
  // Вывести получившийся список.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> numbers = new ArrayList<>(); // 1, 2, 3, 4
    for (int i = 0; i < n; ++i) {
//      int x = scanner.nextInt();
//      numbers.add(x);
      numbers.add(scanner.nextInt());
    }
    // нельзя одновременно и перебирать, и менять одну и ту же коллекцию
    // 1-й вариант: перебор копии
//    List<Integer> numbersCopy = new ArrayList<>(numbers);
//    int shift = 0; // сдвиг индекса оригинала относительно копии из-за удаления
//    for (int i = 0; i < numbersCopy.size(); ++i) { // 1, 2, 3, 4
//      if (numbersCopy.get(i) % 2 == 0) { // i = 3, elem = 4
//        numbers.remove(i - shift); // 1, 3
//        ++shift; // 1
//      }
//    }
    // 2-й вариант: перебор в обратном порядке
//    for (int i = numbers.size() - 1; i >= 0; --i) { // последний индекс коллекции: (размер - 1)
//      if (numbers.get(i) % 2 == 0) {
//        numbers.remove(i); // если идти с конца, то индексы "в начале" не пострадают и не собьются
//      }
//    }
    // 3-й вариант: временная коллекция "к удалению"
    Set<Integer> toRemove = new HashSet<>();
    for (int elem : numbers) { // перебираем без изменения коллекции
      if (elem % 2 == 0) {
        toRemove.add(elem); // добавить чётные числа в множество "чисел к удалению"
      }
    }
    numbers.removeAll(toRemove); // коллекция.удалитьВсе(коллекцияКУдалению)
  }
}
