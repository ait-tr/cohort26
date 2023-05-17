package pizza;

import java.util.ArrayList;
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

//  private static final List<String> titles = new ArrayList<>();
//  static {
//    titles.add("Capricciosa");
//    titles.add("Vesuvio");
//    titles.add("Margarita");
//    titles.add("Diablo");
//  }
  // по-взрослому: Map<String, Map<Size, Double>> prices;
  private static final Map<String, Map<Size, Double>> prices = new HashMap<>();
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
  }

  private final String title;
  private final Size size;
  private final boolean cheesyBorder;

  public Pizza(String title, Size size, boolean cheesyBorder) {
    this.title = title;
    this.size = size;
    this.cheesyBorder = cheesyBorder;
  }

  // - для каждой пиццы:
  //   - выбор пиццы
  //   - выбор размера
  //   - нужен ли сырный борт
  public static Pizza readPizza(Scanner scanner) {
    return new Pizza(); // TODO
  }

  public double getPrice() {
    return prices.get(title).get(size);
    // prices.get("Capricciosa") -> capricciosaPrices
    // capricciosaPrices.get(Size.SMALL) -> 7.5
    // prices.get("Capricciosa").get(Size.SMALL) -> 7.5
  }

  @Override
  public String toString() {
    return ""; // TODO
  }
}
