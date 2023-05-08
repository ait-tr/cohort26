package pets;

public class Pet {

  private String name;

  public Pet(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void makeNoise() {
    System.out.println(name + ": издаёт звуки");
  }

  @Override
  public String toString() {
    return "Домашнее животное по кличке '" + name + "'";
  }
}
