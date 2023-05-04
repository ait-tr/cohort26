public class Main {

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
