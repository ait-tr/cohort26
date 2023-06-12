import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task4Menu {

  private static final int EXIT = 0;
  private static final int ADD = 1;
  private static final int PRINT = 2;
  private static final int SORT = 3;

  private static final Map<Integer, String> descriptions = new LinkedHashMap<>();
  static {
    descriptions.put(ADD, "Добавить элемент");
    descriptions.put(PRINT, "Вывести элементы");
    descriptions.put(SORT, "Отсортировать элементы");
    descriptions.put(EXIT, "Выход");
  }

  public static void print() {
    for (Map.Entry<Integer, String> entry : descriptions.entrySet()) {
      System.out.println(entry.getKey() + ". " + entry.getValue());
    }
  }

  public static int read() {
    Scanner scanner = new Scanner(System.in);
    int command;
    do {
      while (!scanner.hasNextInt()) {
        String wrong = scanner.nextLine();
        System.out.println("Некорректный ввод: " + wrong);
        System.out.println("Введите номер команды!");
      }
      command = scanner.nextInt();
      scanner.nextLine();
      if (!descriptions.containsKey(command)) {
        System.out.println("Некорректный номер команды: " + command);
      }
    } while (!descriptions.containsKey(command));
    return command;
  }
}
