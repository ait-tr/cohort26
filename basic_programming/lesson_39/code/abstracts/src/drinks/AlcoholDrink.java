package drinks;

public class AlcoholDrink extends Drink {


  private final double alcohol;

  public AlcoholDrink(String title, double alcohol) {
    super(title);
    this.alcohol = alcohol;
  }

  public double getAlcohol() {
    return alcohol;
  }

  @Override
  public String toString() {
    return "AlcoholDrink{title='" + getTitle() + "', alcohol=" + alcohol + "}";
  }
}
