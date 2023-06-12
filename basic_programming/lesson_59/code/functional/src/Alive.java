public interface Alive {

  default /*public*/ void greet() {
    System.out.println("Привет!");
  }

  /*public*/ void introduce();
}
