package homework_42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Пушкин", "Руслан и Людмила", 125));
    books.add(new Book("Пушкин", "Дубровский", 126));
    books.add(new Book("Лермонтов", "Мцыри", 127));
    System.out.println(books);
    Collections.sort(books);
    System.out.println(books);
  }
}
