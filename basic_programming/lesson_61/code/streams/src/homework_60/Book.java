package homework_60;

public class Book {

  // Создайте класс `Book` (книга), в конструктор которого передавайте автора, название книги и
  // количество страниц.
  private final String title;
  private final String author;
  private final int pages;

  public Book(String title, String author, int pages) {
    this.title = title;
    this.author = author;
    this.pages = pages;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getPages() {
    return pages;
  }

  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", pages=" + pages +
        '}';
  }
}
