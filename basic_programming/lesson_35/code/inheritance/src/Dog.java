public class Dog {

  private String name;

  public Dog(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void makeSound() {
    System.out.println("Собака по кличке " + name + " говорит: гав-гав");
  }

  public void catchTail() {
    System.out.println("Собака по кличке " + name + " пытается поймать свой хвост");
  }
}
