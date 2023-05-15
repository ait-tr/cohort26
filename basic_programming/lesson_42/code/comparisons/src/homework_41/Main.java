package homework_41;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите количество заказов: ");
    int ordersAmount = scanner.nextInt();
    scanner.nextLine();

    List<Order> orders = new ArrayList<>();
    for (int i = 0; i < ordersAmount; ++i) {
      // так мы вызываем статический метод: Класс.метод()
//      Order order = Order.readOrder();
//      orders.add(order);
      orders.add(Order.readOrder());
    }

    System.out.println("Заказы:");
    for (Order order : orders) {
      System.out.println(order);
    }
    System.out.println("Итого: " + Order.getTotalSum(orders));
  }
}
