import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;

public class Main2ExecutorService {

  public static void main(String[] args) {
    // ExecutorService - сервис-исполнитель - замена "ручной" работы с потоками
    ExecutorService executor = Executors.newSingleThreadExecutor();

    // Executor.submit(Callable / Runnable) - добавление вызова в очередь вызовов
    executor.submit(() -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("1 Hello " + threadName);
    });

    System.out.println("0 Hello " + Thread.currentThread().getName());

    executor.submit(() -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("2 Hello " + threadName);
    });

    executor.shutdown(); // с момента вызова этого метода в очередь "не пустят" новые задачи
    if (!executor.isShutdown()) {
      executor.submit(() -> { // submit нельзя вызывать после shutdown,
        // получится RejectedExecutionException
        String threadName = Thread.currentThread().getName();
        System.out.println("3 Hello " + threadName);
      });
    }

    executor.shutdownNow(); // мгновенно завершает все задачи

//    executor.awaitTermination(5, TimeUnit.SECONDS); // ожидание завершения задач

    // способ завершения ExecutorService (красивый пример):
//    try {
//      System.out.println("attempt to shutdown executor");
//      executor.shutdown();
//      executor.awaitTermination(5, TimeUnit.SECONDS);
//    }
//    catch (InterruptedException e) {
//      System.err.println("tasks interrupted");
//    }
//    finally {
//      if (!executor.isTerminated()) {
//        System.err.println("cancel non-finished tasks");
//      }
//      executor.shutdownNow();
//      System.out.println("shutdown finished");
//    }
  }
}
