import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pizza.Order;

// Тестирование
// - юнит-тесты (модульные тесты) - тестируются отдельные методы - пишет разработчик
// - интеграционные тесты - тестирование взаимодействия классов или сервисов - пишет разработчик
// - функциональные тесты - тестирование сценария использования - производит тестировщик

// - нагрузочные тесты - тестирование производительности - обычно производит тестировщик

// - приёмочные тесты - тестирование заказчиком - производит клиент или product manager

// - TDD (test driven development) - сначала тесты, потом код
public class Main {

  // аппарат по продаже пиццы
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== Продажа пиццы ===");
    List<Order> orders = new ArrayList<>(); // завершённые заказы
    Order current = new Order(); // текущий заказ

    String command;
    do { // здесь начинается тело цикла - то, что мы будем повторять, пока не введут "0"
      System.out.println("Команды:");
      System.out.println("1. Добавить пиццу");
      System.out.println("2. Начать новый заказ");
      System.out.println("0. Выход");
      System.out.print("Выберите команду: ");

      command = scanner.nextLine();
      switch (command) {
        case "1" -> current.addPizza(scanner); // добавить пиццу в текущий заказ
        case "2", "0" -> {
          if (!current.isEmpty()) {
            orders.add(current); // "старый текущий" заказ отправляю в завершённые
            current = new Order(); // "текущий заказ" - теперь новый заказ
          }
        }
        default -> System.out.println("Некорректная команда: " + command);
      }
    } while (!command.equals("0"));
    // продолжить выход из программы
    System.out.println("=== Завершённые заказы ===");
    double total = 0.0;
    for (Order order : orders) {
      System.out.println(order);
      total += order.getTotal();
    }
    System.out.printf("Общий итог: %.2f EUR%n", total);
  }
}
