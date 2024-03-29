import equality.Student;
import java.util.Scanner;

public class Task3Equality {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите имя первого студента: ");
    String firstStudentName = scanner.nextLine(); // прочитать всю строку
    System.out.print("Введите имя второго студента: ");
    String secondStudentName = scanner.nextLine(); // прочитать всю строку
    if (firstStudentName.equals(secondStudentName)) {
      System.out.println("Имена совпадают");
    } else {
      System.out.println("Имена не совпадают");
    }

    Student first = new Student(firstStudentName, 1);
    Student second = new Student(secondStudentName, 1);

    System.out.println("Первый студент: " + first);
    System.out.println("Второй студент: " + second);
    if (first.equals(second)) {
      System.out.println("Студенты совпадают");
    } else {
      System.out.println("Студенты не совпадают");
    }
    // так технически возможно, но никогда не делайте:
//    System.out.println("Они " + (!first.equals(second) ? "не " : "") + "совпадают");
  }
}
