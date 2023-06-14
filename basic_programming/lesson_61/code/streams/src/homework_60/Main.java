package homework_60;

import java.util.ArrayList;
import java.util.Comparator;
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
    // решение с лямбда-функцией:
    books.sort((o1, o2) -> {
      int titleComp = o1.getTitle().compareTo(o2.getTitle());
      if (titleComp != 0) {
        return titleComp;
      }
      return o1.getAuthor().compareTo(o2.getAuthor());
    });

    // очень хороший пример решения, изучить документацию самостоятельно:
//    books.sort(Comparator.comparing(Book::getTitle).thenComparing(Book::getAuthor));
    // Comparison key - ключ для сравнения - что-то, что уже можно сравнивать.
    // Например, для книг (не Comparable), таким ключом могут быть названия (String, Comparable).

    // плохой пример такого же сравнения, не делайте так:
//    books.sort(
//        (o1, o2) -> o1.getTitle().equals(o2.getTitle()) ? o1.getAuthor().compareTo(o2.getAuthor())
//            : o1.getTitle().compareTo(o2.getTitle()));
    System.out.println("После сортировки:");
    for (Book book : books) {
      System.out.println(book);
    }
  }
}
