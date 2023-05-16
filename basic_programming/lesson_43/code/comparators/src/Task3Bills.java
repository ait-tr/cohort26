import cashier.Register;
import java.util.Scanner;

public class Task3Bills {

  // Используем класс Register - кассовый аппарат.
  // Он должен:
  // - добавлять позицию в чек
  // - закрывать чек (и автоматически открывать новый)
  // - закрывать день и выводить общий отчёт
  public static void main(String[] args) {
    Register register; // TODO инициализировать
    Scanner scanner = new Scanner(System.in);
    int command = readCommand(scanner);
    while (command != 3) {
      switch (command) {
        case 1 -> addLine(register, scanner);
        case 2 -> register.closeBill();
      }
      command = readCommand(scanner);
    }
    register.close();
  }

  public static int readCommand(Scanner scanner) {
    System.out.println("Команды:");
    System.out.println("1. Добавить позицию");
    System.out.println("2. Закрыть чек");
    System.out.println("3. Закрыть день и вывести отчёт");
    System.out.print("Выберите команду: ");
    int command = scanner.nextInt();
    scanner.nextLine();
    while (command < 1 || command > 3) {
      System.out.print("Введите корректный номер команды: ");
      command = scanner.nextInt();
      scanner.nextLine();
    }
    return command;
  }

  public static void addLine(Register register, Scanner scanner) {
    System.out.print("Введите название позиции: ");
    String title = scanner.nextLine();
    System.out.print("Введите стоимость: ");
    double price = scanner.nextDouble();
    scanner.nextLine();

    register.addLine(title, price);
  }
}
