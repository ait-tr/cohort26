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

    CanFly flyableObject = clarkKent;
    flyableObject.fly();

    CanRun runnableObject = clarkKent;
    runnableObject.run();

    CanSwim smimmableObject = clarkKent;
    smimmableObject.swim();
  }
}
