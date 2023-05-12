package homework_40.characters;

import homework_40.interfaces.CanRun;
import homework_40.interfaces.CanSwim;

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
