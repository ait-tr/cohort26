package drinks;

public class SoftDrink extends Drink {

  private final boolean carbonated;

  public SoftDrink(String title, boolean carbonated) {
    super(title);
    this.carbonated = carbonated;
  }

  public boolean isCarbonated() {
    return carbonated;
  }

  @Override
  public String toString() {
    return "SoftDrink{title='" + getTitle() + "', carbonated=" + carbonated + "}";
  }

  @Override
  public void drink() {
    System.out.println("You drank some " + getTitle());
  }
}
