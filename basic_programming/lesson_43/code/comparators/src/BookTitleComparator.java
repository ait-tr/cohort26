import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {

  // Метод compare() в компараторе работает по той же логике, что и compareTo в самом классе,
  // но сравнивает не this и other, а `o1` и `o2`.
  // Отличие: не "естественная" сортировка, а "искусственная", заданная именно этим компаратором.
  // Компаратор выполняет роль инструмента для сравнения - например, аптечных весов
  @Override
  public int compare(Book o1, Book o2) {
    String title1 = o1.getTitle().toLowerCase();
    String title2 = o2.getTitle().toLowerCase();
    return title1.compareTo(title2);
  }
}
