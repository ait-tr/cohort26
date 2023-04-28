import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task3Customers {

  // Дана база данных о продажах некоторого интернет-магазина.

  // Каждая строка входного файла представляет собой запись вида
  // Покупатель товар количество
  // где Покупатель — имя покупателя (строка без пробелов),
  // товар — название товара (строка без пробелов),
  // количество — количество приобретенных единиц товара.

  // Создайте словарь всех покупателей, а для каждого покупателя подсчитайте количество
  // приобретенных им единиц каждого вида товаров.

  // Пример входных данных:
  // Ivanov paper 10
  // Petrov pen 5
  // Ivanov marker 3
  // Ivanov paper 7
  // Petrov envelope 20
  // Ivanov envelope 5

  // Пример выходных данных
  // Ivanov:
  // envelope 5
  // marker 3
  // paper 17
  // Petrov:
  // envelope 20
  // pen 5
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new File("res/in3.txt"));
    scanner.close();

    FileWriter fileWriter = new FileWriter(new File("res/out.txt"));
    fileWriter.close();
  }
}
