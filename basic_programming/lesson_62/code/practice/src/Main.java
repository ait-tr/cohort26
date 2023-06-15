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

  public static void main(String[] args) throws IOException {
    List<Student> students = createStudentList();
    writeToFile(students, "res/students.txt");
    List<Student> anotherList = readFromFile("res/students.txt");
    for (Student student : anotherList) {
      System.out.println(student);
    }
  }

  private static void writeToFile(List<Student> students, String fileName) throws IOException {
    FileWriter fileWriter = new FileWriter(fileName);
    for (Student student : students) {
      fileWriter.write(student.toString() + "\n");
    }
    fileWriter.close();
  }

  private static List<Student> readFromFile(String fileName) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(fileName)); // сканер для чтения из файла
    List<Student> result = new ArrayList<>();
    while (scanner.hasNext()) {
      result.add(Student.parse(scanner.nextLine()));
    }
    scanner.close();
    return result;
  }

  private static List<Student> createStudentList() {
    List<Student> result = new ArrayList<>();
    result.add(new Student("Бовша Альберт Рустамович", 99));
    result.add(new Student("Богатикова Антонина Дмитриевна", 101));
    result.add(new Student("Горохов Степан Леонидович", 75));
    result.add(new Student("Гусев Александр Семенович", 43));
    result.add(new Student("Дзугаев Ахсарбек Станиславович", 130));
    result.add(new Student("Загибалов Павел Дмитриевич", 76));
    result.add(new Student("Землянов Константин Александрович", 67));
    result.add(new Student("Игумеников Степан Владимирович", 99));
    result.add(new Student("Каламбетов Даниил Эдуардович", 88));
    result.add(new Student("Карданова Аида Аскеровна", 80));
    result.add(new Student("Кашина Оксана Алексеевна", 95));
    result.add(new Student("Киреев Кирилл Александрович", 100));
    result.add(new Student("Коротких Анна Алексеевна", 0));
    result.add(new Student("Кудряшов Дмитрий Романович", 200));
    result.add(new Student("Мамлеева Аделина Ринатовна", 90));
    result.add(new Student("Паршин Егор Ильич", 15));
    return result;
  }
}
