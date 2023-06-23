public class Main {

  // Термин "поток" появлялся в наших занятиях в трёх независимых местах:
  // - Поток ввода (input stream) и поток вывода (output stream)
  //   Может быть как стандартный (клавиатура и экран), так и модифицированный (файлы)
  // - Потоки данных - стримы - (data stream)
  //   класс Stream и все его операторы (промежуточные и терминальные)
  // - Потоки выполнения команды - треды - (thread)
  //   многопоточность, класс Thread

  // Data race (гонка данных) - основная опасность при многопоточности

  // Кроме атомарных классов, бывают Thread-safe (потокобезопасные) коллекции:
  // - ConcurrentHashMap - потокобезопасная HashMap, эффективнее, чем использование synchronized
  // - CopyOnWriteArrayList - потокобезопасный ArrayList
  // - BlockingQueue - блокирующая очередь (Queue)
  // - и др.

  // Безопасное многопоточное использование данных часто замедляет работу программы.
  // Иногда можно достигнуть отрицательного эффекта - многопоточная программа будет выполняться
  // медленнее, чем те же самые команды в один поток.
  public static void main(String[] args) {
    Example4Atomic example = new Example4Atomic();
    Thread thread = new Thread(() -> {
      for (int i = 0; i < 1000; ++i) {
        example.increment();
      }
    });
    thread.start();
    for (int i = 0; i < 1000; ++i) {
      example.increment();
    }
    // после нашего цикла подождём завершения треда
    while (thread.isAlive()) {
      System.out.println("Waiting...");
    }
    // должно получиться 2000
    System.out.println(example.getCount());
  }
}
