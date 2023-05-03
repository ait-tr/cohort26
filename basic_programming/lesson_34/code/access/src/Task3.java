import java.util.ArrayList;
import java.util.List;

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

  public static void main(String[] args) {
    readCarsFromFile();
    Car newCar = Car.readFromSystemIn();
    cars.add(newCar);
    writeCarsToFile();
  }

  private static void readCarsFromFile() {
    // заполняет атрибут cars, читая содержимое файла
  }

  private static void writeCarsToFile() {
    // записывает машины из cars в файл
  }
}
