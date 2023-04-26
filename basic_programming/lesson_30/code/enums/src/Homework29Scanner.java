import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Homework29Scanner {

  // Напишите программу, которая:
  // - прочитает целое число из файла `res/in.txt`
  // - переведёт его в двоичную запись
  // - запишет его в файл `res/out.txt`
  public static void main(String[] args) throws IOException {
    int number = readInt("res/in.txt");
    String binNumber = decToBin(number);
    writeLine("res/out.txt", binNumber);
  }

  private static int readInt(String fileName) throws FileNotFoundException {
    File inputFile = new File(fileName);
    Scanner inputFileScanner = new Scanner(inputFile);
    int number = inputFileScanner.nextInt();
    inputFileScanner.close();
    return number;
  }

  private static void writeLine(String fileName, String line) throws IOException {
    File outputFile = new File(fileName);
    FileWriter outputFileWriter = new FileWriter(outputFile);
    // в конец строки ставим `\n` - символ конца строки
    outputFileWriter.write(line + "\n");
    outputFileWriter.close();
  }

  // Воспользуйтесь методом `decToBin(int number)` из задачи 1 предыдущего урока или информацией
  // из разбора домашнего задания.
  public static String decToBin(int number) {
    final int radix = 2;
    if (number == 0) {
      return "0";
    }

    StringBuilder result = new StringBuilder(); // String result = "";
    boolean isNegative = number < 0;
    if (isNegative) {
      number = Math.abs(number);
    }

    while (number > 0) {
      result.insert(0, number % radix); // result = number % radix + result;
      number /= radix;
    }
    if (isNegative) {
      result.insert(0, "-"); // result = "-" + result;
    }

    return result.toString();
  }
}
