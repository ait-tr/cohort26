import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task1Sum {

  private static int sum(int a, int b) {
    return a + b;
  }

  // checked and unchecked exceptions
  // Проверяемые и не проверяемые исключения
  // отслеживаемые:
  // - Exception
  // - IOException - ошибка ввода/вывода
  // - FileNotFoundException - файл не найден
  // - SocketException - ошибка взаимодействия с другим процессом

  // Проверяемые исключения нужно либо:
  // - указать в сигнатуре метода после слова throws (метод выбрасывает определённое исключение)
  // - поймать при помощи try-catch
  public static void main(String[] args) throws FileNotFoundException {
    // для хранения информации о файле мы используем класс File
    // самого файла при этом может не быть -- информация может оказаться некорректной!
//    File inputFile = new File("res/input.txt");
    // для чтения файла мы используем FileReader - разновидность InputStreamReader'а
//    FileReader fileReader = new FileReader(inputFile);
//    BufferedReader bufferedReader = new BufferedReader(fileReader);
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedReader bufferedReader = new BufferedReader(new FileReader("res/in.txt"));
//    try {
      Scanner scanner = new Scanner(new File("res/input.txt"));
      int a = scanner.nextInt(); // Integer.parseInt(bufferedReader.readLine());
      int b = scanner.nextInt(); // Integer.parseInt(bufferedReader.readLine());
      System.out.println(sum(a, b));
//    } catch (FileNotFoundException e) {
//      System.out.println("Файл не найден: " + e.getMessage());
//    }
  }
}
