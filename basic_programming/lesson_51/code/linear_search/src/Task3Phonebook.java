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
//  public boolean hasName(String name) {
//    for (Person person : people) { // перебираем всех людей // n раз = O(1 * n) = O(n)
//      if (person.getName().equals(name)) { // если имя человека из списка совпадает с нужным // O(1)
//        return true; // мы его нашли, можно заканчивать
//      }
//    }
//    // если перебрали всех и не закончили, то никого не нашли
//    return false;
//  }
  public boolean hasName(String name) {
    return indexOfName(name) != -1;
    // Если мы нашли какой-то индекс, то он НЕ -1, и условие (индекс != -1) превратится в true;
    // если мы ничего не нашли, то indexOf вернул нам -1, и условие (индекс != -1) будет false;
    // мы избавились от дублирования кода: по-настоящему ищем мы теперь только в одном методе.
  }

  /**
   * Поиск записи по указанному имени
   *
   * @param name имя для поиска
   * @return индекс первой встреченной записи с указанным именем или -1, если имя не найдено
   */
  public int indexOfName(String name) {
    for (int i = 0; i < people.size(); ++i) {
//      Person person = people.get(i);
//      String personName = person.getName();
//      if (personName.equals(name)) {
//        return i;
//      }
      if (people.get(i).getName().equals(name)) {
        return i;
      }
    }
    return -1;
  }

  public int indexOfPhone(String phone) { // O(n) по времени, O(1) по дополнительной памяти
    for (int i = 0; i < people.size(); ++i) {
      if (people.get(i).getPhone().equals(phone)) {
        return i;
      }
    }
    return -1;
  }

  public boolean hasPhone(String phone) { // O(n) по времени, O(1) по дополнительной памяти
    return indexOfPhone(phone) != -1; // O(n) по времени, O(1) по дополнительной памяти
  }

  public int lastIndexOfName(String name) {
    // для поиска последнего индекса перебираем индексы с конца (people.size() - 1) к началу (0)
    for (int i = people.size() - 1; i >= 0; --i) {
      if (people.get(i).getName().equals(name)) {
        return i;
      }
    }
    return -1;
  }
}
