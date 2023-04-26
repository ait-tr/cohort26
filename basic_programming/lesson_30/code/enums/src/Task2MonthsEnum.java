import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2MonthsEnum {

  // enum - перечисляемый класс
  // enum нужен нам, если ещё до начала работы программы мы точно знаем список всех
  // возможных значений
  // private enum Название - описание перечисляемого класса (enumeration - перечисление)
  // название пишем с заглавной буквы (как название класса / файла) в единственном числе.
  // Все значения перечисляются по одному в строке через запятую,
  // пишутся ЗАГЛАВНЫМИ_БУКВАМИ и могут быть любыми (но важно, что разными);
  // порядок значений важен - Java его запоминает и использует.
  private enum Month {
    JANUARY,
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
    System.out.println(month + " has " + daysPerMonth.get(monthKey) + " days");
  }
}
