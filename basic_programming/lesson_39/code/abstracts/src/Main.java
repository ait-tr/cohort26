import drinks.AlcoholDrink;
import drinks.Drink;
import drinks.SoftDrink;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Drink beer = new AlcoholDrink("Jelen", 4.5);
    System.out.println(beer);

    Drink soda = new SoftDrink("Cola", true);
    System.out.println(soda);

//    Drink other = new Drink("Milk");
    Drink other = new SoftDrink("Milk", false);
    // если класс абстрактный, то нельзя создать экземпляр этого класса (new Класс())
    // При этом абстрактный класс можно использовать как тип переменной
    List<Drink> drinks = new ArrayList<>();
    drinks.add(beer);
    drinks.add(soda);
    drinks.add(other);

    System.out.println(drinks);
    for (Drink d : drinks) {
      d.drink();
      // вот здесь будет вызвана перезапись (имплементация) (реализация) абстрактного метода,
      // для каждого класса, возможно, своя
    }
  }
}
