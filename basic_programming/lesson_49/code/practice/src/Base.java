import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Base {

  // Будет общая база (система учёта), в которой заказы будут храниться в Map<Integer, Order>
  // Заказы могут удаляться, а ID при этом меняться не будут. Нумерация будет "разреженной" 1, 2, 7
  private final Map<Integer, Order> orders = new HashMap<>();

  // Внутренняя система учёта заказов в цветочном магазине.
  // Функционал:
  // - добавить заказ
  // - изменить заказ
  // - удалить заказ
  public void add() {
    Scanner scanner = new Scanner(System.in);

    Order order = null;
    System.out.print("Введите описание букета: ");
    String content = scanner.nextLine();
    do {
      try {
        System.out.print("Введите дату (в формате 'dd.MM.yyyy HH:mm': ");
        String date = scanner.nextLine();
        order = new Order(content, date);
      } catch (ParseException e) {
        System.out.println("Некорректный формат даты: " + e.getMessage());
      }
    } while (order == null);

    orders.put(order.getId(), order);
  }
}
