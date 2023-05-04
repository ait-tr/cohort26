package pets;

import java.util.ArrayList;
import java.util.List;

public class Main {

  // Ещё один принцип ООП - наследование (inheritance).
  // Бывают классы-предки, в которых вы описываете общую часть атрибутов и методов,
  // и классы-потомки, в которых вы что-то изменяете или дополняете.
  // "Классы-предки" ещё называются "базовые классы" или "супер-классы" (Super class).
  // "Классы-потомки" часто называюися "классы-наследники" (Child class / inheritor).

  public static void main(String[] args) {
    Cat cat = new Cat("Кошка");
    cat.makeSound();
    Dog dog = new Dog("Собака");
    dog.makeSound();
    cat.setName("Мурка");
    cat.makeNoise();
    dog.catchTail();
    Turtle turtle = new Turtle("Тортилла");
    turtle.makeSound();
    turtle.setAge(302);
    System.out.println("Черепашке " + turtle.getName() + " " + turtle.getAge() + " лет");

    List<Pet> pets = new ArrayList<>();
    pets.add(cat); // в список Pet можно добавить как сам Pet, так и его потомка - например, Cat
    pets.add(dog);
    pets.add(turtle);
    for (Pet pet : pets) { // for-each
      System.out.println(pet + " по кличке " + pet.getName());
    }

    Pet fluffy = new Cat("Пушистик");
    // Не смотря на то, что перенная fluffy у нас класса Pet, Java знает, какой объект мы
    // создали на самом деле - объект класса Cat (new Cat()), и это будет заметно при выводе
    System.out.println(fluffy + " по кличке " + fluffy.getName());
    pets.add(fluffy);
  }
}
