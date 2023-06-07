import java.util.Scanner;

public class Task6Power2 {

  // по введённому числу x надо узнать, является ли оно неотрицательной степенью 2
  // 4 = 2^2 = является (true)
  // 5 - не является (false)
  // 6 - не является (хотя делится на 2) (false)
  // 8 = 2^3 = является (true)
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    System.out.println(isPower2(x));
  }

  public static boolean isPower2(int x) {
    if (x < 1) {
      return false; // точно не неотрицательная степень 2
    }
    // дальше x >= 1
    if (x == 1) {
      return true; // конец рекурсии - 1 = 2^0 - точно степень 2
    }
    // дальше x > 1
    if (x % 2 != 0) {
      return false; // число даже не делится на 2 (и уже не 1)
    }
    // дальше x делится на 2
    return isPower2(x / 2); // если при делении на 2 получилась степень 2, то и x - степень 2
  }
}
