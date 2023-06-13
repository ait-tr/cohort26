import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // static <T> int	binarySearch(List<? extends Comparable<? super T>> list, T key)
    // статический метод
    // вместо T можно подставить любой класс (но не примитивный тип!)
    // List<? extends Comparable<? super T>> =
    //  Список<любой класс, реализующий интерфейс Comparable<? super T> или наследник такого класса>
    //  предположим, что мы сделали класс Pizza implements Comparable<Pizza>
    //  и сделали наследника RomanPizza extends Pizza
    //  В качестве аргумента нам подойдёт и List<Pizza>, и List<RomanPizza>
    // Comparable<? super T> - интерфейс Comparable, позволяющий сравнивать с объектами класса T
    //  или с объектами его класса-предка
    // Если классу Pizza предшествует класс Food, то интерфейс Comparable<Food> нам тоже подойдёт:

    // class Food implements Comparable<Food>   - ? (super)   - Food
    // class Pizza extends Food                 - T = Pizza
    // class RomanPizza extends Pizza           - ? (extends) - RomanPizza
    // binarySearch(List<RomanPizza extends Comparable<Food>> list, Pizza key)

    // при вызове `объект.метод(аргументы)` происходит следующее:
    //   ищем метод в самом классе объекта (подходящий под сигнатуру)
    //   ищем метод в классе-предке
    //   ищем метод в классе-предке класса-предка
    //   ...
    //   ищем метод в классе Object
    //   метода нет

    // Comparable<Food> означает, что должен быть метод compareTo(Food o)
    // что значит "подходящий под сигнатуру" compareTo(Food o):
    //  то, что мы передали как аргумент, можно преобразовать в Food - оно Food или потомок
    List<Pizza> pizzas = new ArrayList<>();
    pizzas.add(new Pizza("Capricciosa", 450));
    pizzas.add(new Pizza("Vesuvio", 400));
    pizzas.add(new Pizza("Diavola", 500));
    System.out.println("До сортировки:");
    System.out.println(pizzas);

    pizzas.sort(new Comparator<Pizza>() {
      @Override
      public int compare(Pizza o1, Pizza o2) {
        return o1.getTitle().compareTo(o2.getTitle());
      }
    });
    System.out.println("После сортировки:");
    System.out.println(pizzas);

    pizzas.sort(new Comparator<Pizza>() {
      @Override
      public int compare(Pizza o1, Pizza o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
      }
    });
    System.out.println("После другой сортировки:");
    System.out.println(pizzas);
  }
}
