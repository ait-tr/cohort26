import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework32 {

  // Программисты, как вы уже знаете, постоянно учатся, а в общении между собой используют весьма
  // специфический язык. Чтобы систематизировать ваш пополняющийся профессиональный лексикон, мы
  // придумали эту задачу.
  // Напишите программу создания небольшого словаря сленговых программерских выражений, чтобы она
  // потом по запросу возвращала значения из этого словаря.

  // Файл `dict.txt`
  // В первой строке задано одно целое число `n` — количество слов в словаре.
  // В следующих `n` строках записаны слова и их определения, разделенные двоеточием и символом
  // пробела.
  // 5
  // Змея: язык программирования Python
  // Баг: от англ. bug — жучок, клоп, ошибка в программе
  // Конфа: конференция
  // Костыль: код, который нужен, чтобы исправить несовершенство ранее написанного кода
  // Бета: бета-версия, приложение на стадии публичного тестирования

  // Ввод с клавиатуры
  // В первой строке записано целое число `m` — количество поисковых слов, чье определение нужно
  // вывести.
  // В следующих `m` строках записаны сами слова, по одному на строке.
  // 3
  // Змея
  // Жаба
  // костыль

  // Для каждого слова, независимо от регистра символов, если оно присутствует в словаре,
  // необходимо вывести на экран его определение.
  // Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.

  private final static String SEPARATOR = ": ";
  private final static String DICTIONARY_FILE = "res/dict.txt";

  public static void main(String[] args) throws IOException {
    Map<String, String> dictionary = readDictBuffered();
//    System.out.println(dictionary); // {ключ1=значение1, ключ2=значение2}
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    for (int i = 0; i < m; ++i) {
      String word = scanner.next();
      System.out.println(dictionary.getOrDefault(word.toLowerCase(), "Не найдено"));
    }
  }

  private static Map<String, String> readDict() throws FileNotFoundException {
    Map<String, String> result = new HashMap<>();
    Scanner scanner = new Scanner(new File(DICTIONARY_FILE));
    int n = scanner.nextInt();
    scanner.nextLine(); // переход на следующую строку
    // i = 0, 1, 2, 3, 4
    for (int i = 0; i < n; ++i) { // повтори n раз
      String line = scanner.nextLine();
      int separatorIndex = line.indexOf(SEPARATOR);
      if (separatorIndex == -1) {
        continue; // переход к следующему шагу цикла досрочно
        // с прочитанной строкой что-то не так - в ней нет `: `
      }
      String word = line.substring(0, separatorIndex); // определяемое слово
      String definition = line.substring(separatorIndex + SEPARATOR.length());
      result.put(word.toLowerCase(), definition);
    }
    scanner.close();
    return result;
  }

  private static Map<String, String> readDictBuffered() throws IOException {
    Map<String, String> result = new HashMap<>();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(DICTIONARY_FILE));
    int n = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0; i < n; ++i) {
      String line = bufferedReader.readLine();
      int separatorIndex = line.indexOf(SEPARATOR);
      if (separatorIndex == -1) {
        continue; // переход к следующему шагу цикла досрочно
        // с прочитанной строкой что-то не так - в ней нет `: `
      }
      String word = line.substring(0, separatorIndex); // определяемое слово
      String definition = line.substring(separatorIndex + SEPARATOR.length());
      result.put(word.toLowerCase(), definition);
    }
    bufferedReader.close();
    return result;
  }
}
