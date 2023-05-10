package drinks;

public class AlcoholDrink {

  private final String title;
  private final double alcohol;

  public AlcoholDrink(String title, double alcohol) {
    this.title = title;
    this.alcohol = alcohol;
  }

  public String getTitle() {
    return title;
  }

  public double getAlcohol() {
    return alcohol;
  }

  @Override
  public String toString() {
    return "AlcoholDrink{title='" + title + "', alcohol=" + alcohol + "}";
  }
}
