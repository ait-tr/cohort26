package cashier;

public class Line {

  private final String title;
  private final double price;

  public Line(String title, double price) {
    this.title = title;
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
//    return title + ": " + price + " EUR";
    return String.format("%s: %.2f EUR", title, price);
  }
}
