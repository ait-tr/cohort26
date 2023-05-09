import equality.Student;
import java.util.Scanner;

public class Task3Equality {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите имя первого студента: ");
    String firstStudentName = scanner.next();
    scanner.nextLine(); // пропустить остаток строки
    System.out.print("Введите имя второго студента: ");
    String secondStudentName = scanner.next();
    scanner.nextLine(); // пропустить остаток строки

    Student first = new Student(firstStudentName);
    Student second = new Student(secondStudentName);

    System.out.println("Первый студент: " + first);
    System.out.println("Второй студент: " + second);
    if (first.equals(second)) {
      System.out.println("Они совпадают");
    } else {
      System.out.println("Они не совпадают");
    }
    // так технически возможно, но никогда не делайте:
//    System.out.println("Они " + (!first.equals(second) ? "не " : "") + "совпадают");
  }
}
