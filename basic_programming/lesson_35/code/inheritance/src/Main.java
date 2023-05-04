public class Main {

  // Ещё один принцип ООП - наследование.
  // Бывают классы-предки, в которых вы описываете общую часть атрибутов и методов,
  // и классы-потомки, в которых вы что-то изменяете или дополняете.
  // "Классы-предки" ещё называются "базовые классы" или "супер-классы" (Super class).
  // "Классы-потомки" часто называюися "классы-наследники" (Child class).

  public static void main(String[] args) {
    Cat cat = new Cat("Кошка");
    cat.makeSound();
    Dog dog = new Dog("Собака");
    dog.makeSound();
    cat.makeNoise();
    dog.catchTail();
    Turtle turtle = new Turtle("Тортилла");
    turtle.makeSound();
  }
}
