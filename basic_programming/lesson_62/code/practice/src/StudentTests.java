import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StudentTests {

  @Test
  public void testCreation() {
    String name = "Test";
    int score = 42;
    Student student = new Student(name, score);
    assertEquals(name, student.getName());
    assertEquals(score, student.getScore());

    name = "Test2";
    student.setName(name);
    assertEquals(name, student.getName());

    score *= 2;
    student.setScore(score);
    assertEquals(score, student.getScore());
  }

  @Test
  public void testToString() {
    String name = "Test";
    int score = 42;
    Student student = new Student(name, score);

    String expected = name + " (score: " + score + ")";
    String actual = student.toString(); // вызываем метод, который проверяем

    assertEquals(expected, actual);
  }

  @Test
  public void testToCsvString() {
    String name = "Test";
    int score = 42;
    Student student = new Student(name, score);

    char sep = ';';
    String expected = name + sep + score + '\n';
    String actual = student.toCsvString(sep);

    assertEquals(expected, actual);
  }
}
