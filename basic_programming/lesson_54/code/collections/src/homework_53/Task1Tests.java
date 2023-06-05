package homework_53;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Task1Tests {

  @Test
  public void emptyList() {
    List<Integer> heights = new ArrayList<>();
    int pete = 162;

    int result = Task1.findPos(heights, pete);

    assertEquals(1, result);
  }

  @Test
  public void newHeight() {
    List<Integer> heights = Arrays.asList(165, 163, 160, 160, 157, 157, 155, 154);
    int pete = 162;

    int result = Task1.findPos(heights, pete);

    assertEquals(3, result);
  }

  @Test
  public void existingHeight() {
    List<Integer> heights = Arrays.asList(165, 163, 162, 162, 160, 160, 157, 157, 155, 154);
    int pete = 162;

    int result = Task1.findPos(heights, pete);

    assertEquals(5, result);
  }

  @Test
  public void similarHeight() {
    List<Integer> heights = Arrays.asList(162, 162, 162, 162);
    int pete = 162;

    int result = Task1.findPos(heights, pete);

    assertEquals(5, result);
  }

  @Test
  public void firstPosition() {
    List<Integer> heights = Arrays.asList(161, 160, 159, 158);
    int pete = 162;

    int result = Task1.findPos(heights, pete);

    assertEquals(1, result);
  }

  @Test
  public void lastExistingPosition() {
    List<Integer> heights = Arrays.asList(165, 164, 163, 162);
    int pete = 162;

    int result = Task1.findPos(heights, pete);

    assertEquals(5, result);
  }

  @Test
  public void lastPosition() {
    List<Integer> heights = Arrays.asList(165, 164, 163);
    int pete = 162;

    int result = Task1.findPos(heights, pete);

    assertEquals(4, result);
  }
}
