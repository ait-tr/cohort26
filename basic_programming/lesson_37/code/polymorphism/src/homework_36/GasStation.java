package homework_36;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GasStation {

  // Вопросы:
  // - if
  // - for
  // - while
  // - массивы / List / Set
  // - методы
  // - классы / модификаторы доступа
  // Симулятор заправки
  // - приветствие
  // - указание количества топлива
  // - расчёт суммы

  // - добавить использование списка
  // - заменить `for` на `for-each`
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== Заправочная станция ===");

    System.out.println("Добро пожаловать! Как вас зовут?");
    String name = scanner.nextLine();

    int amount = readOrdersAmount(scanner);
//    Order[] orders = new Order[amount];
    List<Order> orders = new ArrayList<>(amount); // это не размер (size), а вместимость (capacity)
    // элементов в списке пока нет, но добавляться они будут немного быстрее, пока не
    // заполнится вместимость (быстрее будет выполняться операция add)

    // for (командаПередЦиклом; условиеПовторения; командаПослеШага)
    for (int i = 0; i < amount; ++i) {
      Order order = Order.readOrder(name, scanner);
//      orders[i] = order; // для массива
      orders.add(order); // для списка
      order.print();
    }
  }

  private static int readOrdersAmount(Scanner scanner) {
    int amount; // объявляем переменную заранее, чтобы она осталась после цикла
    do { // читаем количество заказов
      System.out.print("Введите количество заказов: ");
      while (!scanner.hasNextInt()) { // пока написано не число (подсматриваем вперёд)
        String wrongLine = scanner.nextLine(); // пропускаем ввод (там не число)
        System.out.println("Неправильный формат целого числа: " + wrongLine);
        System.out.print("Введите количество заказов: ");
      }
      amount = scanner.nextInt(); // пропустили все "не числа", теперь читаем число
      scanner.nextLine(); // пропустить остаток строки, из которой мы прочитали число
      // сканер не закрываем - мы продолжим им пользоваться, не мы создавали, не нам закрывать
      if (amount < 0) { // если только что прочитанное количество меньше нуля
        System.out.println("Количество заказов не может быть отрицательным: " + amount);
      }
    } while (amount < 0); // если количество отрицательное - читаем заново
    return amount;
  }
}
