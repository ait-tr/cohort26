public class Task8Digits {

  public static void main(String[] args) {
    System.out.println(sum(123));
  }

  // сумма цифр числа
  public static int sum(int x) {
    if (x < 10) { // если число из одной цифры
      return x; // оно и есть сумма своих цифр
    }
    int last = x % 10;
    int rest = x / 10; // всё, кроме последней цифры
    return last + sum(rest);
  }
}
