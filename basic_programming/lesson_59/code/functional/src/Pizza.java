public class Pizza {

  private String title;
  private int diameter;
  private int weight;
  private double price;

  public Pizza(String title, int diameter, int weight, double price) {
    this.title = title;
    this.diameter = diameter;
    this.weight = weight;
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getDiameter() {
    return diameter;
  }

  public void setDiameter(int diameter) {
    this.diameter = diameter;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Pizza{" +
        "title='" + title + '\'' +
        ", diameter=" + diameter +
        ", weight=" + weight +
        ", price=" + price +
        '}';
  }
}
