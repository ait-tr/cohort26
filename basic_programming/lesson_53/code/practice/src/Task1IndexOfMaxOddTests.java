import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Task1IndexOfMaxOddTests {

  @Test
  public void testEmptyList() {
    // arrange
    List<Integer> numbers = new ArrayList<>();

    // act
    int result = Task1IndexOfMaxOdd.indexOfMaxOdd(numbers);

    // assert
    assertEquals(-1, result);
  }

  @Test
  public void testOddList() {
    // arrange
    List<Integer> numbers = new ArrayList<>();
    numbers.add(3); // 0
    numbers.add(5); // 1 - max
    numbers.add(1); // 2

    // act
    int result = Task1IndexOfMaxOdd.indexOfMaxOdd(numbers);

    // assert
    assertEquals(1, result);
  }

  @Test
  public void testEvenList() {
    // arrange
    List<Integer> numbers = new ArrayList<>();
    numbers.add(4); // 0
    numbers.add(6); // 1
    numbers.add(2); // 2

    // act
    int result = Task1IndexOfMaxOdd.indexOfMaxOdd(numbers);

    // assert
    assertEquals(-1, result);
  }

  @Test
  public void testNegativeList() {
    // arrange
    List<Integer> numbers = new ArrayList<>();
    numbers.add(-3); // 0
    numbers.add(-5); // 1
    numbers.add(-1); // 2 - max odd

    // act
    int result = Task1IndexOfMaxOdd.indexOfMaxOdd(numbers);

    // assert
    assertEquals(2, result);
  }

  @Test
  public void testMixedList() {
    // arrange
    List<Integer> numbers = new ArrayList<>();
    numbers.add(2); // 0
    numbers.add(-3); // 1
    numbers.add(4); // 2
    numbers.add(5); // 3 - max odd
    numbers.add(-1); // 4
    numbers.add(-6); // 5

    // act
    int result = Task1IndexOfMaxOdd.indexOfMaxOdd(numbers);

    // assert
    assertEquals(3, result);
  }

  @Test
  public void testOddSortedList() {
    // arrange
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1); // 0
    numbers.add(3); // 1
    numbers.add(5); // 2 - max

    // act
    int result = Task1IndexOfMaxOdd.indexOfMaxOdd(numbers);

    // assert
    assertEquals(2, result);
  }

  @Test
  public void testOddSortedReversedList() {
    // arrange
    List<Integer> numbers = new ArrayList<>();
    numbers.add(5); // 0 - max
    numbers.add(3); // 1
    numbers.add(1); // 2

    // act
    int result = Task1IndexOfMaxOdd.indexOfMaxOdd(numbers);

    // assert
    assertEquals(0, result);
  }
}
