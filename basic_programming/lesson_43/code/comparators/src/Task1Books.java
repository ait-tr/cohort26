import books.Book;
import books.BookTitleComparator;
import java.util.ArrayList;
import java.util.List;

public class Task1Books {

  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Пушкин", "Руслан и Людмила", 125));
    books.add(new Book("Пушкин", "Дубровский", 126));
    books.add(new Book("Лермонтов", "Мцыри", 127));
    System.out.println(books);

    // Если мы используем компаратор для сортировки, то вместо
    // Collections.sort(List<?> list, Comparator<?> c) можно вызывать
    // list.sort(c) - в интерфейсе List есть метод sort(Comparator<?> c)
    books.sort(new BookTitleComparator());
    System.out.println(books);
  }
}
