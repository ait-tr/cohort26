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

    System.out.println("Сколько литров топлива вам нужно?");
    double quantity = scanner.nextDouble();
    scanner.nextLine();

    System.out.println("Как будете оплачивать, картой или наличными?");
    String paymentMethod = scanner.nextLine();

    System.out.println("=== Ваш заказ ===");
    System.out.println("Заказчик: " + name);
    System.out.println("Количество топлива: " + quantity + " л");
    double total = quantity * 2;
    System.out.println("Стоимость заказа: " + total + " EUR");
    if (paymentMethod.toLowerCase().contains("карт")) {
      System.out.println("Заказ должен быть оплачен картой");
    } else {
      System.out.println("Заказ должен быть оплачен наличными");
    }
  }
}
