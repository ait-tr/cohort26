package ait.tr.interfaces;

public class Person implements Information {

  public String name;

  public Person(String name) {
    this.name = name;
  }

  public void sayHello() {
    System.out.println("Привет человек");
  }

  @Override
  public void showInformation() {
    System.out.println("Имя: " + this.name);
  }

  @Override
  public int getAge() {
    System.out.println("Возраст: 25");
    return 25;
  }
}
