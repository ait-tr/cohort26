import java.util.Scanner;

public class Task3Pizza {

  // пишем программу для приёма заказа пиццы
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== Пиццерия \"AIT-TR\" ===");
    System.out.println("Добро пожаловать!");
    System.out.println("Как вас зовут?");
    String name = scanner.nextLine();
    // ответ "да - нет": лучше использовать boolean
    // можно использовать enum, но значения всего два, и смысл совпадает с true-false
    boolean wantsToOrder = parseYesOrNo(scanner, "Вы хотите заказать пиццу?");
    if (!wantsToOrder) {
      System.out.println("Хорошего дня, " + name + "!");
      return; // досрочное завершение метода
    }
    System.out.println("Здесь мы продолжим принимать заказ");
  }

  private static boolean parseYesOrNo(Scanner scanner, String question) {
    System.out.println(question);
    System.out.print("Введите 'да' или 'нет': ");
    String answer = scanner.next();
    scanner.nextLine(); // пропускаем остаток строки
    return switch (answer.toLowerCase()) {
      case "да", "yes", "1", "y", "д" -> true;
      default -> false; // все остальные значения
    };
  }
}
