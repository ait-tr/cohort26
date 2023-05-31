package games;

public class Tetris extends Game {

  public Tetris() {
    super("Tetris");
  }

  @Override
  public void start() {
    System.out.println("Запустился Тетрис");
  }

  @Override
  public String getResult(String playerName) {
    if (playerName.equals("Кирилл")) {
      return playerName + " - победитель";
    }
    return playerName + " - не победитель";
  }
}
