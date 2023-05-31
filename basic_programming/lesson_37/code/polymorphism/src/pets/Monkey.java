package pets;

public class Monkey extends Pet {

  public Monkey(String name) {
    super(name);
  }

  @Override // перезаписали Pet.toString()
  public String toString() {
    return "Обезьяна по кличке '" + getName() + "'";
  }
}
