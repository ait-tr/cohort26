package ait.tr.homework;

public class Mansion extends House {

  public Mansion(String address) {
    super(address);
  }

  @Override
  public String toString() {
    return "Частный дом по адресу " + getAddress();
  }
}
