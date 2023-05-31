package homework_38;

public class Book {

  // Создайте класс `Book` (книга), в конструктор которого передавайте автора и название книги.
  //
  // Переопределите сравнение книг: книги должны считаться одинаковыми, если совпадают и название,
  // и автор.
  private final String author;
  private final String title;

  public Book(String author, String title) {
    this.author = author;
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    return String.format("\"%s\", - %s", title, author);
//    return "\"" + title + "\", - " + author;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true; // если второй объект -- ссылка на тот же самый объект, что и первый,
      // то остальное можно даже не сравнивать -- это буквально один и тот же объект
    }
    if (!(obj instanceof Book other)) {
      return false; // второй объект - даже не книга, объекты не равны
    }
    // книга this (эта) и книга other (Book other = (Book) obj) совпадают (считаются равными),
    // если совпадают и их авторы, и их названия
    return author.equals(other.getAuthor()) && title.equals(other.getTitle());
  }

  // Раньше разные ссылки означали разные (не равные) объекты.
  // Родительский метод Object.hashCode() показывал разные значения для разных ссылок, и всё
  // было хорошо.
  // Сейчас разные объекты (с разными ссылка) мы должны считать равными (мы переопределили equals).
  // Это значит, что вместо ускорения сравнения hashCode его ломает - для теперь одинаковых объектов
  // он всё ещё показывает разные значения.
  // Хэш-код надо перезаписать -- для "теперь равных" объектов теперь надо возвращать одинаковые
  // значения.
  @Override
  public int hashCode() {
    // одинаковые поля author и title должны приводить к одинаковому результату
    return author.hashCode() * title.hashCode();
  }
}
