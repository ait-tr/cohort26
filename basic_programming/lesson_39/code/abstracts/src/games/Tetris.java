package games;

public class Tetris extends Game {

  public Tetris() {
    super("Tetris");
  }

  @Override
  public void start() {
    System.out.println("Запустился Тетрис");
  }
}
