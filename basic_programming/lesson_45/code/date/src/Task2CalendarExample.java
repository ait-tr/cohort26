import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task2CalendarExample {

  public static void main(String[] args) throws ParseException {
    Calendar calendar = new GregorianCalendar();
    Date date = calendar.getTime();
    System.out.println(date);

    Calendar calendar2 = new GregorianCalendar(2023, Calendar.MAY, 22);
    calendar2.set(Calendar.HOUR, 10);
    System.out.println(calendar2.getTime());

    calendar2.add(Calendar.DATE, 1);
    System.out.println(calendar2.getTime());

    calendar2.add(Calendar.DATE, -31);
    System.out.println(calendar2.getTime());

    calendar2.add(Calendar.HOUR, 30);
    System.out.println(calendar2.getTime());

    String dateStr = "05/22/2023";
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    Date readDate = formatter.parse(dateStr); // throws ParseException
    Calendar readCalendar = new GregorianCalendar();
    readCalendar.setTime(readDate); // Calendar.setTime(Date)

    // Date - для хранения моментов времени и вывода на экран. Изменение напрямую "устарело".
    // SimpleDateFormat - для парсинга (чтения) и вывода дат в разных форматах.
    //   Взаимодействует с Date.
    // Calendar - для хранения и изменения моментов времени. Оболочка (обёртка) над Date, при этом
    //   для хранения дат всё ещё лучше использовать Date.
    calendar.setTime(date);
    calendar.get(Calendar.DATE);
    System.out.println();
  }
}
