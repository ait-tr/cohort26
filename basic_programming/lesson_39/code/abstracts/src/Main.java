import drinks.AlcoholDrink;
import drinks.Drink;
import drinks.SoftDrink;

public class Main {

  public static void main(String[] args) {
    Drink drink = new AlcoholDrink("Jelen", 4.5);
    System.out.println(drink);

    Drink soda = new SoftDrink("Cola", true);
    System.out.println(soda);
  }
}
