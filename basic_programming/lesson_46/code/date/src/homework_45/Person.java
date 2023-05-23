package homework_45;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

  // Создайте класс `Person`, которому при создании передавайте имя и дату рождения
  // в виде строки в формате "ДД.ММ.ГГГГ".
  //
  // Реализуйте в классе интерфейс `Comparable<Person>`, в котором "меньше"
  // будет значить "младше".

  private static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
  private String name;
  private Date birthdate;

  public Person(String name, String birthdate) throws ParseException {
    this.name = name;
    this.birthdate = formatter.parse(birthdate);
  }

  public String getName() {
    return name;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  @Override
  public String toString() {
    return name + " (" + formatter.format(birthdate) + ")";
  }
}
