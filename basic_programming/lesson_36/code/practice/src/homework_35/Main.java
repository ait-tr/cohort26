package homework_35;

public class Main {

  // Создать класс `Food` (еда). В классе должны быть:
  // - поле "название",
  // - конструктор, геттер, сеттер,
  // - метод "употребить еду" с каким-нибудь выводом.
  //
  // Создать класс `Drink` (напиток) - наследника класса `Food`.
  // В классе должны быть дополнительно:
  // - поле "газированный" (да/нет)
  // - метод "открыть", который:
  //   - для газированного напитка печатает "пшш",
  //   - для негазированного - "скр"
  public static void main(String[] args) {
    Food dumplings = new Food("пельмени");
    dumplings.consume();
    Drink milk = new Drink("молоко");
    milk.open();
    milk.consume();
    Drink cola = new Drink("Кока-Кола", true);
    cola.open();
    cola.consume();
  }
}
