public class Task7ReverseString {

  // получить строку и развернуть её
  // Collections.reverse() и Arrays.reverse() пользоваться нельзя
  public static void main(String[] args) {
    String string = "а роза упала на лапу азора";
    System.out.println(reverse(string));
  }

  // идея рекурсии - решить начальную (очень простую) задачу
  // и описать шаг - переход от текущей задачи к предыдущей (или к следующей)
  // в нашем примере:
  // - начальной задачей будет разворот строки из одного символа
  // - шагом будет попытка развернуть строку длины n, если предположить, что строку длины (n - 1)
  //   мы разворачивать уже умеем - для такой, меньшей строки и будет рекурсивный вызов
  public static String reverse(String string) { // повторяется n раз - O(n^2) по времени и памяти
    if (string.length() < 2) {
      return string; // пустая строка и строка длины 1 остаются неизменными
    }
    // переход (от разворота строки длины 4 к развороту строки длины 3):
    // роза -> р (оза) -> (азо) р -> азор
    // "р" = string.charAt(0) // first
    // "оза" = string.substring(1) // second
    String first = String.valueOf(string.charAt(0)); // первая буква
    String second = string.substring(1); // всё остальное
    second = reverse(second); // перевёрнутое "всё остальное"
    return second + first; // результат // O(n) по времени // O(n) дополнительной памяти
  }
}
