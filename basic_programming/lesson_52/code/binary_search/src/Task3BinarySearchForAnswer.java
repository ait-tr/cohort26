import java.util.Scanner;

public class Task3BinarySearchForAnswer {

  // Задача:
  // Петя и Ваня красят забор. Петя красит 5 квадратных метров
  // в день, а Ваня - 4 квадратных метра в день.
  // По заданной площади поверхности забора найти, сколько дней
  // потребуется им вместе на то, чтобы покрасить весь забор.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int square = scanner.nextInt(); // площадь забора, которую надо покрасить
    // при помощи бинарного поиска пытаемся угадать ответ
    int left = 0; // точно меньше ответа
    int right = square; // точно больше ответа
    while (left < right) {
      int mid = (left + right) / 2;
      int res = painted(mid); // столько они покрасят за mid дней
      if (res >= square) { // двигаю "слева направо" по чуть-чуть - mid (правая граница)
        right = mid;       // может оказаться ответом
      } else {             // mid точно не окажется ответом - слишком мало,
        left = mid + 1;    // двигаем вправо как обычно
      }
    }
    System.out.println("Потребуется " + left + " дней");
  }

  // площадь, которую Петя и Ваня покрасят вместе за days дней
  public static int painted(int days) {
    int petya = 5;
    int vanya = 4;
    return petya * days + vanya * days;
  }
}
