public class Car {

  public static Car readFromSystemIn() {
    Car result = new Car();
    // здесь мы заполняем информацию об автомобиле, читая данные с клавиатуры
    return result;
  }

  public static Car parseCar(String line, String separator) {
    Car result = new Car();
    // здесь мы заполняем информацию об автомобиле, читая содержимое строки line
    // из CSV-файла c разделителем separator
    return result;
  }

  public String getCsvLine(String separator) {
    return "";
  }
}
