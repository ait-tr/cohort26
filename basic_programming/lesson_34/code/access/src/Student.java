public class Student {

  private static int counter = 0; // счётчик ОБЩИЙ для всех объектов класса
  private final int id;
  private String name;

  public Student(String name) {
    id = counter++; // записываем значение "до увеличения" в качестве id
    this.name = name;
  }

  public int getId() {
    return id;
  }

  // сеттера для поля counter нет - оно служебное, его нельзя (согласно нашей идее) менять руками

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getString() {
    // counter в каждый момент времени у всех студентов одинаковый
    return String.format("%s [id: %d/%d]", name, id, counter);
  }
}
