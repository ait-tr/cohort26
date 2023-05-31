import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3Customers {

  // Дана база данных о продажах некоторого интернет-магазина.

  // Каждая строка входного файла представляет собой запись вида
  // Покупатель товар количество
  // где Покупатель — имя покупателя (строка без пробелов),
  // товар — название товара (строка без пробелов),
  // количество — количество приобретенных единиц товара.

  // Создайте словарь всех покупателей, а для каждого покупателя подсчитайте количество
  // приобретенных им единиц каждого вида товаров.

  // Пример входных данных:
  // Ivanov paper 10
  // Petrov pen 5
  // Ivanov marker 3
  // Ivanov paper 7
  // Petrov envelope 20
  // Ivanov envelope 5

  // Пример выходных данных
  // Ivanov:
  // envelope 5
  // marker 3
  // paper 17
  // Petrov:
  // envelope 20
  // pen 5
  public static void main(String[] args) throws IOException {
    // Map<String, Integer> - пары "товар-количество"
    // Map<String, ...> - пары "покупатель-..."
    // Map<String, Map<String, Integer>> - пары "покупатель - (пары "товар-количество")"
    Map<String, Map<String, Integer>> customers = new HashMap<>();
    Scanner scanner = new Scanner(new File("res/in3.txt"));
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      int firstSpace = line.indexOf(' ');
      int secondSpace = line.indexOf(' ', firstSpace + 1);
      String name = line.substring(0, firstSpace);
      String good = line.substring(firstSpace + 1, secondSpace);
      int quantity = Integer.parseInt(line.substring(secondSpace + 1));
      if (!customers.containsKey(name)) {
        customers.put(name, new HashMap<>());
      }
      Map<String, Integer> goods = customers.get(name); // получили базу покупок пользователя
      if (!goods.containsKey(good)) {
        goods.put(good, 0);
      }
      goods.put(good, goods.get(good) + quantity);
    }
    scanner.close();

    FileWriter fileWriter = new FileWriter(new File("res/out.txt"));
    for (String name : customers.keySet()) {
      fileWriter.write(name + ":\n");
      Map<String, Integer> goods = customers.get(name);
      for (String good : goods.keySet()) {
        fileWriter.write(good + " " + goods.get(good) + "\n");
      }
    }
    fileWriter.close();
  }
}
