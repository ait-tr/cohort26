public class Cat {

  private String name;

  public Cat(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void makeSound() {
    System.out.println("Кошка по кличке " + name + " говорит: мяу-мяу");
  }

  public void makeNoise() {
    System.out.println("Кошка по кличке " + name + " мурлычет");
  }
}
