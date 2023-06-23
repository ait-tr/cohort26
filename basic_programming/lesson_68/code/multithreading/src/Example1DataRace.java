public class Example1DataRace {

  private int count = 0;

  public void increment() { // увеличить count на 1
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
