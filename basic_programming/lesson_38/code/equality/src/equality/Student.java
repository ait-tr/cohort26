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

  @Override
  public boolean equals(Object obj) {
    // метод equals переопределяет сравнение объектов
    // должен возвращать true, когда объекты равны
    // первое условие -- "ускорение" работы -- нам даже не надо сравнивать содержимое,
    // если ссылки ведут на один и тот же объект
    if (this == obj) { // this -- это ссылка на текущий объект
      return true; // сравниваем объект сам с собой
    }
    if (!(obj instanceof Student student)) { // является экземпляром класса Student
      // instance - пример, экземпляр, образец
      return false; // если объект в скобочках - не студент (не класс Student или его наследник)
    }
    return name.equals(student.getName());
  }
}
