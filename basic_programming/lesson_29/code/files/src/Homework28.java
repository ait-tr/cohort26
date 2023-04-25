import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework28 {

  // Написать метод
  //
  // public static String decToBin(int number)
  //
  // который получит число и вернёт строку с его двоичной записью.
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите целое число: ");
    int number = Integer.parseInt(bufferedReader.readLine());

    String binNumberStr = decToBin(number);
    System.out.println("Число " + number + " в системе счисления с основанием 2: " + binNumberStr);
  }

  public static String decToBin(int number) {
    String result = "";
    while (number > 0) {
      result = number % 2 + result;
      number /= 2;
    }
    return result;
  }
}
