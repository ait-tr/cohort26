package pizza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Pizza {

  private enum Size {
    SMALL,
    MEDIUM,
    LARGE,
  }

  private static final double CHEESY = 1.5;
  //  private static final List<String> titles = new ArrayList<>();
//  static {
//    titles.add("Capricciosa");
//    titles.add("Vesuvio");
//    titles.add("Margarita");
//    titles.add("Diablo");
//  }
  // по-взрослому: Map<String, Map<Size, Double>> prices;
  private static final Map<String, Map<Size, Double>> prices = new HashMap<>();
  private static final List<String> titles;

  static {
    Map<Size, Double> capricciosaPrices = new HashMap<>();
    capricciosaPrices.put(Size.SMALL, 7.5);
    capricciosaPrices.put(Size.MEDIUM, 9.0);
    capricciosaPrices.put(Size.LARGE, 11.0);
    prices.put("Capricciosa", capricciosaPrices);

    Map<Size, Double> diabloPrices = new HashMap<>();
    diabloPrices.put(Size.SMALL, 7.0);
    diabloPrices.put(Size.MEDIUM, 9.0);
    diabloPrices.put(Size.LARGE, 10.5);
    prices.put("Diablo", diabloPrices);
//    {
//      "Capricciosa": {
//        "SMALL": 7.5,
//        "MEDIUM": 9.0,
//        "LARGE": 11.0
//      },
//      "Diablo": {
//        "SMALL": 7,
//        "MEDIUM": 9,
//        "LARGE": 10.5
//      }
//    }
    titles = new ArrayList<>(prices.keySet());
    Collections.sort(titles);
  }

  private final String title;
  private final Size size;
  private final boolean cheesyBorder;
  private final double price;

  public Pizza(String title, Size size, boolean cheesyBorder) {
    this.title = title;
    this.size = size;
    this.cheesyBorder = cheesyBorder;

    double price = prices.get(title).get(size);
    // prices.get("Capricciosa") -> capricciosaPrices
    // capricciosaPrices.get(Size.SMALL) -> 7.5
    // prices.get("Capricciosa").get(Size.SMALL) -> 7.5
    if (this.cheesyBorder) {
      price += CHEESY;
    }
    this.price = price;
  }

  // - для каждой пиццы:
  //   - выбор пиццы
  //   - выбор размера
  //   - нужен ли сырный борт
  public static Pizza readPizza(Scanner scanner) {
    System.out.println("Пиццы:");
    for (int i = 0; i < titles.size(); ++i) {
      int k = i + 1;
      String title = titles.get(i);
      System.out.println(k + ". " + title); // пронумерованный вывод содержимого списка
    }
    System.out.print("Выберите пиццу: ");
    int pizzaNumber = scanner.nextInt();
    scanner.nextLine();
    String title = titles.get(pizzaNumber - 1);

    System.out.println("Размеры:");
    for (int i = 0; i < Size.values().length; ++i) {
      int k = i + 1;
      Size size = Size.values()[i];
      System.out.println(k + ". " + size); // пронумерованный вывод содержимого массива
    }
    System.out.print("Выберите размер: ");
    int sizeNumber = scanner.nextInt();
    scanner.nextLine();
    Size size = Size.values()[sizeNumber - 1];

    System.out.print("Сделать борт сырным? [y/N]: ");
    boolean cheesyBoard = scanner.nextLine().equalsIgnoreCase("y"); // ввели "y" или "Y"

    return new Pizza(title, size, cheesyBoard);
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return String.format("%s (%s, сырный борт: %s) = %.2f EUR", title, size, cheesyBorder, price);
  }
}
