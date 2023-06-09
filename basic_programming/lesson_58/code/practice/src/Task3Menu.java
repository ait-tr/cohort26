import java.util.LinkedHashMap;
import java.util.Map;

public class Task3Menu {

  public static final int EXIT = 0;
  public static final int ADD = 1;
  public static final int REMOVE = 2;

  public static final Map<Integer, String> commands = new LinkedHashMap<>();
  static {
    commands.put(ADD, "Добавить");
    commands.put(REMOVE, "Удалить");
    commands.put(EXIT, "Выход");
  }
  // проверка корректности команды при чтении с клавиатуры: commands.containsKey()

  public static void printMenu() {
    // for (пара ключ-значение command : все пары словаря commands)
    //                              словарь/запись<типКлюча, типЗначения>
    // словарь:                                Map<Integer, String>
    // пара ключ-значение (запись):      Map.Entry<Integer, String>
    // все пары словаря для for-each: словарь.entrySet()
    for (Map.Entry<Integer, String> command : commands.entrySet()) {
      // получить из (пары ключ-значение) ключ:     запись.getKey()
      // получить из (пары ключ-значение) значение: запись.getValue()
      System.out.println(command.getKey() + ". " + command.getValue());
    }
  }

  public static void main(String[] args) {
    printMenu();
  }
}
