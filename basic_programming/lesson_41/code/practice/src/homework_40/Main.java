package homework_40;

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

    List<CanFly> flyable = new ArrayList<>();
    flyable.add(clarkKent);
    flyable.add(donald);

    List<CanRun> runnable = new ArrayList<>();
    runnable.add(clarkKent);
    runnable.add(kirill);
    runnable.add(donald);

    List<CanSwim> swimmable = new ArrayList<>();
    swimmable.add(clarkKent);
    swimmable.add(kirill);
    swimmable.add(donald);

    makeThemFly(flyable);
    makeThemRun(runnable);
    makeThemSwim(swimmable);
  }

  // метод "заставь летать"
  private static void makeThemFly(List<CanFly> flyable) {
    for (CanFly flyableObject : flyable) {
      System.out.println("Main.makeThemFly(flyableObject=" + flyableObject + ")");
      flyableObject.fly(); // команда "лети!"
    }
  }

  // метод "заставь бежать"
  private static void makeThemRun(List<CanRun> runnable) {
    for (CanRun runnableObject : runnable) {
      System.out.println("Main.makeThemRun(runnableObject=" + runnableObject + ")");
      runnableObject.run(); // команда "беги!"
    }
  }

  // метод "заставь плыть"
  private static void makeThemSwim(List<CanSwim> swimmable) {
    for (CanSwim swimmableObject : swimmable) {
      System.out.println("Main.makeThemSwim(swimmableObject=" + swimmableObject + ")");
      swimmableObject.swim(); // команда "плыви!"
    }
  }
}
