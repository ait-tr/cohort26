package cashier;

import java.util.List;
import java.util.ArrayList;

public class Bill {

  private final List<Line> lines = new ArrayList<>();

  public void addLine(String position, double price) {
    lines.add(new Line(position, price));
  }

  public boolean isEmpty() {
    return lines.isEmpty();
  }

  public double getTotal() {
    double total = 0.0;
    for (Line line : lines) {
      total += line.getPrice();
    }
    return total;
  }

  @Override
  public String toString() {
    // TODO lines.sort()
    String result = "=== Чек ===\n";
    for (Line line : lines) {
      result += line + "\n";
    }
    result += String.format("Итого: %.2f EUR%n", getTotal());
    return result;
  }
}
