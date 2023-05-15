import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3Students {

  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student("Николай", 25));
    students.add(new Student("Виктория", 45));
    students.add(new Student("Виктория", 5));
    students.add(new Student("Антон", 25));
    students.add(new Student("Борис", 15));

    System.out.println(students);
    Collections.sort(students);
    System.out.println(students);
  }
}
