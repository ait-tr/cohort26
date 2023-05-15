import java.util.List;
import java.util.Scanner;

public class Order implements Comparable<Order> {

  // заказ в интернет-магазине
  private final String id; // идентификатор заказа - строка с номером, датой и т.д.
  private final String content; // содержание заказа - как высказал клиент, в виде текста
  private final String client; // имя клиента
  private final String phone; // номер телефона клиента - лучше объединять такое в один класс `Client`
  private int price; // стоимость заказа

  public Order(String id, String content, String client, String phone, int price) {
    this.id = id;
    this.content = content;
    this.client = client;
    this.phone = phone;
    this.price = price;
  }

  public int getPrice() {
    return this.price;
  }

  @Override
  public String toString() {
    return "=== Заказ ===\n" +
        "ID:             " + id + "\n" +
        "Содержимое:     " + content + "\n" +
        "Клиент:         " + client + "\n" +
        "Номер телефона: " + phone + "\n" +
        "Стоимость:      " + price;
  }

  // удваивание стоимости этого заказа - не статический метод
  public void doublePrice() {
    price *= 2;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  // утраивание стоимости какого-то заказа - статический метод, а заказ передаётся в аргументе
  public static void triplePrice(Order order) {
//    order.setPrice(order.getPrice() * 3);
    // к приватным полям класса у нас есть доступ ВЕЗДЕ внутри класса, даже в статических методах:
    order.price *= 3;
  }

  // статический метод чтения заказа с клавиатуры - никакого заказа ещё нет, он не может быть
  // не статическим
  public static Order readOrder() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите ID заказа: ");
    String id = scanner.nextLine();
    System.out.print("Введите текст заказа: ");
    String content = scanner.nextLine();
    System.out.print("Введите имя заказчика: ");
    String client = scanner.nextLine();
    System.out.print("Введите номер телефона: ");
    String phone = scanner.nextLine();
    System.out.print("Введите стоимость: ");
    int price = scanner.nextInt();
    scanner.nextLine();

    // только в этот момент появится конкретный заказ
    return new Order(id, content, client, phone, price);
  }

  // Добавьте статический метод:
  // public static int getTotalSum(List<Order> orders)
  //
  // Метод будет статическим (не имеет отношения к конкретному заказу), но частью класса `Order`
  // (имеет непосредственное отношение к заказам как к общей идее).
  //
  // Метод должен возвращать общую сумму заказов из списка.
  public static int getTotalSum(List<Order> orders) {
    int total = 0;
    for (Order order : orders) {
//       total += order.getPrice();
      // к приватным полям класса у нас есть доступ ВЕЗДЕ внутри класса, даже в статических методах:
      total += order.price;
    }
    return total;
  }

  @Override
  public int compareTo(Order other) {
    // Метод compareTo появился из интерфейса Comparable<Order>.
    // Он определяет, что такое "сравнить два заказа" - какой будет считаться меньше, больше или
    // равным.
    // Если this < other: вернуть любое отрицательное число
    // Если this == other: вернуть 0
    //   (для постоянства compareTo и equals в таких ситуациях equals должен вернуть true)
    // Если this > other: вернуть любое положительное число

    // Если a < b, то результат < 0
    // Если a == b, то результат == 0
    // Если a > b, то результат > 0
    // "результат": a - b
    // a      ?  b      | -b
    // a - b  ?  b - b
    // a - b  ?  0
    // Для чисел compareTo() может просто вернуть (this - other)

    // Если мы найдём какую-то метрику (что-то, измеримое числами), то мы тоже сможем написать
    // (this - other)
//    return this.price - other.price; // для сравнения по стоимости

    // Если нам нужно сравнить просто какое-то поле, то мы можем вернуть compareTo для этого поля
    return id.compareTo(other.id); // для сравнения по конкретному полю `id`
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Order other)) {
      return false;
    }
//    return this.price == other.price; // для сравнения по стоимости
    return id.equals(other.id); // для сравнения по конкретному полю `id`
  }

  @Override
  public int hashCode() {
    // если мы нашли метрику для объекта, то в качестве хэш-кода можно её использовать
//    return price; // для сравнения по стоимости
    return id.hashCode(); // для сравнения по конкретному полю `id`
  }
}
