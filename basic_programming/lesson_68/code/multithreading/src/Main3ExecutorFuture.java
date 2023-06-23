import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main3ExecutorFuture {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // Callable / Runnable - в чём разница?
    // Callable может возвращать значение
    ExecutorService executor = Executors.newFixedThreadPool(1);
    // вызов метода ExecutorService.submit(Callable) вернёт объект Future<результат>
    // результат будет не сейчас, а в будущем - обещание результата
    // "запусти метод, возвращающий число, в отдельном потоке" - у этой команды результатом будет
    // "будущее число" - где число будет результатом метода, когда метод выполнится
    Future<Integer> futureInt = executor.submit(Main3ExecutorFuture::getInt);
//    while (!futureInt.isDone()) {
//      System.out.println("Waiting...");
//    }
    // даже если убрать `while (!futureInt.isDone())`, `futureInt.get()` всё равно будет ждать
    Integer result = futureInt.get(); // get получает результат,
    // при необходимости блокируя текущий поток - если результата пока нет, здесь мы будем его ждать

    System.out.print("result: " + result);
    executor.shutdown();
  }

  public static int getInt() {
    return 42;
  }
}
