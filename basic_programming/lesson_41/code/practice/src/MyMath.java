import java.util.List;

public class MyMath {

  static final double PI = 3.14;

  public static int sum(List<Integer> numbers) {
    int result = 0;
    for (int x : numbers) {
      result += x;
    }
    return result;
  }
}
