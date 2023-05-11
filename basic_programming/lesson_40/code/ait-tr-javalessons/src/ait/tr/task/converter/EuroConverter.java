package ait.tr.task.converter;

public class EuroConverter implements Converter {

  @Override
  public int getConvertedValue(int value) {
    int amount = value * 10;
    return amount;
  }
}
