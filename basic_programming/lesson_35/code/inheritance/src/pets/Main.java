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
    // мы всегда можем попытаться преобразовать (скастовать - to cast) переменную одного типа
    // в другой тип (к другому типу) - это называется "приведение типов"
    // Так часто делают с числами:
    System.out.println("=== Приведение типов ===");
    int a = 9;
    int b = 5;
    double res = a / b; // a / b - два int'а - получится число (int) `1`,
    // и только потом оно превратится в `double res = 1` --> `double res = 1.0`
    System.out.println(a + " / " + b + " = " + res);
    res = (double) a / b; // (double) a / b - double и int - получится double `1.8`
    System.out.println("(double) " + a + " / " + b + " = " + res);
    System.out.println();

    System.out.println("=== Домашние животные ===");
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

    // Собственные классы можно использовать без дополнительных усилий:
    // - как отдельные переменные
    // - как элементы массива (Cat[], Pet[])
    // - как элементы списка (List<Cat>)
    // - как значения словаря (Map<String, Cat>)
    // И нельзя (без дополнительных усилий вас ждёт неожиданный результат) как:
    // - элементы множества
    // - ключи словаря
    List<Pet> pets = new ArrayList<>();
    pets.add(cat); // в список Pet можно добавить как сам Pet, так и его потомка - например, Cat
    pets.add(dog); // здесь ссылка на Dog превращается в ссылку на Pet - в списке такие ссылки
    pets.add(turtle);
    for (Pet pet : pets) { // for-each
      System.out.println(pet + " по кличке " + pet.getName());
      // При переборе или доступе по индексу не получится использовать
      // уникальные для конкретного класса-потомка методы.
      // Для любого объекта мы можем проверить, не является ли он экземпляром другого (даже более
      // "позднего") класса, например, класса-потомка
      // if: если Pet - это Dog
      if (pet instanceof Dog) {
        System.out.println("Ух ты, это собака!");
        // приводим наш Pet pet к типу Dog
        Dog tempDog = (Dog) pet;
        tempDog.catchTail();
      }
      // при использовании for-each для "общего" списка (List<Pet>) мы вынуждены использовать
      // "общий" тип переменной -- класс-предок.
    }

    // С индексом 1 (на втором месте) в списке pets сейчас лежит собака:
    System.out.println("pets[1] = " + pets.get(1) + " по кличке " + pets.get(1).getName());
    // При этом pets.get(1).catchTail() использовать не получится
    // Метода catchTail нет в классе Pet, и значит, вызывать его у элемента списка нельзя
    // pets.get(1).catchTail(); - ошибка
    if (pets.get(1) instanceof Dog tempDog) { // если pets[1] на самом деле экземпляр класса Dog
      // или его наследников, то приводим pets[1] к типу Dog
      tempDog.catchTail();
    }

    // if (переменная instanceof Класс)
    // - если переменная на самом деле является объектом указанного класса
    // if (переменная instanceof Класс новаяПеременная)
    // - если переменная на самом деле является объектом указанного класса, привести её к
    //   Класс новаяПеременная = (Класс) переменная

    // логика почти такая же, как при
    // List<Integer> list = new ArrayList<>();
    Pet fluffy = new Cat("Пушистик");
    // Не смотря на то, что перенная fluffy у нас класса Pet, Java знает, какой объект мы
    // создали на самом деле - объект класса Cat (new Cat()), и это будет заметно при выводе
    System.out.println(fluffy + " по кличке " + fluffy.getName());
    pets.add(fluffy);
  }
}
