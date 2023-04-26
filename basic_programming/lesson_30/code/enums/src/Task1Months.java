import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1Months {

  // по введённому названию месяца вывести количество дней
  // - switch (не будем)
  // - Map
  public static void main(String[] args) {
    Map<String, Integer> daysPerMonth = new HashMap<>();
    daysPerMonth.put("january", 31);
    daysPerMonth.put("february", 28); // год не високосный
    daysPerMonth.put("march", 31);
    daysPerMonth.put("april", 30);
    daysPerMonth.put("may", 31);
    daysPerMonth.put("june", 30);
    daysPerMonth.put("july", 31);
    daysPerMonth.put("august", 31);
    daysPerMonth.put("september", 30);
    daysPerMonth.put("october", 31);
    daysPerMonth.put("november", 30);
    daysPerMonth.put("december", 31);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the month: ");
    String month = scanner.next(); // месяц "как ввели"
    String monthKey = month.toLowerCase(); // месяц "как ключ словаря"
    if (daysPerMonth.containsKey(monthKey)) {
      System.out.println(month + " has " + daysPerMonth.get(monthKey) + " days");
    } else {
      System.out.println("We know nothing about " + month);
    }
    System.out.println();

    System.out.println("=== Перебор через keySet() ===");
    for (String key : daysPerMonth.keySet()) {
      // перебираем ключи, по каждому ключу получаем значение через get
      System.out.println(key + ": " + daysPerMonth.get(key));
    }
    System.out.println();

    // entry - англ. запись
    System.out.println("=== Перебор через entrySet() ===");
    for (Map.Entry<String, Integer> entry : daysPerMonth.entrySet()) {
      // перебираем пары, у каждой пары уже есть и ключ, и значение
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
