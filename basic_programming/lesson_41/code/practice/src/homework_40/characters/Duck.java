package homework_40.characters;

import homework_40.interfaces.CanFly;
import homework_40.interfaces.CanRun;
import homework_40.interfaces.CanSwim;

public class Duck implements CanFly, CanRun, CanSwim {

  @Override
  public void fly() {
    System.out.println("Утка летит");
  }

  @Override
  public void run() {
    System.out.println("Утка бежит");
  }

  @Override
  public void swim() {
    System.out.println("Утка плывёт");
  }
}
