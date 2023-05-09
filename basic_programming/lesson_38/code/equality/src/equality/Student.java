package equality;

public class Student {

  private String name;
  private int age;

  public Student(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
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
    if (!(obj instanceof Student objStudent)) { // является экземпляром класса Student
      // instance - пример, экземпляр, образец
      return false; // если объект в скобочках - не студент (не класс Student или его наследник)
    }
    // выше произошло:
    // Student objStudent = (Student) obj;
    // чтобы получить доступ к методам класса

    // здесь определение того, что мы считаем совпадающими (или одинаковыми) объектами
    // это один и тот же студент, если совпадают имя и возраст
    return name.equals(objStudent.getName()) && age == objStudent.getAge();

    // В методе `equals` для класса чаще всего в конце просто вызываются методы
    // `equals` для атрибутов этого класса и их результат объединяется через && (логическое И)
  }
}
