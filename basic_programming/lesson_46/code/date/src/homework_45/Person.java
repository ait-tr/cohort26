package homework_45;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person> {

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

  @Override
  public int compareTo(Person o) {
    // Подсказка: не обязательно вычислять возраст, этому мы так и не научились.
    // Но можно сравнивать даты рождения!
    // birthdate.compareTo(o.birthdate) - в порядке возрастания дат
    // в порядке "от младшего к старшему" - в порядке убывания дат
//    return -(birthdate.compareTo(o.birthdate));

    // Альтернативная подсказка: если очень хочется вычислять возраст, то можно это делать
    // в миллисекундах с использованием `getTime()`!
    Date current = new Date();
    long age = current.getTime() - birthdate.getTime();
    long oAge = current.getTime() - o.birthdate.getTime();
//    return (int) Math.signum(age - oAge); // Math.signum() - знак числа (-1.0, 0.0 или +1.0)
    return Long.compare(age, oAge);
  }
}
