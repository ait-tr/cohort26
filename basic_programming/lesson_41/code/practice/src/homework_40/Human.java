package homework_40;

public class Human implements CanRun, CanSwim {

  @Override // CanRun.run()
  public void run() {
    System.out.println("Человек бежит");
  }

  @Override // CanSwim.swim()
  public void swim() {
    System.out.println("Человек плывёт");
  }
}
