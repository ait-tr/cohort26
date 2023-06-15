import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  // методы
  // статические
  //   отдельный, логически завершённый, независимый фрагмент кода
  //   примеры:
  //   - корень из числа
  //   - чтение списка из файла
  //   - чтение экземпляра класса из файла или с клавиатуры
  //
  //   статические методы никак не зависят от отдельного экземпляра класса
  //   если класс - автомобиль, то статический метод - что-то, что имеет отношение к
  //   автомобилям в целом, но не к конкретному автомобилю
  //   примеры:
  //   - прочитать информацию об автомобиле из файла - статический метод,
  //     никакого автомобиля пока нет
  //   - записать информацию об автомобиле в файл - не статический метод,
  //     записываем информацию о конкретном автомобиле
  // не статические
  //   отдельный, логически завершённый фрагмент кода, имеющий отношение к конкретному объекту
  //   примеры:
  //   - рассчитать стоимость пиццы
  //   - сеттеры - изменение информации

  // задача:
  // Программа, работающая со списком студентов.
  // Нужно уметь читать, редактировать, сохранять список студентов в файл.
  // Редактировать список: добавлять, удалять, изменять информацию о студенте
  private static final String fileName = "res/students.csv";

  public static void main(String[] args) throws IOException {
    // чтение из файла
    List<Student> students = readFromCsv(fileName);

    // вывод
    for (Student student : students) {
      System.out.println(student);
    }

    // запись в файл
    writeToCsv(students, fileName);
  }

  private static void writeToCsv(List<Student> students, String fileName) throws IOException {
    FileWriter fileWriter = new FileWriter(fileName);
    for (Student student : students) {
      fileWriter.write(student.toCsvString());
    }
    fileWriter.close();
  }

  private static List<Student> readFromCsv(String fileName) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(fileName)); // сканер для чтения из файла
    List<Student> result = new ArrayList<>();
    while (scanner.hasNext()) {
      String line = scanner.nextLine(); // читаем строку из файла
      Student student = Student.parseFromCsv(line); // получаем студента из строки
      result.add(student); // добавляем полученного студента в список
    }
    scanner.close();
    return result;
  }
}
