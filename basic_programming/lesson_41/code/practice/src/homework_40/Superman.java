package homework_40;

public class Superman extends Human implements CanFly {

  @Override // CanFly.fly()
  public void fly() {
    System.out.println("Супермен летит");
  }

  @Override // Human.run()
  public void run() {
    System.out.println("Супермен бежит");
  }

  @Override // Human.swim()
  public void swim() {
    System.out.println("Супермен плывёт");
  }
}
