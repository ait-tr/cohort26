public class Student {

  String name;
  int score;
  private static final char SEP = ';';

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

  public String toCsvString() {
    return name + SEP + score + '\n';
  }

  public static Student parseFromCsv(String line) {
    // line = "Бовша Альберт Рустамович;99"
    int sepIndex = line.indexOf(SEP);
    String name = line.substring(0, sepIndex); // name = "Бовша Альберт Рустамович"
    // ';' пропускаем, поэтому начинаем с `sepIndex + 1`
    String scoreStr = line.substring(sepIndex + 1); // scoreStr = "99"
    int score = Integer.parseInt(scoreStr);
    return new Student(name, score);
  }
}
