public class Pizza {

  private String title;
  private int weight;

  public Pizza(String title, int weight) {
    this.title = title;
    this.weight = weight;
  }

  public String getTitle() {
    return title;
  }

  public int getWeight() {
    return weight;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Pizza{" +
        "title='" + title + '\'' +
        ", weight=" + weight +
        '}';
  }
}
