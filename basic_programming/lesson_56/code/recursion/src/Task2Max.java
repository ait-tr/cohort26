import java.util.ArrayList;
import java.util.List;

public class Task2Max {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    System.out.println(maxElem(numbers));
  }

  public static int maxElem(List<Integer> numbers) {
    System.out.print("maxElem(" + numbers + ") = ");
    int last = numbers.remove(numbers.size() - 1);
    if (!numbers.isEmpty()) {
      System.out.println("Math.max(" + last + ", maxElem(" + numbers + "))");
      return Math.max(last, maxElem(numbers));
    }
    System.out.println(last);
    return last;
  }
}
