import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework30Task2MonthsEnum {

  private static final String SEP = ",";

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
  public static void main(String[] args) throws FileNotFoundException {
    Map<Month, Integer> daysPerMonth = new HashMap<>();
    Scanner fileScanner = new Scanner(new File("res/months.csv"));
    while (fileScanner.hasNext()) {
      String line = fileScanner.nextLine();
      int sepIndex = line.indexOf(SEP);
      if (sepIndex != -1) {
        String monthStr = line.substring(0, sepIndex);
        String daysStr = line.substring(sepIndex + 1);
        Month month = Month.valueOf(monthStr);
        int days = Integer.parseInt(daysStr);
        daysPerMonth.put(month, days);
      }
    }
    fileScanner.close();

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
