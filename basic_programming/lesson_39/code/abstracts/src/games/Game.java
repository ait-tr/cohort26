package games;

public abstract class Game {

  private String title;

  public Game(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  // все игры должны запускаться,
  // но мы не можем ничего сказать про то, что такое "запустить какую-то игру" в общем
  // (какую-то абстрактную игру):
  // это какое-то абстрактное "запустить"
  public abstract void start();
}
