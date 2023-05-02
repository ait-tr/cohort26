import java.io.File;
import java.io.FileNotFoundException;
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
  //
  // Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.

  private final static String SEPARATOR = ": ";

  public static void main(String[] args) throws FileNotFoundException {
    Map<String, String> dict = readDict();
    System.out.println(dict);
  }

  private static Map<String, String> readDict() throws FileNotFoundException {
    final String filename = "res/dict.txt";
    Map<String, String> result = new HashMap<>();
    Scanner scanner = new Scanner(new File(filename));
    int n = scanner.nextInt();
    scanner.nextLine(); // переход на следующую строку
    // i = 0, 1, 2, 3, 4
    for (int i = 0; i < n; ++i) { // повтори n раз
      String line = scanner.nextLine();
      int separatorIndex = line.indexOf(SEPARATOR);
      if (separatorIndex == -1) {
        continue; // переход к следующему шагу цикла досрочно
        // с прочитанной строкой что-то не так - в ней нет `:`
      }
      String word = line.substring(0, separatorIndex); // определяемое слово
      String definition = line.substring(separatorIndex + SEPARATOR.length());
      result.put(word, definition);
    }
    scanner.close();
    return result;
  }
}
