package pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrderTest {

  @Test
  public void testOrderNumber() {
    Order order = new Order();
    assertEquals(1, order.getNumber());
    Order order2 = new Order();
    assertEquals(1, order.getNumber());
    assertEquals(2, order2.getNumber());
  }
}
