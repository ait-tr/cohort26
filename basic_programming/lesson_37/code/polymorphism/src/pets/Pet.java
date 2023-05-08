package pets;

public class Pet {

  private String name;
  private String type;

  public Pet(String name) {
    this.name = name;
    type = "Домашнее животное";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // protected - доступен только классам внутри пакета pets или классам-наследникам
  protected void setType(String type) {
    // здесь могут быть дополнительные проверки
    this.type = type;
  }

  public void makeNoise() {
    System.out.println(name + ": издаёт звуки");
  }

  @Override // перезаписали Object.toString()
  public String toString() {
//    return type + " по кличке '" + name + "'";
    return String.format("%s по кличке '%s'", type, name);
  }
}
