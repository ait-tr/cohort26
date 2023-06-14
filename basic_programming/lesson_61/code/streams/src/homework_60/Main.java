package homework_60;

import java.util.ArrayList;
import java.util.List;

public class Main {

  // Используйте класс `Book` (книга) из домашнего задания к уроку 43.
  //
  // Создайте список книг и отсортируйте книги по названию, (при одинаковых названиях - по автору)
  // при помощи лямбда-функции на месте компаратора.
  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Букварь", "Неизвестен", 123));
    books.add(new Book("Синяя", "Неизвестен", 125));
    books.add(new Book("Букварь", "Известен", 120));
    books.add(new Book("Вторая", "Неизвестен", 124));
    System.out.println("До сортировки:");
    for (Book book : books) {
      System.out.println(book);
    }
    // TODO сортировка
    System.out.println("После сортировки:");
    for (Book book : books) {
      System.out.println(book);
    }
  }
}
