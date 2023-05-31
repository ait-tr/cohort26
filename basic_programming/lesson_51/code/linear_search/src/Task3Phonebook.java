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

  // такой поиск называется линейным: прямой перебор всех объектов в поисках нужного
  // работаем с данными нашего класса, n для оценки эффективности - размер списка people
  // O(n) по времени, O(1) по дополнительной памяти
  public boolean hasName(String name) {
    for (Person person : people) { // перебираем всех людей // n раз = O(1 * n) = O(n)
      if (person.getName().equals(name)) { // если имя человека из списка совпадает с нужным // O(1)
        return true; // мы его нашли, можно заканчивать
      }
    }
    // если перебрали всех и не закончили, то никого не нашли
    return false;
  }
}
