public class Pizza {

  private final String name;
  // final означает, что поле нельзя менять (но можно задавать значение в конструкторе)
  // значит, оно обязано быть заданным при создании
  // значит, у него не будет сеттера

  private int price;

  public Pizza(String name, int price) {
    this.name = name; // это не изменение, это задание первоначального значения - инициализация
    if (price < 0) { // условие-стражник (guardian condition)
      throw new IllegalArgumentException("Цена не может быть отрицательной");
    }
    this.price = price;
  }

  // сеттера для имени не будет - final атрибуты нельзя менять
//  public void setName(String name) {
//    this.name = name;
//  }

  public void setPrice(int price) {
    if (price < 0) { // условие-стражник (guardian condition)
      throw new IllegalArgumentException("Цена не может быть отрицательной");
    }
    this.price = price;
  }
}
