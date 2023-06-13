import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NumbersMenu {

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

  // Функциональный интерфейс для методов, которые ничего не получают и ничего не возвращают:
  // `Runnable`
  private static final Map<String, Runnable> actions = new LinkedHashMap<>();

  static {
    // если лямбда-функция состоит из единственного вызова другого метода с таким же аргументом,
    // её можно заменить ссылкой на метод (method reference): `Класс::метод`
    actions.put(ADD, NumbersMenu::add);
    actions.put(PRINT, NumbersMenu::print);
    // для обращения к атрибутам внутри лямбда-функции стоит указать this.атрибут или Класс.атрибут
    actions.put(SORT, () -> Collections.sort(NumbersMenu.numbers));
    actions.put(EXIT, () -> System.exit(0));
  }

  private static void add() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите целое число для добавления: ");
    numbers.add(scanner.nextInt());
  }

  private static void print() {
    System.out.println(numbers);
  }

  private static final List<Integer> numbers = new ArrayList<>();

  private static void printMenu() {
    for (Map.Entry<String, String> entry : descriptions.entrySet()) {
      System.out.println(entry.getKey() + ". " + entry.getValue());
    }
  }

  public static String read() {
    printMenu();
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

  public static void apply(String command) {
    if (!actions.containsKey(command)) {
      throw new IllegalArgumentException("Некорректная команда: " + command);
    }
    actions.get(command).run();
  }

  public static void main(String[] args) {
    while (true) {
      apply(read());
    }
  }
}
