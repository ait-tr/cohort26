import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentList {

  private final List<Student> students;
  private final File file;
  private final char sep;

  public StudentList(String fileName, char sep) {
    file = new File(fileName);
    this.sep = sep;
    students = readFromCsv();
  }

  public void writeToCsv() throws IOException {
    FileWriter fileWriter = new FileWriter(file);
    for (Student student : students) {
      fileWriter.write(student.toCsvString(sep));
    }
    fileWriter.close();
  }

  private List<Student> readFromCsv() {
    List<Student> result = new ArrayList<>();
    if (!file.exists() || !file.canRead()) {
      return result; // если файла нет или его нельзя читать
    }
    try { // try-catch с ignored, потому что мы заранее всё проверили
      Scanner scanner = new Scanner(file); // сканер для чтения из файла
      while (scanner.hasNext()) {
        String line = scanner.nextLine(); // читаем строку из файла
        try {
          Student student = Student.parseFromCsv(line, sep); // получаем студента из строки
          result.add(student); // добавляем полученного студента в список
        } catch (IndexOutOfBoundsException | NumberFormatException ignored) {
        } // не получилось прочитать строку
      }
      scanner.close();
    } catch (FileNotFoundException ignored) {
    }
    return result;
  }

  public void print() {
    for (Student student : students) {
      System.out.println(student);
    }
  }
}
