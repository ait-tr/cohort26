import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2BookPrices {

  // String - неизменяемая, упорядоченная, только символы
  // array[] - изменяемый, упорядоченный, любые объекты, постоянный размер
  // List - изменяемый, упорядоченный, любые объекты, переменный размер
  // Set - изменяемый, НЕупорядоченный, уникальные объекты, переменный размер
  // Map - изменяемый, НЕупорядоченный, уникальные ключи, переменный размер
  public static void main(String[] args) {
    Map<Book, Integer> prices = new HashMap<>();
    prices.put(new Book("Пушкин", "Руслан и Людмила", 125), 500);
    prices.put(new Book("Пушкин", "Дубровский", 126), 550);
    prices.put(new Book("Лермонтов", "Мцыри", 127), 725);
    prices.put(new Book("Пушкин", "Дубровский", 126), 350); // перезаписал цену

    System.out.println(prices);
    List<Book> keys = new ArrayList<>(prices.keySet()); // скопировал ключи в отдельный список
    keys.sort(new BookTitleComparator()); // отсортировал этот отдельный список ключей
    for (Book book : keys) { // перебираю отдельный отсортированный список ключей
      System.out.println(book + " --> " + prices.get(book)); // для каждого ключа получаю значение
    }
  }
}
