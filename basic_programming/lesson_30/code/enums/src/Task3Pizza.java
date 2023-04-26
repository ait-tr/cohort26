import java.util.Scanner;

public class Task3Pizza {

  private enum Size {
    SMALL,
    MEDIUM,
    LARGE,
  }

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
    // название пиццы - нам может быть важным регистр (хотим выводить название красиво),
    // название может состоять из нескольких слов,
    // мы можем захотеть добавить новые виды пиццы прямо во время работы программы
    // (в будущем, если расширим функционал)
    // и название пиццы вводит пользователь -- это знак "подумать дважды", использовать ли enum
    // для названия лучше использовать строку
    String title = parseTitle(scanner);

    // размер пиццы - заранее известный набор значений, меняться не будет
    // важно гарантировать, что получится именно одно из известных значений
    // размер можно сделать enum-ом
    Size size = parseSize(scanner);
    // здесь и дальше в переменной size гарантированно лежит одно из значений enum
    switch (size) {
      case SMALL -> System.out.println("Вы выбрали маленькую пиццу");
      case MEDIUM -> System.out.println("Вы выбрали среднюю пиццу");
      case LARGE -> System.out.println("Вы выбрали большую пиццу");
      default -> System.out.println("Мы не должны здесь оказаться"); // этого никогда не произойдёт
    }

    System.out.println("Ваш заказ:");
    System.out.println("Пицца: " + title);
    System.out.println("Размер: " + size);
    System.out.println("Имя клиента: " + name);
    System.out.println("Спасибо за заказ! Ждём вас снова!");
  }

  private static boolean parseYesOrNo(Scanner scanner, String question) {
    System.out.println(question);
    System.out.print("Введите 'да' или 'нет': ");
    String answer = scanner.next();
    scanner.nextLine(); // пропускаем остаток строки
    return switch (answer.toLowerCase()) {
      case "да", "yes", "1", "true", "y", "д", "+" -> true;
      default -> false; // все остальные значения
    };
  }

  private static String parseTitle(Scanner scanner) {
    System.out.println("Какую пиццу вы хотите заказать?");
    System.out.println("Введите название:");
    String title = scanner.nextLine();
    // здесь может быть проверка названия на корректность
    // например, Set<String> titles.contains(title)
    // или Map<String, Integer> prices.containsKey(title)
    return title;
  }

  // этот метод гарантированно вернёт одно из значений enum
  private static Size parseSize(Scanner scanner) {
    System.out.println("Какого размера будет ваша пицца?");
    System.out.println("Выберите размер:");
    for (int i = 0; i < Size.values().length; ++i) {
      // (i + 1) - индекс превратили в номер
      System.out.println((i + 1) + ". " + Size.values()[i]);
    }
    int answer = scanner.nextInt();
    scanner.nextLine(); // пропускаем остаток строки

    // если ввели число меньше 1 или больше размера - выбран некорректный пункт
    while (answer < 1 || answer > Size.values().length) {
      System.out.println("Введите корректное значение!");
      answer = scanner.nextInt();
      scanner.nextLine(); // пропускаем остаток строки
    }
    // (answer - 1) - номер превратили в индекс
    return Size.values()[answer - 1];
  }
}
