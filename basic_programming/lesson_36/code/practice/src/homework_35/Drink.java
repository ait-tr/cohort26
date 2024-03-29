package homework_35;

public class Drink extends Food {

  // Создать класс `Drink` (напиток) - наследника класса `Food`.
  // В классе должны быть дополнительно:
  // - поле "газированный" (да/нет)
  // - метод "открыть", который:
  //   - для газированного напитка печатает "пшш",
  //   - для негазированного - "скр"
  private boolean carbonated;

  // перегрузка (overloading) конструктора, как и перегрузка любого другого метода,
  // позволяет создавать метод с одинаковым названием и разной последовательностью аргументов.
  // Именно по аргументам Java определяет, какой именно метод нужно вызвать.
  public Drink(String title) {
    super(title);
    // В конце выполнения каждого конструктора все поля должны быть инициализированы.
    // Это значит, что если поле не передали в конструкторе, нужно самостоятельно решить,
    // чем вы хотите его заполнить.
    carbonated = false;
  }

  public Drink(String title, boolean carbonated) {
    super(title);
    this.carbonated = carbonated;
  }

  // согласно нашему стилю кода, геттеры для boolean начинаются не со слова `get`, а со слова `is`
  public boolean isCarbonated() {
    return carbonated;
  }

  public void setCarbonated(boolean carbonated) {
    this.carbonated = carbonated;
  }

  public void open() {
    if (carbonated) {
      System.out.println(getTitle() + " делает пшш");
    } else {
      System.out.println(getTitle() + " делает скр");
    }
  }
}
