package pets;

public class Dog extends Pet {

  public Dog(String name) {
    super(name);
  }

  @Override
  public void makeNoise() {
    System.out.println("Собака " + getName() + ": гав!");
  }

  @Override
  public String toString() {
    return "Собака по кличке '" + getName() + "'";
  }
}
