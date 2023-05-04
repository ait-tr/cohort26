public class Dog extends Pet {

  public Dog(String name) {
    super(name);
  }

  public void makeSound() {
    System.out.println("Собака по кличке " + getName() + " говорит: гав-гав");
  }

  public void catchTail() {
    System.out.println("Собака по кличке " + getName() + " пытается поймать свой хвост");
  }
}
