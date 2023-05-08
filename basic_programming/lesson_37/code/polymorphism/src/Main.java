import java.util.ArrayList;
import java.util.List;
import pets.Cat;
import pets.Dog;
import pets.Monkey;
import pets.Pet;

public class Main {

  // Полиморфизм - способность программы идентично использовать объекты с одинаковым интерфейсом
  // без информации о конкретном типе этого объекта.

  // Примеры:
  // - `List` вместо `ArrayList`
  // - универсальный `println()`

  // Варианты реализации:
  // - перегрузка методов (overloading)
  //   методы называются одинаково, но у них разные сигнатуры (разные типы аргументов)
  //   в программе это выглядит как вызов одного и того же "универсального" метода
  //   например, `System.out.println()`
  // - наследование - с использованием различных потомков там, где метод может просто использовать
  //   класс-предок.
  //   Например, добавляете объекты в List, не задумываясь о конкретном типе - у всех списков
  //   будет метод `add()`
  public static void main(String[] args) {
    Pet cat = new Cat("Пушок");
    cat.makeNoise();
    cat.setName("Пушок Первый");
    cat.makeNoise();

    Pet dog = new Dog("Клык");
    dog.makeNoise();
    dog.setName("Дружок");
    dog.makeNoise();

    List<Pet> pets = new ArrayList<>();
    pets.add(cat);
    pets.add(dog);
    for (Pet pet : pets) {
      // даже без `instanceof` Java знает, какой класс это был на самом деле, и сразу вызывает
      // нужный метод
      pet.makeNoise();
    }

    // какое-то домашнее животное - отдельного класса нет
    Pet turtle = new Pet("Тортилла");
    turtle.makeNoise();

    // обезьянка, но своего makeNoise() у неё нет
    Monkey monkey = new Monkey("Обезьяна");
    monkey.makeNoise();
  }
}
