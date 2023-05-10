package drinks;

public abstract class Drink {

  private final String title;

  public Drink(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }
}
