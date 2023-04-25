import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Task3Phonebook {

  private static final String SEP = ",";
  private static final File PHONEBOOK_FILE = new File("res/phonebook.csv");

  public static void main(String[] args) throws IOException {
    HashMap<String, String> phones = new HashMap<>(); // пары "имя" - "номер телефона"
    // CSV - comma-separated value - значения, разделённые запятыми
    if (PHONEBOOK_FILE.exists()) {
      Scanner scanner = new Scanner(PHONEBOOK_FILE);
      while (scanner.hasNext()) {
        String line = scanner.nextLine();
        if (!line.isEmpty()) {
          int sepIndex = line.indexOf(SEP);
          if (sepIndex != -1) {
            String name = line.substring(0, sepIndex);
            String phone = line.substring(sepIndex + 1);
            phones.put(name, phone);
          }
        }
      }
      // при разрушении сканер автоматически закроет файл
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите имя:");
    String name = scanner.nextLine();
    System.out.println("Введите номер телефона:");
    String phone = scanner.nextLine();
    phones.put(name, phone);

    for (String owner : phones.keySet()) {
      System.out.println(owner + ": " + phones.get(owner));
    }

    FileWriter fileWriter = new FileWriter(PHONEBOOK_FILE);
    for (String owner : phones.keySet()) {
      fileWriter.write(owner + SEP + phones.get(owner) + "\n");
    }
    fileWriter.close();
  }
}
