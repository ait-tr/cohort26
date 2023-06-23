public class Example3SynchronizedBlocks {

  // ключевое слово synchronized означает, что этот метод или блок команд должен выполняться
  // "с особым вниманием" - поток "блокирует" доступ для остальных методов.
  private int count = 0;
  private final Object lock = new Object(); // это наш замок, который мы повесим на дверь

  public void increment() { // увеличить count на 1
    // count++;
    // между getCount() = 1023
    // и setCount(1024)
    // могло произойти увеличение в другом потоке

    // для одного и того же объекта в скобках
    // объект в скобках (не ссылка, а сам объект) становится "замком" (lock),
    // который:
    // - должен быть открыт для начала блока
    // - закрывается в начале блока
    // - открывается в конце блока

    // synchronized (this)
    // - блокируется для этого экземпляра, аналогично синхронизированному методу экземпляра
    // synchronized (class)
    // - блокируется для конкретного класса, аналогично статическому методу этого класса
    // private final Object lock = new Object();
    // synchronized (lock) - аналогично блокировке для экземпляра, НО таких замков может быть много
    synchronized (lock) {
      setCount(getCount() + 1);
    }
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
