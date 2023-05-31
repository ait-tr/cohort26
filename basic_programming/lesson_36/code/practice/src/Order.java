import java.util.Scanner;

public class Order {

  private static final double PRICE = 2.0;

  private enum PaymentMethod {
    CARD,
    CASH,
  }

  private String name;
  private double quantity;
  private PaymentMethod paymentMethod;

  public Order(String name, double quantity, PaymentMethod paymentMethod) {
    this.name = name;
    this.quantity = quantity;
    this.paymentMethod = paymentMethod;
  }

  // здесь могут быть геттеры и сеттеры

  // фабричный статический метод, который производит новый объект
  public static Order readOrder(String name, Scanner scanner) {
    double quantity = readFuelQuantity(scanner);

    PaymentMethod paymentMethod = readPaymentMethod(scanner);

    return new Order(name, quantity, paymentMethod);
  }

  private static double readFuelQuantity(Scanner scanner) {
    System.out.println("Сколько литров топлива вам нужно?");
//    double quantity = 0.0; эта строчка была нужна, когда значение quantity присваивалось
    // в цикле или условии
    while (!scanner.hasNextDouble()) { // пока всё плохо,
      String wrongLine = scanner.nextLine(); // пропустить строку
      System.out.println("Неправильный формат дробного числа: " + wrongLine);
      System.out.println("Введите количество топлива (в литрах):");
    }
//    if (scanner.hasNextDouble()) { // если всё хорошо
    double quantity = scanner.nextDouble();
//    }
    scanner.nextLine(); // пропустить остаток строки, из которой мы прочитали число
    // сканер не закрываем - мы продолжим им пользоваться, не мы создавали, не нам закрывать
    return quantity;
  }

  private static PaymentMethod readPaymentMethod(Scanner scanner) {
    System.out.println("Как будете оплачивать, картой или наличными?");
    String paymentMethod = scanner.nextLine();
    // флажок (flag) - булева переменная, которая хранит в себе какой-то признак
//    boolean byCard = paymentMethod.toLowerCase().contains("карт");
    if (paymentMethod.toLowerCase().contains("карт")) {
      return PaymentMethod.CARD;
    } // после `return` нет смысла ставить `else` - если условие выполнилось, мы сюда не попадём
    // сканер не закрываем - мы продолжим им пользоваться, не мы создавали, не нам закрывать
    return PaymentMethod.CASH;
  }

  public void print() {
    System.out.println("=== Ваш заказ ===");
    System.out.println("Заказчик: " + name);
    System.out.println("Количество топлива: " + quantity + " л");
    double total = quantity * PRICE;
    System.out.println("Стоимость заказа: " + total + " EUR");
//      switch (paymentMethod) {
//        case CARD:
//          System.out.println("Заказ должен быть оплачен картой");
//          break;
//        case CASH:
//          System.out.println("Заказ должен быть оплачен наличными");
//          break;
//      }
    switch (paymentMethod) {
      case CARD -> System.out.println("Заказ должен быть оплачен картой");
      case CASH -> System.out.println("Заказ должен быть оплачен наличными");
    }
  }
}
