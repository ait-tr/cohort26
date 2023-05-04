package pets;

public class Pet {

  private String name;

  // добавление атрибута и публичных методов классу-предку добавляет возможность вызывать публичные
  // методы сразу всем наследникам
  private int age;

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

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}
