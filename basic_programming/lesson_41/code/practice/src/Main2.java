import java.util.ArrayList;
import java.util.List;

public class Main2 {

  public static void main(String[] args) {
    List<Integer> values = new ArrayList<>();
    values.add(23);
    values.add(45);
    values.add(-12);
    System.out.println("MyMath.sum(" + values + ") = " + MyMath.sum(values));
  }
}
