import homework_60.Book;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Task3Books {

  public static void main(String[] args) {
    List<String> titles = List.of("Букварь", "Вторая", "Синяя");
    List<Book> books = titles.stream()
        .map(s -> new Book(s, "Неизвестен", s.length() * 11))
        .toList();
    System.out.println(titles);
    System.out.println(books);
    IntSummaryStatistics stats = books.stream()
        .mapToInt(Book::getPages)
        .summaryStatistics();
    System.out.println(stats);
    stats.accept(44);
    System.out.println(stats);
  }
}
