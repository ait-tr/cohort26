import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  // сообщения о коммитах (commit messages):
  // - должны быть на английском
  // - должны начинаться с глагола в повелительном наклонении
  // "добавь файл" - add file
  // "добавь метод" - add method
  // "исправь код" - fix the code
  // - не должны быть общими:
  // вместо "добавь метод" стоит писать "добавь decToBin()"

  // Входной файл: in.txt
  // В первой строке дано количество записей.
  // Далее, каждая запись содержит фамилию кандидата и число голосов,
  // отданных за него в одном из штатов.
  // Подведите итоги выборов: для каждого из участника голосования определите число отданных
  // за него голосов.

  // Пример ввода:
  // 5
  // McCain 10
  // McCain 5
  // Obama 9
  // Obama 8
  // McCain 1

  // Пример вывода:
  // McCain 16
  // Obama 17
  public static void main(String[] args) throws FileNotFoundException {
    readInput("res/in.txt");
  }

  private static void readInput(String filename) throws FileNotFoundException {
    Map<String, Integer> result = new HashMap<>();
    Scanner scanner = new Scanner(new File(filename));
    int n = scanner.nextInt(); // читаем количество строк
    scanner.nextLine(); // переходим на новую строку
    for (int i = 0; i < n; ++i) { // читаем новые строки n раз
      String lastName = scanner.next();
      // Метод next() читает новое слово (!) и не переходит на следующую строку.
      // Если в строке три слова через пробел, то каждое слово будет прочитано своей командой
      // next().
      int votes = scanner.nextInt();
      scanner.nextLine(); // переходим на новую (следующую) строку
      // Метод nextLine() "дочитывает" строку до конца - до символа конца строки
      if (result.containsKey(lastName)) {
        result.put(lastName, result.get(lastName) + votes);
      } else {
        result.put(lastName, votes);
      }
    }
    System.out.println(result);
  }
}
