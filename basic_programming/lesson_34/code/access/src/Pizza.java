public class Pizza {

  private final String name;
  // final означает, что поле нельзя менять (но можно задавать значение в конструкторе)
  // значит, оно обязано быть заданным при создании
  // значит, у него не будет сеттера

  private int price;

  public Pizza(String name, int price) {
    if (name == null || name.isEmpty()) { // условие-стражник (guardian condition)
      throw new IllegalArgumentException("Название не может быть пустым");
      // throw какаяТоОшибка - оператор "завершиться с ошибкой"
      // RuntimeException - какая-то ошибка во время выполнения
      // IllegalArgumentException - некорректный аргумент метода
      // В аргументах конструктора исключения указывается строка - сообщение об ошибке
    }
    this.name = name; // это не изменение, это задание первоначального значения - инициализация
    this.price = checkPrice(price);
  }

  // сеттера для имени не будет - final атрибуты нельзя менять
//  public void setName(String name) {
//    this.name = name;
//  }

  public void setPrice(int price) {
    this.price = checkPrice(price);
  }

  public int checkPrice(int price) {
    if (price < 0) { // условие-стражник (guardian condition)
      throw new IllegalArgumentException("Цена не может быть отрицательной");
    }
    return price; // возвращаем условие, прошедшее проверку
  }
}
