public class Pet {

  private String name;

  public Pet(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    System.out.println("Вызван pet.setName(" + name + ")");
    this.name = name;
  }
}
