package homework_40.characters;

import homework_40.interfaces.CanRun;
import homework_40.interfaces.CanSwim;

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
