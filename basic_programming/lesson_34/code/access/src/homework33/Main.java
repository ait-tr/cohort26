package homework33;

public class Main {

  // Используйте класс Soda в вашей программе:
  // - создайте газировку
  // - выведите её добавку
  // - измените добавку
  // - выведите новую добавку
  public static void main(String[] args) {
    Soda drink = new Soda("малина");
    System.out.println("Добавка после создания: " + drink.getSupplement());
    drink.setSupplement("вишня");
    System.out.println("Добавка после изменения: " + drink.getSupplement());
  }
}
