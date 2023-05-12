package homework_40.characters;

import homework_40.interfaces.CanFly;

public class Plane implements CanFly {

  @Override
  public void fly() {
    System.out.println("Самолёт летит");
  }
}
