import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task2SumToFile {

  private static int sum(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) throws IOException {
//    BufferedReader bufferedReader = new BufferedReader(new FileReader("res/input.txt"));
    Scanner inputFileScanner = new Scanner(new File("res/input.txt"));
    int a = inputFileScanner.nextInt(); // Integer.parseInt(bufferedReader.readLine());
    int b = inputFileScanner.nextInt(); // Integer.parseInt(bufferedReader.readLine());
    inputFileScanner.close();

    FileWriter outputFileWriter = new FileWriter("res/output.txt");
    outputFileWriter.write(sum(a, b) + "\n");
    outputFileWriter.close();
    // файл обязательно нужно закрыть, иначе часть информации может не записаться
  }
}
