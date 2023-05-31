package drinks;

public abstract class Drink {

  private final String title;

  public Drink(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public abstract void drink(); // обещаем, что у не-абстрактных наследников будет метод drink,
  // но не знаем, какой
  // слово abstract в описании метода заменяет тело метода - можно сразу ставить `;` и не писать
  // фигурные скобки
  // Если в классе есть абстрактный метод, то класс обязан быть абстрактным

  // Итог: если вы видите слово abstract, это означает, что вы видите какое-то обещание "на будущее"
  // Абстрактные классы и методы НЕЛЬЗЯ использовать сами по себе,
  // но можно (и нужно) сделать наследников классам и перезаписать методы, после чего эти новые
  // не-абстрактные дочерние версии можно использовать.
}