package drinks;

public class SoftDrink {

  private final String title;
  private final boolean carbonated;

  public SoftDrink(String title, boolean carbonated) {
    this.title = title;
    this.carbonated = carbonated;
  }

  public String getTitle() {
    return title;
  }

  public boolean isCarbonated() {
    return carbonated;
  }

  @Override
  public String toString() {
    return "SoftDrink{title='" + title + "', carbonated=" + carbonated + "}";
  }
}
