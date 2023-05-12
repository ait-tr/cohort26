package homework_40;

public class Main {

  // Напишите интерфейсы "Умеет летать" `CanFly` с методом `fly()`,
  // "Умеет бегать" `CanRun` с методом `run` и
  // "умеет плавать" `CanSwim` с методом `swim`
  // и реализуйте их в классе "Супермен" `Superman`.
  public static void main(String[] args) {
    // есть переменная (ссылка или число)
    // есть объект (где-то в памяти)
    Superman clarkKent = new Superman();

    makeThemFly(clarkKent);
    makeThemRun(clarkKent);
    makeThemSwim(clarkKent);
  }

  // метод "заставь летать"
  private static void makeThemFly(CanFly flyableObject) {
    System.out.println("Main.makeThemFly(flyableObject=" + flyableObject + ")");
    flyableObject.fly(); // команда "лети!"
  }

  // метод "заставь бежать"
  private static void makeThemRun(CanRun runnableObject) {
    System.out.println("Main.makeThemRun(runnableObject=" + runnableObject + ")");
    runnableObject.run(); // команда "беги!"
  }

  // метод "заставь плыть"
  private static void makeThemSwim(CanSwim swimmableObject) {
    System.out.println("Main.makeThemSwim(swimmableObject=" + swimmableObject + ")");
    swimmableObject.swim(); // команда "плыви!"
  }
}
