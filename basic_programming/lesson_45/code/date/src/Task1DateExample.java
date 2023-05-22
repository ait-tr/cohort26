import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task1DateExample {

  public static void main(String[] args) throws ParseException {
    // месяца нумеруются с нуля
    Date someDate = new Date(123, 1, 15, 19, 49, 31);
    System.out.println(someDate);
    // хранение времени: UNIX-time: количество (милли)секунд с 1 января 1970 г.
    System.out.println(someDate.getTime());

    Date maxDate = new Date(Long.MAX_VALUE); // количество миллисекунд можно передать в конструктор
    System.out.println(maxDate);

    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    System.out.println(format.format(someDate));

    Date parsedDate = format.parse("15.12.2023"); // throws ParseException
    System.out.println(parsedDate);
  }
}
