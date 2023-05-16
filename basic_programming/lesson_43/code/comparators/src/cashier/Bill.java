package cashier;

import java.util.List;
import java.util.ArrayList;

public class Bill {

  private final List<Line> lines = new ArrayList<>();
  private double total = 0.0; // если мы начнём корректировать позиции, это надо будет учитывать

  public void addLine(String position, double price) {
    lines.add(new Line(position, price));
    total += price;
  }

  public boolean isEmpty() {
    return lines.isEmpty();
  }

  public double getTotal() {
    return total;
  }

  @Override
  public String toString() {
    // TODO lines.sort()
    String result = "=== Чек ===\n";
    for (Line line : lines) {
      result += line + "\n";
    }
    result += String.format("Итого: %.2f EUR%n", total);
    return result;
  }
}
