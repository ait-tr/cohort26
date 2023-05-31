package homework_50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task3Map {

  // Прочитать с клавиатуры сначала количество записей в телефонной книге, а затем сами записи
  // (номер телефона и имя).
  // Сохранить эти записи в словаре (телефон (строка) - имя (строка)).
  // Спросить имя для удаления.
  // Удалить из словаря все телефоны, имя для которых совпадает с указанным.
  // Вывести получившийся словарь.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    Map<String, String> phonebook = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      String phone = scanner.nextLine(); // телефон - читаем всю строку
      String name = scanner.nextLine(); // имя - читаем всю строку
      phonebook.put(phone, name); // пара "телефон - имя", телефон - это ключ словаря
    }

    System.out.print("Введите имя для удаления: ");
    String nameToRemove = scanner.nextLine();
    Set<String> phonesToRemove = new HashSet<>();

    // для удаления из словаря перебираем весь словарь и запоминаем ключи (всегда ключи!)
    // 1-й способ перебора: перебираем ключи, по ключу получаем значение
//    for (String phone : phonebook.keySet()) { // перебираем ключи (номера телефонов)
//      String name = phonebook.get(phone); // по ключу (телефону) получаем значение (имя)
//      if (name.equals(nameToRemove)) { // если имя совпадает с именем для удаления
//        phonesToRemove.add(phone); // запоминаем номер телефона, для которого указано это имя
//      }
//    }
    // 2-й способ перебора: перебираем пары ключ-значение (Map.Entry<>)
    for (Map.Entry<String, String> entry : phonebook.entrySet()) { // перебираем пары
      String name = entry.getValue(); // имя - это значение в нашей паре
      if (name.equals(nameToRemove)) {
        String phone = entry.getKey(); // телефон - это ключ в нашей паре
        phonesToRemove.add(phone);
      }
    }
    // удаляем все запомненные ключи из словаря (из словаря по ключу всегда удаляется пара)
    for (String phone : phonesToRemove) { // перебираем множество ненужных телефонов
      phonebook.remove(phone); // удаляем каждый ненужный телефон из нашей телефонной книги
    }

    System.out.println(phonebook);
    for (Map.Entry<String, String> entry : phonebook.entrySet()) {
      String phone = entry.getKey();
      String name = entry.getValue();
      System.out.println(phone + ": " + name);
    }
  }
}
