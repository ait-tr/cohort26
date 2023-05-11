package ait.tr.task.converter;

public class Main {

  // Задание:
  // В задании создадим интерфейс, реализующие его классы и тестовый класс.
  //
  // Необходимо создать интерфейс конвертер валют. Интерфейс описывает метод
  // возвращающий конвертируемую сумму в определенной валюте.
  // В качестве валют использовать евро, доллар и юань.
  // При конвертации использовать следующие параметры: юань к евро 1:10, юань к доллару 1:12
  // Использовать (передовать в метод) только целые числа.
  //
  // Создать тестовый класс, проверяющий работу интерфейса, его реализацию в классах и
  // выводящий значение в текстовую строку
  //
  // Использовать следующие названия:
  // название интерфейса Converter
  // название класса реализации конвертора в евро EuroConverter
  // название класса реализации конвертора в евро DollarConverter
  //
  // название метода конвертации getConvertedValue
  //
  // название тестового класса Main
  public static void main(String[] args) {
    int yuanAmount = 100;

    DollarConverter dollarConverter = new DollarConverter();
    int yuanDollerAmount = dollarConverter.getConvertedValue(yuanAmount);

    EuroConverter euroConverter = new EuroConverter();
    int yuanEuroConverter = euroConverter.getConvertedValue(yuanAmount);

    System.out.println(yuanAmount + " юаней в евро: " + yuanEuroConverter);
    System.out.println(yuanAmount + " юаней в долларах:  " + yuanDollerAmount);
  }
}
