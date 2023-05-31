public class MyOwnException extends RuntimeException {

  public MyOwnException(String message) {
    super(message); // вызываем конструктор RuntimeException(String message)
  }
}
