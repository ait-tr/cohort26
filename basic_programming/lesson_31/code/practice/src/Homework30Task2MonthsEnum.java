import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework30Task2MonthsEnum {

  private enum Month {
    JANUARY, // 0
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER,
  }

  // Усовершенствуйте программу `Task2MonthsEnums` так, чтобы число дней в месяце
  // читалось из файла `res/months.csv`
  // и сохранялось в `Map<Month, Integer>`.
  public static void main(String[] args) {
    Map<Month, Integer> daysPerMonth = new HashMap<>();
    daysPerMonth.put(Month.JANUARY, 31);
    daysPerMonth.put(Month.FEBRUARY, 28); // год не високосный
    daysPerMonth.put(Month.MARCH, 31);
    daysPerMonth.put(Month.APRIL, 30);
    daysPerMonth.put(Month.MAY, 31);
    daysPerMonth.put(Month.JUNE, 30);
    daysPerMonth.put(Month.JULY, 31);
    daysPerMonth.put(Month.AUGUST, 31);
    daysPerMonth.put(Month.SEPTEMBER, 30);
    daysPerMonth.put(Month.OCTOBER, 31);
    daysPerMonth.put(Month.NOVEMBER, 30);
    daysPerMonth.put(Month.DECEMBER, 31);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the month: ");
    String month = scanner.next(); // месяц "как ввели"
    Month monthKey = Month.valueOf(month.toUpperCase()); // месяц "как ключ словаря"
    System.out.println(month + " has " + daysPerMonth.get(monthKey) + " days");
    int nextMonthIndex = (monthKey.ordinal() + 1) % Month.values().length;
    Month nextMonth = Month.values()[nextMonthIndex];
    System.out.println(
        "The next month " + nextMonth + " has " + daysPerMonth.get(nextMonth) + " days");
    System.out.println();

    System.out.print("Enter the month number: ");
    int monthNumber = scanner.nextInt(); // порядковый номер месяца
    int monthIndex = monthNumber - 1; // индекс месяца в перечислении
    monthKey = Month.values()[monthIndex]; // месяц "как ключ словаря"
    System.out.println(monthKey + " has " + daysPerMonth.get(monthKey) + " days");
    System.out.println();

    System.out.println("=== Перебор через Month.values() ===");
    for (Month key : Month.values()) {
      System.out.println(key + ": " + daysPerMonth.get(key));
    }
  }
}
