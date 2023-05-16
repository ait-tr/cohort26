package homework_42;

public class Book {

  // Создайте класс `Book` (книга), в конструктор которого передавайте автора, название книги и
  // количество страниц.
  //
  // Реализуйте интерфейс для сравнения книг: они должны сортироваться по авторам,
  // а если авторы совпадают - по названиям (и там, и там - по алфавиту, "в словарном порядке").
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
}
