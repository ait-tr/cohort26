package homework_61;

public class Student {

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
}
