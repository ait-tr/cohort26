import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StudentTests {

  @Test
  public void constructor() {
    String name = "Test";
    int score = 42;
    Student student = new Student(name, score);

    assertEquals(name, student.getName());
    assertEquals(score, student.getScore());
  }
}
