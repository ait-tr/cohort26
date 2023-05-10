import games.Game;
import games.Tetris;
import games.TicTacToe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamesRunner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("=== Библиотека игр ===");
    List<Game> games = new ArrayList<>();
    games.add(new Tetris());
    games.add(new TicTacToe());

    System.out.println("Выберите игру:");
    for (int i = 0; i < games.size(); ++i) {
      Game game = games.get(i);
      int k = i + 1; // порядковый номер
      System.out.println(k + ". " + game.getTitle());
    }

    System.out.print("Введите номер: ");
    int gameNumber = scanner.nextInt();
    scanner.nextLine();
    int gameIndex = gameNumber - 1;
    Game chosenGame = games.get(gameIndex);

    System.out.println("Вы выбрали игру " + chosenGame.getTitle());
  }
}
