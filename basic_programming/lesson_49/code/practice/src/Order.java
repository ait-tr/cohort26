import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

  // Заказ:
  // - ID // число
  // - описание букета // строка (без переносов)
  // - дата доставки // ДД.ММ.ГГГГ ЧЧ:ММ
  private static final String SEP = ";";
  private static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");

  private static int counter = 0; // счётчик ОБЩИЙ для всех заказов

  private final int id;
  private String content;
  private Date dueDate;

  public Order(String content, String date) throws ParseException {
    this.id = ++counter; // сначала увеличиваем счётчик, потом его значение становится ID
    this.content = content;
    this.dueDate = formatter.parse(date);
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setDueDate(String date) throws ParseException {
    this.dueDate = formatter.parse(date);
  }

  public int getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public Date getDueDate() {
    return dueDate;
  }

  @Override
  public String toString() { // используем для вывода на экран
    return "=== Заказ # " + id + " ===\n" +
        "Описание букета: " + content + "\n" +
        "Дата доставки: " + formatter.format(dueDate) + "\n";
  }

  public String toCsvString() { // используем для записи в файл
    return id + SEP + content + SEP + formatter.format(dueDate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
//    // объект instanceof Класс - относится ли объект к этому классу, можно ли преобразовать
//    if (!(obj instanceof Order)) {
//      return false; // если преобразовать нельзя, то объекты не равны
//    }
//    // если мы попали сюда, то преобразовать можно
//    Order other = (Order) obj;
    if (!(obj instanceof Order other)) { // одновременно и проверка, и преобразование
      return false;
    }
    return this.id == other.id;
  }

  @Override
  public int hashCode() {
    return this.id;
  }
}
