import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

  // задача: сделать небольшую базу автомобилей
  // программа должна:
  // - читать автомобили из файла `res/cars.csv`, если он есть
  // - выводить автомобили (списком на экран)
  // - добавлять новый автомобиль (читать ввод пользователя с клавиатуры)
  // - записывать новый список автомобилей в файл `res/cars.csv`
  // информация об автомобиле:
  // - производитель
  // - модель
  // - год выпуска
  // разделитель CSV: `,`

  private static final String FILENAME = "res/cars.csv";
  private static final String SEPARATOR = ",";
  private static List<Car> cars = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    readCarsFromFile();
    Car newCar = Car.readFromSystemIn();
    cars.add(newCar);
    writeCarsToFile();
  }

  private static void readCarsFromFile() throws IOException {
    // заполняет атрибут cars, читая содержимое файла
    BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME));
//    String line = bufferedReader.readLine();
//    while (line != null) {
//      // ...
//      line = bufferedReader.readLine();
//    }
    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
      Car newCar = Car.parseCar(line, SEPARATOR);
      cars.add(newCar);
    }
    bufferedReader.close();
  }

  private static void writeCarsToFile() throws IOException {
    // записывает машины из cars в файл
    FileWriter fileWriter = new FileWriter(FILENAME);
    for (Car car : cars) {
      fileWriter.write(car.getCsvLine(SEPARATOR));
    }
    fileWriter.close();
  }
}
