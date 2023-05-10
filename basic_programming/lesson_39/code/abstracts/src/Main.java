import drinks.AlcoholDrink;
import drinks.SoftDrink;

public class Main {

  public static void main(String[] args) {
    AlcoholDrink drink = new AlcoholDrink("Jelen", 4.5);
    System.out.println(drink);

    SoftDrink soda = new SoftDrink("Cola", true);
    System.out.println(soda);
  }
}
