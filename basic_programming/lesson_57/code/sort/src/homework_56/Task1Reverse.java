package homework_56;

public class Task1Reverse {

  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  // Воспользовавшись разобранными на уроке задачами, напишите рекурсивный метод
  // `public static String reverse(int x)`,
  // который будет возвращать строку, содержащую десятичные цифры целого числа в обратном порядке
  // (развернёт число).
  // - условие выхода: исходное и перевёрнутое - одно и то же, ничего не надо делать:
  //   число однозначное (состоит из одной цифры)
  // - шаг: переход к числу с меньшим количеством цифр:
  //   abcd -> abc d -> d reverse(abc)
  public static String reverse(int x) {
    final int radix = 10; // основание системы счисления
    if (x < 0) {
      throw new IllegalArgumentException("Число должно быть положительным: " + x);
      // вместо этого можно было превратить число в положительное через Math.abs(),
      // судя по условию задачи, нужны только цифры, знак "минус" нас не интересует.
    }
    // 0 <= x < 10
    if (x < radix) { // условие выхода, число из одной цифры
      return String.valueOf(x);
    }
//    int lastDigit = x % 10;
//    int firstPart = x / 10;
//    return lastDigit + reverse(firstPart);
    return x % radix + reverse(x / radix);
  }
}
