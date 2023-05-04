public class Cat extends Pet {

  public Cat(String name) {
    super(name);
  }

  public void makeSound() {
    System.out.println("Кошка по кличке " + getName() + " говорит: мяу-мяу");
  }

  public void makeNoise() {
    System.out.println("Кошка по кличке " + getName() + " мурлычет");
  }
}
