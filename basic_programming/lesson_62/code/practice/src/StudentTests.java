import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class StudentTests {

  private static final String NAME = "Test";
  private static final int SCORE = 42;
  private static final char SEP = ';';

  @Test
  public void testCreation() {
    Student student = new Student(NAME, SCORE);
    assertEquals(NAME, student.getName());
    assertEquals(SCORE, student.getScore());

    String newName = "Test2";
    student.setName(newName);
    assertEquals(newName, student.getName());

    int newScore = SCORE * 2;
    student.setScore(newScore);
    assertEquals(newScore, student.getScore());
  }

  @Test
  public void testToString() {
    Student student = new Student(NAME, SCORE);

    String expected = NAME + " (score: " + SCORE + ")";
    String actual = student.toString(); // вызываем метод, который проверяем

    assertEquals(expected, actual);
  }

  @Test
  public void testToCsvString() {
    Student student = new Student(NAME, SCORE);

    String expected = NAME + SEP + SCORE + '\n';
    String actual = student.toCsvString(SEP);

    assertEquals(expected, actual);
  }

  @Test
  public void testParseFromCsv() {
    String source = NAME + SEP + SCORE;
    Student actual = Student.parseFromCsv(source, SEP);

    assertEquals(NAME, actual.getName());
    assertEquals(SCORE, actual.getScore());
  }

  @Test
  public void testCsv() {
    Student source = new Student(NAME, SCORE);
    String csvLine = source.toCsvString(SEP);

    // сканер, в который мы передали заранее заготовленный ввод
    Scanner scanner = new Scanner(csvLine);
    String readLine = scanner.nextLine(); // scanner.nextLine() обрезает конец строки
    Student read = Student.parseFromCsv(readLine, SEP);

    assertEquals(source.getName(), read.getName());
    assertEquals(source.getScore(), read.getScore());
  }
}
