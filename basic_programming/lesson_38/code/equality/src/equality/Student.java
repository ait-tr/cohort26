package equality;

public class Student {

  private String name;

  public Student(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Студент по имени " + name;
  }

//  @Override
//  public boolean equals(Object obj) {
//
//  }
}
