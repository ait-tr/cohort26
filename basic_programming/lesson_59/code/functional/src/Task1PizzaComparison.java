import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1PizzaComparison {

  public static void main(String[] args) {
    List<Pizza> pizzas = new ArrayList<>();
    pizzas.add(new Pizza("Capricciosa", 24, 450, 7.5));
    pizzas.add(new Pizza("Diavola", 32, 750, 11.5));
    pizzas.add(new Pizza("Vesuvio", 28, 550, 9.5));
    for (Pizza pizza : pizzas) {
      System.out.println(pizza);
    }

    // - хочу отсортировать пиццы по возрастанию стоимости
    // - нужен компаратор
    // - но за всю программу я это собираюсь сделать ровно один раз
    // - выглядит не очень правильным создавать целый класс ради одного использования
    // - можно создать анонимный (безымянный) класс - отсутствие имени не даст использовать
    //   его повторно, зато нам не потребуется отдельный файл, и код будет выглядеть понятнее
    // - выглядит это как создание нового объекта, но вместо класса мы указываем желаемый интерфейс
    // - после этого в фигурных скобках
    pizzas.sort(new Comparator<Pizza>() {
      // внутри таких фигурных скобок пишете содержимое класса, как в отдельном файле
      @Override
      public int compare(Pizza o1, Pizza o2) {
        // разница цен может оказаться очень маленькой, например, 0.01 или -0.01
        // чтобы при округлении такое число не превратилось в 0, а сохранило знак, который важен
        // для компаратора, перед превращением в int мы вызываем метод Math.signum():
        //  1500 -> 1.0
        //  0.01 -> 1.0
        //     0 -> 0
        // -0.01 -> -1.0
        //  -200 -> -1.0
        return (int) Math.signum(o1.getPrice() - o2.getPrice());
      }
    });
    System.out.println("После сортировки:");
    for (Pizza pizza : pizzas) {
      System.out.println(pizza);
    }
  }
}
