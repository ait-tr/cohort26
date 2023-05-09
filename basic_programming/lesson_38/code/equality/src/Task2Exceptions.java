public class Task2Exceptions {

  public static void main(String[] args) {
    try {
      test(args);
    } catch (MyOwnException e) {
      System.out.println("Ай-яй-яй! Наше исключение: " + e.getMessage());
    }
  }

  public static void test(String[] args) {
    if (args.length != 0) {
      throw new MyOwnException("Программа не умеет обрабатывать аргументы командной строки");
    }
  }
}
