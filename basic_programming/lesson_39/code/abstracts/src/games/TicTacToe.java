package games;

public class TicTacToe extends Game {

  public TicTacToe() {
    super("Tic-Tac-Toe");
  }

  @Override
  public void start() {
    System.out.println("Запустились крестики-нолики");
  }

  @Override
  public String getResult(String playerName) {
    return "Победила дружба, а не " + playerName;
  }
}
