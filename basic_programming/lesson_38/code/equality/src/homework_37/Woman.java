package homework_37;

public class Woman extends Human {

  public Woman(String name) {
    super(name);
  }

  @Override
  public String toString() {
    return String.format("Женщина по имени %s", getName());
  }

  @Override
  public void welcome() {
    System.out.println("Я родилась!");
  }
}
