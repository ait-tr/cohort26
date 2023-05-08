package homework_36;

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

    int orders = readOrdersAmount(scanner);

    // for (командаПередЦиклом; условиеПовторения; командаПослеШага)
    for (int counter = 0; counter < orders; ++counter) {
      Order order = Order.readOrder(name, scanner);
      order.print();
    }
  }

  private static int readOrdersAmount(Scanner scanner) {
    System.out.print("Введите количество заказов: ");
    while (!scanner.hasNextInt()) {
      String wrongLine = scanner.nextLine();
      System.out.println("Неправильный формат целого числа: " + wrongLine);
      System.out.print("Введите количество заказов: ");
    }
    int orders = scanner.nextInt();
    scanner.nextLine(); // пропустить остаток строки, из которой мы прочитали число
    // сканер не закрываем - мы продолжим им пользоваться, не мы создавали, не нам закрывать
    return orders;
  }
}
