package homework_45;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class PersonTests {

  private static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

  @Test
  public void testConstructor() throws ParseException {
    // arrange - задание начальных значений
    String name = "Test";
    String birthdateStr = "25.04.2023";
    Date birthdate = formatter.parse(birthdateStr);
    // arrange & act - задание начальных значений и совершение действия
    Person person = new Person(name, birthdateStr);

    // assert - предположение, что результат верен
    assertEquals(name, person.getName());
    assertEquals(birthdate, person.getBirthdate());
  }

  @Test
  public void testNotEqual() throws ParseException {
    // arrange
    Person person1 = new Person("Test", "25.04.2023");
    Person person2 = new Person("Test", "24.03.2022");

    // act
    int result12 = person1.compareTo(person2);
    int result21 = person2.compareTo(person1);

    // assert
    assertTrue(result12 < 0); // person1 < person2
    assertTrue(result21 > 0); // person2 > person1
  }

  @Test
  public void testEqual() throws ParseException {
    // arrange
    Person person1 = new Person("Test", "25.04.2023");
    Person person2 = new Person("Test", "25.04.2023");

    // act
    int result11 = person1.compareTo(person1);
    int result12 = person1.compareTo(person2);
    int result21 = person2.compareTo(person1);

    // assert
    assertEquals(0, result11); // person1 == person1
    assertEquals(0, result12); // person1 == person2
    assertEquals(0, result21); // person2 == person1
  }
}
