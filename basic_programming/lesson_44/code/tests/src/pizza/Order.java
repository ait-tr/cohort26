package pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

  // - номер заказа
  private static int ordersAmount = 0; // счётчик созданных заказов
  private final int number;
  private final List<Pizza> pizzas = new ArrayList<>();

  public Order() {
    number = ++ordersAmount;
  }

  public void addPizza(Scanner scanner) {
    pizzas.add(Pizza.readPizza(scanner));
  }

  public boolean isEmpty() {
    return pizzas.isEmpty();
  }

  // итоговая стоимость
  public double getTotal() {
    double result = 0.0;
    for (Pizza pizza : pizzas) {
      result += pizza.getPrice();
    }
    return result;
  }

  @Override
  public String toString() {
    String result =  "=== Заказ № " + number + " ===\n";
    double total = 0.0;
//    pizzas.sort(new PizzaComparator()); // TODO
    for (int i = 0; i < pizzas.size(); ++i) {
      int pizzaNumber = i + 1;
      Pizza pizza = pizzas.get(i);
      result += pizzaNumber + ". " + pizza + "\n";
      total += pizza.getPrice();
//      result += (i + 1) + ". " + pizzas.get(i) + "\n";
//      result += String.format("%d. %s%n", i + 1, pizzas.get(i));
    }
    result += String.format("Итого: %.2f EUR%n", total);
    return result;
  }

  public int getNumber() {
    return number;
  }
}
