import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task4Menu {

  private static final String EXIT = "0";
  private static final String ADD = "1";
  private static final String PRINT = "2";
  private static final String SORT = "3";

  private static final Map<String, String> descriptions = new LinkedHashMap<>();
  static {
    descriptions.put(ADD, "Добавить элемент");
    descriptions.put(PRINT, "Вывести элементы");
    descriptions.put(SORT, "Отсортировать элементы");
    descriptions.put(EXIT, "Выход");
  }

  public static void print() {
    for (Map.Entry<String, String> entry : descriptions.entrySet()) {
      System.out.println(entry.getKey() + ". " + entry.getValue());
    }
  }

  public static String read() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите команду: ");
    String command = scanner.nextLine();
    while (!descriptions.containsKey(command)) {
      System.out.println("Некорректная команда: \"" + command + '"');
      System.out.print("Введите команду: ");
      command = scanner.nextLine();
    }
    return command;
  }
}
