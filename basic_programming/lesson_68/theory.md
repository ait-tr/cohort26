# Data Race (Гонка данных)

A data race is a type of concurrency issue that can occur in multithreaded Java programs. It happens when two or more threads access and manipulate shared data concurrently without proper synchronization, leading to unpredictable and erroneous results. Data races can cause the program to behave unexpectedly, produce incorrect outputs, or even crash.

Гонка данных (data race) - это тип проблемы конкурентности, которая может возникнуть в многопоточных программах на языке Java. Она происходит, когда два или более потоков одновременно получают доступ и изменяют общие данные без должной синхронизации, что приводит к непредсказуемым и ошибочным результатам. Гонки данных могут вызывать непредсказуемое поведение программы, производить некорректные результаты или даже приводить к аварийным ситуациям.

In Java, data races typically occur when multiple threads access and modify shared variables or objects without proper synchronization. The Java Memory Model (JMM) defines the rules and guarantees for how threads interact with shared memory. Without proper synchronization, the JMM allows for reordering and caching optimizations that can result in unexpected interleavings of operations and inconsistent views of shared data between threads.

В Java гонки данных обычно возникают, когда несколько потоков получают доступ и изменяют общие переменные или объекты без должной синхронизации. Java Memory Model (JMM) определяет правила и гарантии для взаимодействия потоков с общей памятью. Без правильной синхронизации JMM позволяет оптимизировать переупорядочивание и кэширование операций, что может привести к непредсказуемым взаимодействиям операций и несогласованным представлениям общих данных между потоками.

To avoid data races and ensure correct behavior in multithreaded programs, you need to properly synchronize access to shared data. Java provides several synchronization mechanisms to prevent data races:

Для избежания гонок данных и обеспечения корректного поведения в многопоточных программах на Java необходимо правильно синхронизировать доступ к общим данным. В Java предусмотрены несколько механизмов синхронизации для предотвращения гонок данных:

1. Synchronized blocks/methods: By using the `synchronized` keyword, you can protect a block of code or an entire method to ensure that only one thread can execute it at a time. Synchronization establishes a happens-before relationship, guaranteeing memory visibility and preventing data races.

   Синхронизированные блоки/методы: С помощью ключевого слова `synchronized` можно защитить блок кода или весь метод, чтобы только один поток мог выполнять его в данный момент. Синхронизация устанавливает отношение happens-before, обеспечивая видимость памяти и предотвращая гонки данных.

2. Volatile variables: The `volatile` keyword can be used to mark a variable whose value may be modified by multiple threads. It ensures that any read or write to a volatile variable is atomic and provides visibility guarantees, preventing certain kinds of data races.

   Волатильные переменные: Ключевое слово `volatile` может использоваться для пометки переменной, значение которой может изменяться несколькими потоками. Оно гарантирует, что чтение или запись в волатильную переменную будет атомарной и обеспечивает гарантии видимости, предотвращая определенные виды гонок данных.

3. Locks: Java provides various types of locks, such as `ReentrantLock`, `ReadWriteLock`, and `Lock` interfaces. Locks allow explicit control over synchronization and provide more flexibility than synchronized blocks/methods.

   Замки (Lock): Java предоставляет различные типы замков, такие как `ReentrantLock`, `ReadWriteLock` и интерфейсы `Lock`. Замки позволяют явно управлять синхронизацией и предоставляют большую гибкость по сравнению с блоками/методами с ключевым словом `synchronized`.

4. Atomic classes: The `java.util.concurrent.atomic` package provides atomic classes, such as `AtomicInteger`, `AtomicBoolean`, and `AtomicReference`. These classes provide atomic operations without the need for explicit locks, making them useful for managing shared data in a thread-safe manner.

   Атомарные классы: Пакет `java.util.concurrent.atomic` предоставляет атомарные классы, такие как `AtomicInteger`, `AtomicBoolean` и `AtomicReference`. Эти классы обеспечивают атомарные операции без необходимости явных замков, что делает их полезными для управления общими данными в потокобезопасном режиме.

It's important to note that proper synchronization comes with a trade-off. Excessive synchronization can lead to performance issues and potential deadlocks. Therefore, it's essential to find the right balance between ensuring thread safety and maintaining program efficiency.

Важно отметить, что правильная синхронизация имеет свои плюсы ит минусы. Избыточная синхронизация может привести к проблемам производительности и потенциальным блокировкам. Поэтому важно найти правильный баланс между обеспечением безопасности потоков и поддержанием эффективности программы.

By using the appropriate synchronization mechanisms and following the Java Memory Model guidelines, you can prevent data races and ensure the correct and predictable behavior of your multithreaded Java programs.

С использованием соответствующих механизмов синхронизации и соблюдением рекомендаций Java Memory Model можно предотвратить гонки данных и обеспечить корректное и предсказуемое поведение многопоточных программ на Java.

# Synchronized Blocks/Methods (Синхронизированные блоки/методы)

## Synchronized Instance Methods (Синхронизированные методы объекта)

We can add the `synchronized` keyword in the method declaration to make the method synchronized:

Мы можем добавить ключевое слово `synchronized` в объявление метода, чтобы сделать метод синхронизированным:

```java
public class SynchronizedMethods {

  private int sum = 0;

  public synchronized void synchronisedCalculate() {
    setSum(getSum() + 1);
  }
}
```

Instance methods are synchronized over the instance of the class owning the method, which means only one thread per instance of the class can execute this method.

Методы экземпляра синхронизируются относительно экземпляра класса, которому они принадлежат. Это означает, что только один поток для каждого экземпляра класса может выполнить этот метод.

## Synchronized Static Methods (Синхронизированные статические методы)

Static methods are synchronized just like instance methods:

Статические методы синхронизируются также, как и методы экземпляра:

```java
public static synchronized void syncStaticCalculate() {
  staticSum = staticSum + 1;
}
```

These methods are synchronized on the Class object associated with the class. Since only one Class object exists per JVM per class, only one thread can execute inside a static synchronized method per class, irrespective of the number of instances it has.

Эти методы синхронизируются на объекте `Class`, связанном с классом. Поскольку в JVM существует только один объект `Class` на класс, только один поток может выполняться внутри статического синхронизированного метода для каждого класса, независимо от количества его экземпляров.

# Synchronized Blocks (Синхронизированные блоки)

Here's an example of using a synchronized block in Java:

Вот пример использования синхронизированного блока в Java:

```java
public class Example {

  private int count = 0;

  public void increment() {
    synchronized (this) { // Синхронизированный блок
      count++;
    }
  }

  public int getCount() {
    synchronized (this) { // Синхронизированный блок
      return count;
    }
  }
}
```

In the above example, we have a class `Example` with a shared variable `count`. The methods `increment()` and `getCount()` both access and modify the `count` variable.

В приведенном примере у нас есть класс `Example` (`Пример`) с общей переменной `count` (`количество`). Методы `increment()` (`увеличить()`) и `getCount()` (`получитьКоличество()`) оба получают доступ к переменной `count` и изменяют ее.

To ensure that only one thread can access the `count` variable at a time, we use synchronized blocks. The blocks are synchronized on a shared lock object (`this` in this case), which acts as a mutual exclusion mechanism.

Для обеспечения доступа к переменной `count` только одним потоком одновременно мы используем синхронизированные блоки. Блоки синхронизируются на общем объекте блокировки (`this` в данном случае), который выступает в качестве механизма взаимного исключения.

Inside the `increment()` and `getCount()` methods, we enclose the critical sections of code that access the shared variable within synchronized blocks. This ensures that only one thread can execute the code within the synchronized block at any given time, preventing data races.

Внутри методов `increment()` и `getCount()` мы заключаем критические секции кода, которые обращаются к общей переменной, в синхронизированные блоки. Это гарантирует, что только один поток может выполнять код внутри синхронизированного блока в любой момент времени, предотвращая гонки данных.

By using synchronized blocks, we achieve thread-safe access to the shared `count` variable, ensuring consistent and predictable behavior in a multi-threaded environment.

Используя синхронизированные блоки, мы достигаем безопасного доступа к общей переменной `count`, обеспечивая последовательное и предсказуемое поведение в многопоточной среде.

# Thread-Safe Classes (Потокобезопасные классы)

In Java, thread-safe classes are classes that are designed to be safely used by multiple threads concurrently without causing data inconsistencies or synchronization issues. These classes provide built-in mechanisms to handle concurrent access and modifications to their internal state.

В Java потокобезопасные классы - это классы, которые спроектированы для безопасного использования несколькими потоками одновременно, без возникновения несогласованности данных или проблем синхронизации. Эти классы предоставляют встроенные механизмы для обработки одновременного доступа и изменений их внутреннего состояния.

Thread-safe classes ensure that their methods can be invoked by multiple threads simultaneously, while maintaining the integrity of their internal data and providing consistent behavior. They typically incorporate synchronization techniques, such as the use of locks or atomic operations, to prevent data races and maintain thread safety.

Потокобезопасные классы гарантируют, что их методы могут вызываться несколькими потоками одновременно, сохраняя при этом целостность их внутренних данных и обеспечивая последовательное поведение. Обычно они используют синхронизацию, такую как использование блокировок или атомарных операций, для предотвращения гонок данных и обеспечения безопасности потоков.

Here are some commonly used thread-safe classes in Java:

Вот несколько часто используемых потокобезопасных классов в Java:

1. [`java.util.concurrent.ConcurrentHashMap`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html): A thread-safe implementation of the `Map` interface that allows concurrent access and modifications. It provides built-in mechanisms to handle concurrent updates and ensures consistent visibility of changes across threads.

   `java.util.concurrent.ConcurrentHashMap`: Потокобезопасная реализация интерфейса `Map`, которая позволяет одновременный доступ и изменение. Он предоставляет встроенные механизмы для обработки одновременных обновлений и гарантирует последовательность изменений для всех потоков.

2. [`java.util.concurrent.CopyOnWriteArrayList`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CopyOnWriteArrayList.html): A thread-safe variant of `ArrayList` where all modifications result in creating a new copy of the underlying array. It allows for safe iteration without the need for external synchronization.

   `java.util.concurrent.CopyOnWriteArrayList`: Потокобезопасный вариант `ArrayList`, в котором каждое изменение приводит к созданию новой копии внутреннего массива. Он позволяет безопасно выполнять итерацию без необходимости во внешней синхронизации.

3. [`java.util.concurrent.BlockingQueue`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html): A thread-safe queue implementation that supports blocking operations. It provides methods like `put()` and `take()` that allow threads to block when the queue is empty or full, facilitating coordination between producer and consumer threads.

   `java.util.concurrent.BlockingQueue`: Потокобезопасная реализация очереди, которая поддерживает блокирующие операции. Он предоставляет методы, такие как `put()` и `take()`, которые позволяют потокам блокироваться, когда очередь пуста или полна, обеспечивая координацию между производителями и потребителями.

4. [`java.util.concurrent.atomic.AtomicInteger`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html): A thread-safe wrapper class for integer values that provides atomic operations, such as `incrementAndGet()` and `getAndSet()`, ensuring atomicity and visibility of operations on the underlying value.

   `java.util.concurrent.atomic.AtomicInteger`: Потокобезопасный оберточный класс для целочисленных значений, который предоставляет атомарные операции, такие как `incrementAndGet()` и `getAndSet()`, гарантируя атомарность и видимость операций над значением.

5. [`java.util.concurrent.locks.Lock`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/Lock.html): A flexible synchronization mechanism that allows explicit locking and unlocking. Classes and interfaces like [`ReentrantLock`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/ReentrantLock.html) and [`ReadWriteLock`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/ReadWriteLock.html) provide finer-grained control over locking and support advanced locking strategies.

   `java.util.concurrent.locks.Lock`: Гибкий механизм синхронизации, который позволяет явно устанавливать и снимать блокировку. Классы, такие как `ReentrantLock` и `ReadWriteLock`, предоставляют более тонкое управление блокировкой и поддерживают расширенные стратегии блокировки.

It's important to note that using thread-safe classes does not eliminate the need for proper synchronization and thread coordination in all scenarios. While these classes provide built-in mechanisms to handle concurrency, the correct usage and coordination of threads are still crucial to ensure the correctness of concurrent operations.

Важно отметить, что использование потокобезопасных классов не исключает необходимость правильной синхронизации и координации потоков во всех сценариях. Хотя эти классы предоставляют встроенные механизмы для работы с конкурентностью, правильное использование и координация потоков остаются важными для обеспечения корректности конкурентных операций.

When working with multiple threads, it is essential to choose the appropriate thread-safe class based on the specific requirements of your application. Understanding the concurrency guarantees and limitations of each class is important to ensure the correct and efficient implementation of multi-threaded code.

При работе с несколькими потоками важно выбрать подходящий потокобезопасный класс в зависимости от конкретных требований вашего приложения. Понимание гарантий и ограничений каждого класса важно для правильной и эффективной реализации многопоточного кода.

# `ExecutorService`

`ExecutorService` is a higher-level concurrency utility in Java that provides an abstraction for executing and managing tasks in a multi-threaded environment. It simplifies the process of executing tasks asynchronously, managing thread pools, and handling the lifecycle of threads.

`ExecutorService` (`СлужбаИсполнителя`) в Java представляет собой высокоуровневую утилиту для работы с параллельными задачами в многопоточной среде. Она упрощает процесс асинхронного выполнения задач, управления пулом потоков и обработки жизненного цикла потоков.

Here are some key features and concepts related to `ExecutorService`:

Вот некоторые основные особенности и концепции, связанные с `ExecutorService`:

1. Task Execution: `ExecutorService` allows you to submit tasks for execution. Tasks can be represented as `Runnable` or `Callable` objects. The `ExecutorService` manages the execution of these tasks, either by executing them immediately or queuing them for execution.

   Исполнение задач: `ExecutorService` позволяет отправлять задачи на выполнение. Задачи могут быть представлены в виде объектов `Runnable` или `Callable`. `ExecutorService` управляет выполнением этих задач, либо выполняя их немедленно, либо помещая их в очередь на выполнение.

2. Thread Pool Management: `ExecutorService` maintains a pool of worker threads to execute tasks. The size of the thread pool can be configured, allowing you to control the number of concurrent tasks. Reusing threads from the pool avoids the overhead of creating and destroying threads for each task, resulting in improved performance.

   Управление пулом потоков: `ExecutorService` поддерживает пул рабочих потоков для выполнения задач. Размер пула потоков можно настроить, что позволяет контролировать количество одновременно выполняемых задач. Повторное использование потоков из пула позволяет избежать издержек на создание и уничтожение потоков для каждой задачи, что приводит к улучшению производительности.

3. Task Queuing: If there are more tasks submitted than available threads in the pool, `ExecutorService` can queue the tasks and execute them as soon as a thread becomes available. This helps in managing the load and preventing excessive resource consumption.

   Очередь задач: Если количество задач, отправленных на выполнение, превышает доступное количество потоков в пуле, `ExecutorService` может помещать задачи в очередь и выполнять их, когда становится доступен поток. Это помогает управлять нагрузкой и предотвращать избыточное потребление ресурсов.

4. Future Results: When a task is submitted to the `ExecutorService`, it returns a `Future` object that represents the result of the task's computation. You can use the `Future` to retrieve the result, cancel the task, or check if the task has completed.

   Результаты через `Future`: При отправке задачи в `ExecutorService` он возвращает объект `Future`, который представляет результат вычислений задачи. Вы можете использовать `Future` для получения результата, отмены задачи или проверки ее выполнения.

5. Graceful Shutdown: `ExecutorService` provides methods to gracefully shut down the executor and terminate the worker threads. The shutdown process ensures that all submitted tasks are completed before the executor is terminated.

   Грациозное завершение: `ExecutorService` предоставляет методы для грациозного завершения исполнителя и завершения рабочих потоков. Процесс завершения гарантирует, что все отправленные задачи будут выполнены до завершения исполнителя.

Java provides several implementations of the `ExecutorService` interface, such as `ThreadPoolExecutor` and `ScheduledThreadPoolExecutor`, which offer different features and customization options.

Java предоставляет несколько реализаций интерфейса `ExecutorService`, таких как `ThreadPoolExecutor` и `ScheduledThreadPoolExecutor`, которые предлагают различные функциональные возможности и настройки.

Using `ExecutorService` simplifies the management of concurrent tasks and thread pools, providing a higher-level abstraction for handling concurrency in Java applications. It helps improve performance, resource utilization, and simplifies the coordination of asynchronous tasks.

Использование `ExecutorService` упрощает управление параллельными задачами и пулами потоков, предоставляя более высокоуровневую абстракцию для работы с конкурентностью в приложениях Java. Он помогает повысить производительность, эффективное использование ресурсов и упрощает координацию асинхронных задач.

Here's a simple example of using `ExecutorService` to execute tasks:

Вот простой пример использования `ExecutorService` для выполнения задач:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(5);

    // Отправка задач на выполнение
    for (int i = 0; i < 10; i++) {
      executor.submit(new Task(i));
    }

    // Завершение исполнителя после выполнения задач
    executor.shutdown();
  }

  static class Task implements Runnable {
    private int taskId;

    public Task(int taskId) {
      this.taskId = taskId;
    }

    @Override
    public void run() {
      System.out.println("Task " + taskId + " is being executed.");
      // Логика задачи
    }
  }
}
```

In the example above, we create an `ExecutorService` using `Executors.newFixedThreadPool(5)`, which creates a thread pool with a fixed number of 5 threads. We submit tasks to the executor using the `submit()` method, and each task is executed concurrently by one of the available threads in the pool. Finally, we shut down the executor to release resources and terminate the threads after all tasks are completed.

В приведенном выше примере мы создаем `ExecutorService` с помощью `Executors.newFixedThreadPool(5)`, что создает пул потоков с фиксированным числом из 5 потоков. Мы отправляем задачи в исполнитель с помощью метода `submit()`, и каждая задача выполняется асинхронно одним из доступных потоков в пуле. Наконец, мы завершаем исполнителя, чтобы освободить ресурсы и завершить потоки после выполнения всех задач.
