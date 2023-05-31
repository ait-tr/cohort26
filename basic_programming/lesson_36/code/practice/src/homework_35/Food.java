package homework_35;

public class Food {

  // Создать класс `Food` (еда). В классе должны быть:
  // - поле "название",
  // - конструктор, геттер, сеттер,
  // - метод "употребить еду" с каким-нибудь выводом.
  private String title;

  public Food(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void consume() {
    System.out.println("Вы употребили " + title);
  }
}
