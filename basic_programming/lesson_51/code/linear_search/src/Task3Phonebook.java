import java.util.ArrayList;
import java.util.List;

public class Task3Phonebook {

  // Телефонная книга
  // состоит из пар "имя - телефон", и имена, и телефоны могут повторяться.
  // Нужно уметь:
  // - проверять, есть ли такое имя
  // - проверять, есть ли такой телефон

  // ничего уникального нет, Map и Set не подойдут, нужен будет List
  // у каждого элемента списка должны быть два поля - имя и телефон
  private List<Person> people = new ArrayList<>();

  public void add(String name, String phone) {
    Person person = new Person(name, phone);
    people.add(person);
  }
}
