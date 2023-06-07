public class Task8Digits {

  public static void main(String[] args) {
    System.out.println(sum(123));
    System.out.println(binary(128));
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

  public static String binary(int x) {
    if (x < 0) {
      throw new IllegalArgumentException("Число должно быть положительным: " + x);
    }
    // если число меньше 2, то в двоичной системе оно такое же
    if (x < 2) {
      return String.valueOf(x);
    }
    // в остальных случаях:
    // "результат деления на два" - левая часть и "остаток от деления на 2" - последняя цифра
    return binary(x / 2) + x % 2;
  }
}
