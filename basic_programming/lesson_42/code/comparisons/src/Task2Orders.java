import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task2Orders {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите количество заказов: ");
    int ordersAmount = scanner.nextInt();
    scanner.nextLine();

    List<Order> orders = new ArrayList<>();
    for (int i = 0; i < ordersAmount; ++i) {
      orders.add(Order.readOrder());
    }

    System.out.println(Collections.max(orders));
  }
}
