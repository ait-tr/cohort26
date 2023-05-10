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
}
