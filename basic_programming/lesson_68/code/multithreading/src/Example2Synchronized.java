public class Example2Synchronized {

  // ключевое слово synchronized означает, что этот метод или блок команд должен выполняться
  // "с особым вниманием" - поток "блокирует" доступ для остальных методов.
  private int count = 0;

  public void visit() {
    // может оказаться одинаковым в разных потоках
    System.out.println("Старое значение: " + getCount());
    // при увеличении поток "заблокирует" метод, и следующий вызов будет ждать своей очереди
    increment();
    // может оказаться одинаковым в разных потоках
    System.out.println("Новое значение: " + getCount());
  }

  // synchronized - метод increment() не может выполняться одновременно для одного и того же объекта
  public synchronized void increment() { // увеличить count на 1
    // count++;
    // между getCount() = 1023
    // и setCount(1024)
    // могло произойти увеличение в другом потоке
    setCount(getCount() + 1);
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
