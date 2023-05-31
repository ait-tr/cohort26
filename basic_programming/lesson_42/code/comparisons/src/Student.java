import java.util.Objects;

public class Student implements Comparable<Student> {

  String name;
  int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  @Override
  public String toString() {
    return name + " (score: " + score + ")";
  }

  // сортируем сначала по баллам, а при одинаковых баллах - по алфавиту
  // аргумент метода compareTo - второй объект, тот, с которым сравниваем
  @Override
  public int compareTo(Student o) {
    // compareTo всегда задаёт "естественную сортировку" - "сортировку по возрастанию"
    // студент "меньше" - значит, в списке будет "раньше"
    // студент "минимален" - значит, в списке он первый
    if (score != o.score) {
      // Если баллы отличаются, то именно они определяют порядок
      // (score - o.score) == (this - other) == по возрастанию
      // А нам надо наоборот (!), по убыванию баллов
      // Студент будет считаться "меньше" (раньше в списке), если балл больше!
      // поэтому и значение будет "наоборот", с противоположным знаком:
      // отрицательное превратится в положительное,
      // ноль останется нулём,
      // и положительное превратится в отрицательное.
//      return -(score - o.score);
      return -(Integer.compare(score, o.score));
    }
    // сюда мы попали, только если баллы совпадают
    // нам осталось сравнить имена
    // при одинаковых баллах сортируем по алфавиту, значит, "по возрастанию" имён
    return name.compareTo(o.name);
  }

  @Override // если переопределяем compareTo, то надо переопределить equals
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Student other)) {
      return false;
    }
    return score == other.score && name.equals(other.name);
  }

  @Override // если переопределяем equals, то надо переопределить hashCode
  public int hashCode() {
    return Objects.hash(name, score);
  }
}
