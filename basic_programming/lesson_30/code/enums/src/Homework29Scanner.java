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
    File inputFile = new File("res/in.txt");
    Scanner inputFileScanner = new Scanner(inputFile);
    int number = inputFileScanner.nextInt();
    inputFileScanner.close();

    String binNumber = decToBin(number);

    File outputFile = new File("res/out.txt");
    FileWriter outputFileWriter = new FileWriter(outputFile);
    // в конец строки ставим `\n` - символ конца строки
    outputFileWriter.write(binNumber + "\n");
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
