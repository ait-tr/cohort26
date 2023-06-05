package homework_53;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

  // Петя перешёл в другую школу. На уроке физкультуры ему понадобилось определить своё место
  // в строю. Помогите ему это сделать.
  // Программа получает на вход невозрастающую последовательность натуральных чисел, означающих
  // рост каждого человека в строю. После этого вводится число X – рост Пети. Все числа во входных
  // данных натуральные и не превышают 200.
  // Выведите номер, под которым Петя должен встать в строй. Если в строю есть люди с одинаковым
  // ростом, таким же, как у Пети, то он должен встать после них.
  //
  // Пример ввода
  // 165 163 160 160 157 157 155 154
  // 162
  //
  // Пример вывода
  // 3
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Прочитать ввод из примера ввода - 2 способа:
    // 1. Прочитать все числа через nextInt() и потом "отцепить" последнее. Для примера ввода
    //    сначала прочитаем все девять (8 + 1) чисел в один список, потом удалим
    //    (или даже не положим) последнее в список, а сохраним его отдельно.
//    List<Integer> heights = new ArrayList<>();
//    int pete = 0; // высота Пети
//    while (scanner.hasNextInt()) {
//      int x = scanner.nextInt(); // читаем следующее число // 162
//      // после прочтения можно узнать, последнее оно или нет
//      if (scanner.hasNextInt()) { // если за ним есть ещё одно - значит, мы прочитали НЕ Петю
//        heights.add(x); // 165, 163, 160, 160, 157, 157, 155, 154
//      } else { // это было последнее - высота Пети
//        pete = x; // 162
//      }
//    }
    //   У этого способа есть большой минус: он не масштабируемый (на "двух разных списках" уже не
    //   сработает)
    // 2. Прочитать строку и уже её разбивать на числа
    List<Integer> heights = new ArrayList<>();
    String numbersLine = scanner.nextLine(); // читаем всю строку со списком чисел
    for (String numberStr : numbersLine.split(" ")) { // разбиение строки на подстроки
      int x = Integer.parseInt(numberStr);
      heights.add(x);
    }
    int pete = scanner.nextInt(); // после списка ровно одно число - читаем "как обычно"
    int result = findPos(heights, pete);
    System.out.println(result);
  }

//  public static int findPos(List<Integer> heights, int x) {
//    // 1. линейный поиск - O(n)
//    // 2. бинарный поиск - O(log n)
//    // 3. добавить Петю, отсортировать новый список и найти в нём Петю - O(n log n) (сортировка)
//    // линейный
//    // больше - (равно) - меньше
//    // больше - (равно) - Петя - меньше
//    // позиция, на которую должен встать Петя - это та позиция, на которой начинается "меньше"
//    for (int i = 0; i < heights.size(); i++) {
//      if (heights.get(i) < x) { // индекс позиции, на которой начинается "меньше"
//        return i + 1; // индекс превращаю в номер
//      }
//    }
//    // если попали сюда, то Петя должен встать в конец
//    return heights.size() + 1; // индекс превращаю в номер
//  }

  public static int findPos(List<Integer> heights, int x) {
    // 2. бинарный поиск - O(log n)
    // позиция, на которую должен встать Петя - это та позиция, на которой начинается "меньше"
    int left = 0;
    int right = heights.size(); // правый - "не включая"
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      int midHeight = heights.get(mid);
      // ищем границу, где появляется "низкий" - первый элемент, который меньше Пети
      // midHeight < x:     Высокий - ..x.. - средний - ... - низкий
      //                    left                        right ("средний" может быть ответом)
      // midHeight == x:    Высокий - ...x  - x       - x... -  низкий
      //                                                left    right
      // midHeight > x:     Высокий - ...   - средний - ..x.. - низкий
      //                                                left    right
      if (midHeight < x) {
        right = mid + 1;
      } else {
        left = mid + 1;
      }
    }
    // left - правильный индекс (нашли элемент "меньше Пети")
    if (heights.get(left) < x) {
      return left + 1; // индекс превращаю в номер
    }
    // left - неправильный индекс, но мы остановили цикл, потому что сузились до одного элемента
    // (не нашли элемент "меньше Пети" - значит, все больше)
    return heights.size() + 1; // индекс превращаю в номер
  }
}
