package homework_40;

import homework_40.characters.*;
import homework_40.interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

  // Напишите интерфейсы "Умеет летать" `CanFly` с методом `fly()`,
  // "Умеет бегать" `CanRun` с методом `run` и
  // "умеет плавать" `CanSwim` с методом `swim`
  // и реализуйте их в классе "Супермен" `Superman`.

  // Реализуйте **соответствующие** интерфейсы из предыдущей задачи в классах
  // "Человек", "Утка", "Пингвин" и "Самолёт".
  public static void main(String[] args) {
    // есть переменная (ссылка или число)
    // есть объект (где-то в памяти)
    Superman clarkKent = new Superman();
    Human kirill = new Human();
    Duck donald = new Duck();
    Penguin skipper = new Penguin();
    Plane dream = new Plane();

    List<CanFly> flyable = new ArrayList<>();
    flyable.add(clarkKent);
    flyable.add(donald);
    flyable.add(dream);

    List<CanRun> runnable = new ArrayList<>();
    runnable.add(clarkKent);
    runnable.add(kirill);
    runnable.add(donald);
    runnable.add(skipper);

    List<CanSwim> swimmable = new ArrayList<>();
    swimmable.add(clarkKent);
    swimmable.add(kirill);
    swimmable.add(donald);
    swimmable.add(skipper);

    makeThemFly(flyable);
    makeThemRun(runnable);
    makeThemSwim(swimmable);
  }

  // метод "заставь летать"
  private static void makeThemFly(List<CanFly> flyable) {
    System.out.println("Main.makeThemFly(flyable=" + flyable + ")");
    for (CanFly flyableObject : flyable) {
      System.out.println(flyableObject + ".fly()");
      flyableObject.fly(); // команда "лети!"
    }
  }

  // метод "заставь бежать"
  private static void makeThemRun(List<CanRun> runnable) {
    System.out.println("Main.makeThemRun(runnable=" + runnable + ")");
    for (CanRun runnableObject : runnable) {
      System.out.println(runnableObject + ".run()");
      runnableObject.run(); // команда "беги!"
    }
  }

  // метод "заставь плыть"
  private static void makeThemSwim(List<CanSwim> swimmable) {
    System.out.println("Main.makeThemSwim(swimmable=" + swimmable + ")");
    for (CanSwim swimmableObject : swimmable) {
      System.out.println(swimmableObject + ".swim()");
      swimmableObject.swim(); // команда "плыви!"
    }
  }
}
