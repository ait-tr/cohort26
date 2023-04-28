import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2VotesLongName {

  // Входной файл: in.txt
  // В первой строке дано количество записей.
  // Далее, каждая запись содержит имя кандидата и число голосов,
  // отданных за него в одном из штатов.
  // Подведите итоги выборов: для каждого из участника голосования определите число отданных
  // за него голосов.

  // Пример ввода:
  // 5
  // John McCain 10
  // John McCain 5
  // Barack Obama 9
  // Barack Obama 8
  // John McCain 1

  // Пример вывода:
  // John McCain 16
  // Barack Obama 17
  public static void main(String[] args) throws IOException {
    Map<String, Integer> votes = calculateVotes("res/in2.txt");
    writeResult("res/out.txt", votes);
  }

  private static Map<String, Integer> calculateVotes(String filename) throws FileNotFoundException {
    Map<String, Integer> result = new HashMap<>();
    Scanner scanner = new Scanner(new File(filename));
    int n = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < n; ++i) {
      String line = scanner.nextLine(); // читаем всю строку
      int lastSpaceIndex = line.lastIndexOf(' '); // последний пробел в строке
      if (lastSpaceIndex == -1) {
        throw new RuntimeException(
            "В строке " + (i + 2) + " файла " + filename + " нет пробела: " + line);
      }
      String name = line.substring(0, lastSpaceIndex);
      int newVotes = Integer.parseInt(line.substring(lastSpaceIndex + 1));

      if (!result.containsKey(name)) { // если это новый кандидат и его нет в нашей базе
        result.put(name, 0); // добавляем ему "нулевой" счётчик
      }
      int oldVotes = result.get(name);
      result.put(name, oldVotes + newVotes);
    }
    scanner.close();
    return result;
  }

  private static void writeResult(String filename, Map<String, Integer> result) throws IOException {
    FileWriter fileWriter = new FileWriter(filename);
    for (Map.Entry<String, Integer> entry : result.entrySet()) {
      String line = String.format("%s %d%n", entry.getKey(), entry.getValue());
      fileWriter.write(line);
    }
    fileWriter.close();
  }
}
