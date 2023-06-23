import java.util.concurrent.atomic.AtomicInteger;

public class Example4Atomic {

  // атомарные классы (AtomicInteger и другие) сами запрещают одновременно менять свои значения
  private final AtomicInteger count = new AtomicInteger(0);

  public void increment() { // увеличить count на 1
    // count += 1;
    // setCount(getCount() + 1); // атомарность не спасает, потому что операция "+1" не атомарная
    count.addAndGet(1);
  }

  public int getCount() {
    return count.get();
  }

  public void setCount(int count) {
    this.count.set(count);
  }
}
