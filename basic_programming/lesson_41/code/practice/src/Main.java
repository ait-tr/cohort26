import java.util.ArrayList;
import java.util.List;

public class Main {

  // модификатор static
  // методы hashCode() и equals()
  public static void main(String[] args) {
    System.out.println("MyMath.PI = " + MyMath.PI);

    List<Integer> numbers = new ArrayList<>();
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    System.out.println("MyMath.sum(" + numbers + ") = " + MyMath.sum(numbers));
  }
}
