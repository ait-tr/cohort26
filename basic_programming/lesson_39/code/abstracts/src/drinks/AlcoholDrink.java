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

  // если в классе есть абстрактный метод (новый или унаследованный), то либо
  // (унаследованный) метод надо переопределить (и он больше не абстрактный),
  // либо сам класс обязан быть абстрактным
  @Override
  public void drink() {
    System.out.println("You drank some " + getTitle() + " and became a little funnier");
  }
}
