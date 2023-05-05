import java.util.InputMismatchException;
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
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== Заправочная станция ===");
    System.out.println("Добро пожаловать! Как вас зовут?");
    String name = scanner.nextLine();

    System.out.print("Введите количество заказов: ");
    while (!scanner.hasNextInt()) {
      String wrongLine = scanner.nextLine();
      System.out.println("Неправильный формат целого числа: " + wrongLine);
      System.out.print("Введите количество заказов: ");
    }
    int orders = scanner.nextInt();

    // for (командаПередЦиклом; условиеПовторения; командаПослеШага)
    for (int counter = 0; counter < orders; ++counter) {
      System.out.println("Сколько литров топлива вам нужно?");
//    double quantity = 0.0; эта строчка была нужна, когда значение quantity присваивалось
      // в цикле или условии
      // пока всё плохо, пропустить строку
      while (!scanner.hasNextDouble()) {
        String wrongLine = scanner.nextLine();
        System.out.println("Неправильный формат дробного числа: " + wrongLine);
        System.out.println("Введите количество топлива (в литрах):");
      }
//    if (scanner.hasNextDouble()) { // если всё хорошо
      double quantity = scanner.nextDouble();
//    }
      scanner.nextLine();

      System.out.println("Как будете оплачивать, картой или наличными?");
      String paymentMethod = scanner.nextLine();
      // флажок (flag) - булева переменная, которая хранит в себе какой-то признак
      boolean byCard = paymentMethod.toLowerCase().contains("карт");

      System.out.println("=== Ваш заказ ===");
      System.out.println("Заказчик: " + name);
      System.out.println("Количество топлива: " + quantity + " л");
      double total = quantity * 2;
      System.out.println("Стоимость заказа: " + total + " EUR");
      if (byCard) {
        System.out.println("Заказ должен быть оплачен картой");
      } else {
        System.out.println("Заказ должен быть оплачен наличными");
      }
    }
  }
}
