package homework_37;

public class Human {

  // Создайте класс "Человек", конструктор которого принимает имя.
  //
  // При попытке вывести объект этого класса на экран должна выводиться строка
  // "Человек по имени ...".
  //
  // Добавьте в класс "Человек" метод "приветствие", который будет выводить строку: "Я родился!"
  private String name;

  public Human(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("Человек по имени %s", name);
  }

  public void welcome() {
    System.out.println("Я родился!");
  }

  public String getName() {
    return name;
  }
}
