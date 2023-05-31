import java.io.File;

public class Task1CliArguments {

  public static void main(String[] args) {
    // Command Line Interface (CLI) - интерфейс для взаимодействия с программой с помощью
    // командной строки
    // Аргументы командной строки попадают в аргумент String[] args метода main
    // В аргументах часто передают что-то, что может меняться до начала работы программы,
    // но не будет меняться во время работы программы.
    // Например:
    // - имя файла
    // - режим работы (например, писать вывод на экран или в файл)
    // - язык работы
    // - уровень логирования (нужны ли дополнительные логи)
    // - другие параметры запуска (адрес и/или порт сервера и т.д.)
    System.out.println(
        "У программы при запуске было " + args.length + " аргументов командной строки");
    for (String arg : args) {
      System.out.println(arg);
    }
    // Предположим, что ваша программа должна работать с файлами.
    // Она будет ожидать, что при запуске ей передадут ровно два аргумента - путь к входному
    // файлу (файлу с входными данными) и путь к файлу с результатом
    if (args.length != 2) {
      // System.err - стандартный поток вывода для сообщений об ошибках
      // Не стоит перемешивать вывод через System.out и System.err в одной программе,
      // получившийся вывод может оказаться очень странным
      // System.err стоит использовать только перед завершением работы программы
      System.err.println("Запустите программу с двумя аргументами: входной файл и выходной файл");
      return; // досрочное завершение программы
    }
    String inputFileName = args[0]; // массив args, элемент с индексом 0
    File inputFile = new File(inputFileName);
    if (!inputFile.exists()) { // проверка существования массива
      System.err.println("Некорректный входной файл: " + inputFileName);
      return;
    }
    String outputFileName = args[1]; // массив args, элемент с индексом 1

    System.out.println("Программа будет читать информацию из файла " + inputFileName
        + " и запишет результат работы в файл " + outputFileName);
  }
}