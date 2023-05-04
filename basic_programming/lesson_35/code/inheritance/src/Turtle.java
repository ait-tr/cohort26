public class Turtle {

  private String name;

  public Turtle(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void makeSound() {
    System.out.println("Черепашка по кличке " + name + " беззвучно разевает рот");
  }
}
