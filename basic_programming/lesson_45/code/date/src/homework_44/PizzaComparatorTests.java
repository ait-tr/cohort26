package homework_44;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import homework_44.Pizza.Size;
import org.junit.jupiter.api.Test;

public class PizzaComparatorTests {

  @Test
  public void testEqual() {
    // arrange - задание начальных значений
    String title = "Capricciosa";
    Size size = Size.SMALL;
    boolean cheesy = true;
    Pizza pizza1 = new Pizza(title, size, cheesy);
    Pizza pizza2 = new Pizza(title, size, cheesy);
    PizzaComparator comparator = new PizzaComparator();

    // act - действие
    int result12 = comparator.compare(pizza1, pizza2);
    int result21 = comparator.compare(pizza2, pizza1);

    // assert - проверка результата (предположение, что результат правильный)
    assertEquals(0, result12); // хочу 0, а получил result12
    assertEquals(0, result21); // хочу 0, а получил result21
  }

  @Test
  public void testTitle() {
    // arrange - задание начальных значений
    String title1 = "Capricciosa";
    String title2 = "Diablo";
    Size size = Size.SMALL;
    boolean cheesy = true;
    Pizza pizza1 = new Pizza(title1, size, cheesy);
    Pizza pizza2 = new Pizza(title2, size, cheesy);
    PizzaComparator comparator = new PizzaComparator();

    // act - действие
    int result12 = comparator.compare(pizza1, pizza2);
    int result21 = comparator.compare(pizza2, pizza1);

    // assert - проверка результата (предположение, что результат правильный)
    assertTrue(result12 < 0); // предполагаю, что result12 < 0
    assertTrue(result21 > 0); // предполагаю, что result21 > 0
  }

  @Test
  public void testTitleImportance() {
    // arrange - задание начальных значений
    String title1 = "Capricciosa";
    String title2 = "Diablo";
    Pizza pizza1 = new Pizza(title1, Size.LARGE, true);
    Pizza pizza2 = new Pizza(title2, Size.SMALL, false);
    PizzaComparator comparator = new PizzaComparator();

    // act - действие
    int result12 = comparator.compare(pizza1, pizza2);
    int result21 = comparator.compare(pizza2, pizza1);

    // assert - проверка результата (предположение, что результат правильный)
    assertTrue(result12 < 0); // предполагаю, что result12 < 0
    assertTrue(result21 > 0); // предполагаю, что result21 > 0
  }

  @Test
  public void testSize() {
    // arrange - задание начальных значений
    String title = "Capricciosa";
    Size size1 = Size.SMALL;
    Size size2 = Size.MEDIUM;
    Size size3 = Size.LARGE;
    boolean cheesy = true;
    Pizza pizza1 = new Pizza(title, size1, cheesy);
    Pizza pizza2 = new Pizza(title, size2, cheesy);
    Pizza pizza3 = new Pizza(title, size3, cheesy);
    PizzaComparator comparator = new PizzaComparator();

    // act - действие
    int result12 = comparator.compare(pizza1, pizza2);
    int result21 = comparator.compare(pizza2, pizza1);
    int result13 = comparator.compare(pizza1, pizza3);
    int result31 = comparator.compare(pizza3, pizza1);
    int result23 = comparator.compare(pizza2, pizza3);
    int result32 = comparator.compare(pizza3, pizza2);

    // assert - проверка результата (предположение, что результат правильный)
    assertTrue(result12 < 0); // предполагаю, что pizza1 < pizza2
    assertTrue(result21 > 0); // предполагаю, что pizza2 > pizza1
    assertTrue(result13 < 0); // предполагаю, что pizza1 < pizza3
    assertTrue(result31 > 0); // предполагаю, что pizza3 > pizza1
    assertTrue(result23 < 0); // предполагаю, что pizza2 < pizza3
    assertTrue(result32 > 0); // предполагаю, что pizza3 > pizza2
  }

  @Test
  public void testSizeImportance() {
    // arrange - задание начальных значений
    String title = "Capricciosa";
    Pizza pizza1 = new Pizza(title, Size.SMALL, true);
    Pizza pizza2 = new Pizza(title, Size.LARGE, false);
    PizzaComparator comparator = new PizzaComparator();

    // act - действие
    int result12 = comparator.compare(pizza1, pizza2);
    int result21 = comparator.compare(pizza2, pizza1);

    // assert - проверка результата (предположение, что результат правильный)
    assertTrue(result12 < 0); // предполагаю, что pizza1 < pizza2
    assertTrue(result21 > 0); // предполагаю, что pizza2 > pizza1
  }

  @Test
  public void testCheesy() {
    // arrange - задание начальных значений
    String title = "Capricciosa";
    Size size = Size.SMALL;
    Pizza pizza1 = new Pizza(title, size, false);
    Pizza pizza2 = new Pizza(title, size, true);
    PizzaComparator comparator = new PizzaComparator();

    // act - действие
    int result12 = comparator.compare(pizza1, pizza2);
    int result21 = comparator.compare(pizza2, pizza1);

    // assert - проверка результата (предположение, что результат правильный)
    assertTrue(result12 < 0); // предполагаю, что pizza1 < pizza2
    assertTrue(result21 > 0); // предполагаю, что pizza2 > pizza1
  }
}
