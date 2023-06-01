import java.util.Scanner;

public class Task1GuessNumber {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Вас приветствует игра 'Угадай число'!");
    System.out.println("Загадайте число от 1 до 1000.");
    System.out.println("На вопросы отвечайте следующим образом:");
    System.out.println("'>', если ваше число больше предложенного;");
    System.out.println("'<', если ваше число меньше предложенного;");
    System.out.println("'=', если программа угадала ваше число.");
    int left = 1;
    int right = 1000;
    // сложность по времени: O(сколько раз можно n разделить на 2, пока не получится 1?)
    // обратный процесс: сколько раз надо умножить на 2 (начиная с единицы), чтобы получить n?
    // то есть:
    // 1 * 2 * 2 * ... * 2 = n
    // 2 * 2 * ... * 2 = n
    // предположим, что умножили мы k раз
    // 2^k = n
    // то есть наша сложность - это степень, в которую надо возвести 2, чтобы получить n
    // "степень, в которую надо возвести 2, чтобы получить n" - по определению
    // "логарифм n по основанию 2"
    // log_2(n)
    // O(log n) по времени
    while (left != right) { // cужаем границы вдвое
      int mid = (left + right) / 2; // ищем середину
      System.out.println("Ваше число - " + mid + "?");
      String response = scanner.nextLine();
      switch (response) {
        case ">": // наш ответ лежит "справа" от середины
          left = mid + 1; // левая граница - (середина + 1)
          break;
        case "<": // наш ответ лежит "слева" от середины
          right = mid - 1; // правая граница - (середина - 1)
          break;
        case "=":
          System.out.println("Ура!");
          return;
        default:
          System.out.println("Некорректный ответ. Введите '>', '<' или '=':");
          break;
      }
    }
    // если мы попали сюда, left == right, и это и есть ответ
    System.out.println("Ваше число: " + left);
  }
}
