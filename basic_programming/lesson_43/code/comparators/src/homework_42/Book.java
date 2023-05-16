package homework_42;

public class Book implements Comparable<Book> {

  // Создайте класс `Book` (книга), в конструктор которого передавайте автора, название книги и
  // количество страниц.
  private final String author;
  private final String title;
  private final int pages;

  public Book(String author, String title, int pages) {
    this.author = author;
    this.title = title;
    this.pages = pages;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public int getPages() {
    return pages;
  }

  @Override
  public String toString() {
    return "Book{author='" + author + "', title='" + title + "', pages=" + pages + "}";
  }

  // Реализуйте интерфейс для сравнения книг: они должны сортироваться по авторам,
  // а если авторы совпадают - по названиям (и там, и там - по алфавиту, "в словарном порядке").

  /**
   * Сравнивает книги по автору (в лексикографическом порядке), а при одинаковых авторах - по
   * названию (без учёта регистра)
   *
   * @param o the object to be compared.
   * @return отрицательное число, если книга расположена раньше в упорядоченном списке, 0 для
   * одинаковых книг и положительное число, если книга расположена позже в упорядоченном списке
   */
  @Override
  public int compareTo(Book o) {
    String author1 = this.author.toLowerCase();
    String author2 = o.author.toLowerCase();
    if (!author1.equals(author2)) { // если авторы не одинаковы
      return author1.compareTo(author2); // сравнение авторов в алфавитном порядке
    }
    // сюда попали, только если авторы одинаковы
    // сравнение названий в алфавитном порядке
    return title.toLowerCase().compareTo(o.title.toLowerCase());
  }
}
