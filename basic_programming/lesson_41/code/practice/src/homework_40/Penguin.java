package homework_40;

public class Penguin implements CanRun, CanSwim {

  @Override
  public void run() {
    System.out.println("Пингвин забавно бежит");
  }

  @Override
  public void swim() {
    System.out.println("Пингвин плывёт");
  }
}
