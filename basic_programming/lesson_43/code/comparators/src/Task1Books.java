import java.util.ArrayList;
import java.util.List;

public class Task1Books {

  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Пушкин", "Руслан и Людмила", 125));
    books.add(new Book("Пушкин", "Дубровский", 126));
    books.add(new Book("Лермонтов", "Мцыри", 127));
    System.out.println(books);
  }
}
