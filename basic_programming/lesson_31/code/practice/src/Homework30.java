import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework30 {

  // Расширьте программу `Task2MonthsEnums`.
  //
  // Добавьте ещё один `enum`, который будет описывать времена года (зима, лето, весна, осень).
  //
  // Для введённого пользователем месяца напишите, к какому именно времени года относится
  // выбранный месяц.
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

  private enum Season { // в единственном числе, без -s!
    WINTER,
    SPRING,
    SUMMER,
    FALL, // AUTUMN
  }

  private static Season getSeason(Month month) {
    return switch (month) {
      case DECEMBER, JANUARY, FEBRUARY -> Season.WINTER;
      case MARCH, APRIL, MAY -> Season.SPRING;
      case JUNE, JULY, AUGUST -> Season.SUMMER;
      case SEPTEMBER, OCTOBER, NOVEMBER -> Season.FALL;
    };
  }

  private static Season getSeasonFromMap(Month month) {
    Map<Month, Season> seasonPerMonth = new HashMap<>();
    seasonPerMonth.put(Month.JANUARY, Season.WINTER);
    seasonPerMonth.put(Month.FEBRUARY, Season.WINTER);
    seasonPerMonth.put(Month.MARCH, Season.SPRING);
    seasonPerMonth.put(Month.APRIL, Season.SPRING);
    seasonPerMonth.put(Month.MAY, Season.SPRING);
    seasonPerMonth.put(Month.JUNE, Season.SUMMER);
    seasonPerMonth.put(Month.JULY, Season.SUMMER);
    seasonPerMonth.put(Month.AUGUST, Season.SUMMER);
    seasonPerMonth.put(Month.SEPTEMBER, Season.FALL);
    seasonPerMonth.put(Month.OCTOBER, Season.FALL);
    seasonPerMonth.put(Month.NOVEMBER, Season.FALL);
    seasonPerMonth.put(Month.DECEMBER, Season.WINTER);

    return seasonPerMonth.get(month);
  }

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
    String month = scanner.next(); // месяц "как ввели (как строка)"
    Month monthKey = Month.valueOf(month.toUpperCase()); // месяц "как enum"
    System.out.println(month + " has " + daysPerMonth.get(monthKey) + " days.");
    System.out.println(month + " is a part of the " + getSeason(monthKey) + " season.");
    System.out.println(month + " is a part of the " + getSeasonFromMap(monthKey) + " season.");
  }
}
