import java.util.Stack;

public class File3Stack {

  // Stack - стопка (например, книг) - LIFO - last-in-first-out (последний пришёл, первый ушёл)
  // Стек чаще всего используется для временного хранения, например, "дочерних" данных
  // Рекомендуется в Java вместо Stack использовать Deque (например, ArrayDeque)
  // - add(e) - добавить в конец
  // - pop() - забрать последний элемент
  // - обращение по индексу - n/a* (к идее стека как структуры данных, а не к конкретному классу!)
  // - поиск - n/a
  // - вставка: в начало - n/a, в середину - n/a, в конец - O(1)
  // - удаление: из начала - n/a, из середины - n/a, с конца - O(1)
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>(); // лучше использовать `Deque`!!!
    stack.add(1);
    stack.add(2);
    stack.add(3);
    stack.add(4);
    while (!stack.empty()) {
      System.out.println(stack.pop());
    }
  }
}
