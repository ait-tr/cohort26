package ait.tr.homework;

public class Apartment extends House {

  private int entrances;

  public Apartment(String address, int entrances) {
    super(address);
    this.entrances = entrances;
  }

  @Override
  public String toString() {
    return "Многоквартирный дом по адресу " + getAddress() + ", " + entrances + " подьездов";
  }
}
