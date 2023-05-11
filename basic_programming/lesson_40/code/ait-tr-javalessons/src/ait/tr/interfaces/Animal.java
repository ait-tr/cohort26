package ait.tr.interfaces;

public class Animal implements Information {

  public int id;

  public Animal(int id) {
    this.id = id;
  }

  public void sleep() {
    System.out.println("Животное спит");
  }

  @Override
  public void showInformation() {
    System.out.println("Id: " + this.id);
  }

  @Override
  public int getAge() {
    System.out.println("Animal age: 5");
    return 5;
  }
}
