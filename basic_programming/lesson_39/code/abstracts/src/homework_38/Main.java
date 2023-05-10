package homework_38;

import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Book first = new Book("Андерсен", "Снежная королева");
    Book second = new Book("Лагерлёф", "Нильс");
    Book third = new Book("Андерсен", "Нильс");
    Book fourth = new Book("Андерсен", "Снежная королева");

    System.out.println("Сравниваем книги:");
    System.out.println(first);
    System.out.println(second);
    System.out.println(first.equals(second));
    System.out.println();

    System.out.println("Сравниваем книги:");
    System.out.println(first);
    System.out.println(third);
    System.out.println(first.equals(third)); // отличаются только названия
    System.out.println();

    System.out.println("Сравниваем книги:");
    System.out.println(second);
    System.out.println(third);
    System.out.println(second.equals(third)); // отличаются только авторы
    System.out.println();

    System.out.println("Сравниваем книги:");
    System.out.println(first);
    System.out.println(fourth);
    System.out.println(first.equals(fourth)); // всё совпадает
  }
}
