package pets;

public class Monkey extends Pet {

  public Monkey(String name) {
    super(name);
  }

  @Override
  public String toString() {
    return "Обезьяна по кличке '" + getName() + "'";
  }
}
