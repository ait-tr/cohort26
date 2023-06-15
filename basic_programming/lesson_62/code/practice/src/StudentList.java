import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentList {

  private final List<Student> students;
  private final String fileName;
  private final char sep;

  public StudentList(String fileName, char sep) throws FileNotFoundException {
    this.fileName = fileName;
    this.sep = sep;
    students = readFromCsv();
  }

  public void writeToCsv() throws IOException {
    FileWriter fileWriter = new FileWriter(fileName);
    for (Student student : students) {
      fileWriter.write(student.toCsvString(sep));
    }
    fileWriter.close();
  }

  private List<Student> readFromCsv() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(fileName)); // сканер для чтения из файла
    List<Student> result = new ArrayList<>();
    while (scanner.hasNext()) {
      String line = scanner.nextLine(); // читаем строку из файла
      Student student = Student.parseFromCsv(line, sep); // получаем студента из строки
      result.add(student); // добавляем полученного студента в список
    }
    scanner.close();
    return result;
  }

  public void print() {
    for (Student student : students) {
      System.out.println(student);
    }
  }
}
