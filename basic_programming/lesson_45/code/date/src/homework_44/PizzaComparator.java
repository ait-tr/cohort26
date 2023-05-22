package homework_44;

import homework_44.Pizza.Size;
import java.util.Comparator;

public class PizzaComparator implements Comparator<Pizza> {

  // Создайте класс `PizzaComparator`, в котором сортируйте пиццы
  // (см. класс `Pizza` из классной работы) следующим образом:
  // - по названию
  // - при одинаковых названиях - по размеру
  // - при одинаковых размерах - по наличию сырного борта (сначала без него, потом с ним)
  @Override
  public int compare(Pizza o1, Pizza o2) {
    String title1 = o1.getTitle();
    String title2 = o2.getTitle();
    if (!title1.equals(title2)) { // если названия не равны
      return title1.compareTo(title2); // то метод закончится
    }
    // если метод не закончился, значит, названия были равны
    Size size1 = o1.getSize();
    Size size2 = o2.getSize();
    if (!size1.equals(size2)) { // если размеры не равны
      return size1.compareTo(size2); // то метод закончится
    }
    // если метод не закончился, значит, и названия, и размеры были равны
    boolean cheesy1 = o1.isCheesyBorder();
    boolean cheesy2 = o2.isCheesyBorder();
////    if (cheesy1 == false && cheesy2 == true) { // false и true
//    if (!cheesy1 && cheesy2) { // false и true
//      return -1; // false < true, <, <0
//    }
////    if (cheesy1 == true && cheesy2 == false) { // true и false
//    if (cheesy1 && !cheesy2) { // true и false
//      return 1; // true > false, >, >0
//    }
//    return 0; // одинаковые - у обеих пицц либо нет, либо есть сырный борт
    return Boolean.compare(cheesy1, cheesy2); // false меньше, чем true

    // если такая идея не пришла в голову, а писать if'ы лень или сложно:
    // и названия, и размеры были равны, и "без сырного бортика" точно дешевле, чем с ним
    // значит, можно сравнить цены - но это не очень надёжно, если позже алгоритм расчёта цены
    // изменится, то этот компаратор вряд ли будут проверять
  }
}
