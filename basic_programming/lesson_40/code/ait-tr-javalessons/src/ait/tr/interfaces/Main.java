package ait.tr.interfaces;

public class Main {

  public static void main(String[] args) {
    //Animal animalOne = new Animal(1);
    //animalOne.sleep();
    //animalOne.showInformation();

    //Person personOne = new Person("Mike");
    //personOne.sayHello();
    //personOne.showInformation();

    Information animal = new Animal(2);
    animal.showInformation();
    animal.getAge();

    Information person = new Person("Bob");
    person.showInformation();
    person.getAge();
  }
}
