import java.time.Duration;
import java.time.LocalDateTime;

public class Task3Duration {

  public static void main(String[] args) {
    LocalDateTime current = LocalDateTime.now(); // текущее время
    System.out.println(current);

    LocalDateTime end = LocalDateTime.parse("2012-12-20T00:00:00.0");

    Duration duration = Duration.between(current, end);
    System.out.println(duration);
  }
}
