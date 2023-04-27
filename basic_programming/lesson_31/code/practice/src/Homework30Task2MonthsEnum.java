import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework30Task2MonthsEnum {

  // enum - перечисляемый класс
  // enum нужен нам, если ещё до начала работы программы мы точно знаем список всех
  // возможных значений
  // private enum Название - описание перечисляемого класса (enumeration - перечисление)
  // название пишем с заглавной буквы (как название класса / файла) в единственном числе.
  // Все значения перечисляются по одному в строке через запятую,
  // пишутся ЗАГЛАВНЫМИ_БУКВАМИ и могут быть любыми (но важно, что разными);
  // порядок значений важен - Java его запоминает и использует.
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
    // 0 -> 1, 1 -> 2, ..., 11 -> 12 % 12 = 0
    int nextMonthIndex = (monthKey.ordinal() + 1) % Month.values().length;
    Month nextMonth = Month.values()[nextMonthIndex];
    System.out.println(
        "The next month " + nextMonth + " has " + daysPerMonth.get(nextMonth) + " days");
    System.out.println();

    System.out.print("Enter the month number: ");
    int monthNumber = scanner.nextInt(); // порядковый номер месяца
    // enum.valueOf("ЗНАЧЕНИЕ") либо вернёт нам соответствующее значение по его названию,
    // либо выбросит исключение IllegalArgumentException
    int monthIndex = monthNumber - 1; // индекс месяца в перечислении
    monthKey = Month.values()[monthIndex]; // месяц "как ключ словаря"
    // при выводе вызовется enum.toString(), который выдаст название значения в виде строки
    System.out.println(monthKey + " has " + daysPerMonth.get(monthKey) + " days");
    System.out.println();

    System.out.println("=== Перебор через Month.values() ===");
    // enum.values() - это массив всех значений в порядке их описания
    // Month.values() вернёт нам Month[]
    for (Month key : Month.values()) {
      // перебираем ключи, по каждому ключу получаем значение через get
      // при выводе enum превращается в строку - название значения
      System.out.println(key + ": " + daysPerMonth.get(key));
    }
  }
}
