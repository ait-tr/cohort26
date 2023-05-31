package ait.tr.homework;

public abstract class House {

  private String address;

  //В качестве аргумента конструктора принимайте адрес.
  public House(String address) {
    this.address = address;
  }


  //Напишите для адреса сеттер и геттер.
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
