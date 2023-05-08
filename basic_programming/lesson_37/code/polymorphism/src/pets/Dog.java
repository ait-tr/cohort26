package pets;

public class Dog extends Pet {

  public Dog(String name) {
    super(name);
    setType("Собака");
  }

  @Override
  public void makeNoise() {
    System.out.println(getName() + ": гав!");
  }
}
