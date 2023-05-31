package homework_43;

import java.util.ArrayList;
import java.util.List;

public class Main {

  // Используйте класс `Book` (книга) из предыдущего домашнего задания.
  //
  // Создайте компаратор, который позволит сортировать книги по названию,
  // при одинаковых названиях - по автору (и там, и там - по алфавиту)
  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Пушкин", "Собрание сочинений", 527));
    books.add(new Book("Пушкин", "Руслан и Людмила", 350));
    books.add(new Book("Лермонтов", "Собрание сочинений", 435));
    System.out.println(books);

    books.sort(new BookTitleAuthorComparator());
    System.out.println(books);
  }
}
