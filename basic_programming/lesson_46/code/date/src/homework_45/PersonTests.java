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
    // arrange
    String name = "Test";
    String birthdateStr = "25.04.2023";
    Date birthdate = formatter.parse(birthdateStr);
    // arrange & act
    Person person = new Person(name, birthdateStr);

    // assert
    assertEquals(name, person.getName());
    assertEquals(birthdate, person.getBirthdate());
  }
}
