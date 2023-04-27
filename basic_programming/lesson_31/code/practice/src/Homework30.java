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
  // Для Java enum - это набор констант, идущих подряд. Все эти константы пронумерованы,
  // начиная с нуля.

  public static void main(String[] args) {
    // в программе созданный enum можно использовать, как новый класс - как новый тип переменной
    // (как int, String и т.д.)
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
    // enum.valueOf("ЗНАЧЕНИЕ") либо вернёт нам соответствующее значение по его названию,
    // либо выбросит исключение IllegalArgumentException
    Month monthKey = Month.valueOf(month.toUpperCase()); // месяц "как ключ словаря"
    // enum.ordinal() возвращает индекс значения в перечислении
    System.out.println(month + " has " + daysPerMonth.get(monthKey) + " days");
  }
}
