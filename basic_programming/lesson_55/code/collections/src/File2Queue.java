import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class File2Queue {

  // Queue - FIFO (first-in-first-out - первый пришёл, первый ушёл)
  // Буквально "очередь" - как в магазин или к врачу
  // Использование: обработка событий и команд
  //  команды:
  //  - add(e) - offer(e) - добавляет elem в конец
  //  - remove() - poll() - возвращает (и удаляет) элемент в начале
  //  - element() - peek() - подсматривает первый элемент
  // - обращение по индексу - n/a
  // - поиск - n/a
  // - вставка: в начало - n/a, в середину - n/a, в конец - O(1)
  // - удаление: из начала - O(1), из середины - n/a, с конца - n/a
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }
  }
}
