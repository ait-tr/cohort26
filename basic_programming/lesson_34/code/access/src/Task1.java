public class Task1 {

  public static void main(String[] args) {
    Pizza capriciosa = new Pizza("Capriciosa", 10);
    System.out.println(capriciosa.getString());
    capriciosa.setPrice(12);
    System.out.println(capriciosa.getString());
    capriciosa.setPrice(2);
    System.out.println(capriciosa.getString());
//    Pizza pepperoni = new Pizza("", 10);
//    Pizza mafia = new Pizza(null, 10);
  }
}
