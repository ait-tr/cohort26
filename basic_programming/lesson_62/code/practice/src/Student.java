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

  public String toCsvString(char sep) {
    return name + sep + score + '\n';
  }

  public static Student parseFromCsv(String line, char sep) {
    // line = "Бовша Альберт Рустамович;99"
    int sepIndex = line.indexOf(sep);
    String name = line.substring(0, sepIndex); // name = "Бовша Альберт Рустамович"
    // ';' пропускаем, поэтому начинаем с `sepIndex + 1`
    String scoreStr = line.substring(sepIndex + 1); // scoreStr = "99"
    int score = Integer.parseInt(scoreStr);
    return new Student(name, score);
  }
}
