# Multithreading (Многопоточность)

Multithreading is a programming technique that allows multiple threads of execution to run concurrently within a single process. A thread is a lightweight unit of execution within a program, and multithreading enables a program to perform multiple tasks concurrently, thereby improving its responsiveness and overall efficiency.

Многопоточность (multithreading) - это программная техника, позволяющая одновременное выполнение нескольких потоков выполнения внутри одного процесса. Поток (thread) представляет собой легковесную единицу выполнения в программе, и многопоточность позволяет программе выполнять несколько задач одновременно, что улучшает отзывчивость и общую эффективность программы.

In a single-threaded program, tasks are executed sequentially, one after another. However, in a multithreaded program, different threads can execute independent tasks simultaneously, sharing the same resources and memory space. This concurrency enables parallelism and can lead to improved performance in certain scenarios.

В однопоточной программе задачи выполняются последовательно, одна за другой. Однако в многопоточной программе различные потоки могут выполнять независимые задачи одновременно, используя общие ресурсы и область памяти. Это параллельное выполнение позволяет достичь параллелизма и может привести к повышению производительности в определенных сценариях.

Each thread maintains its own set of registers and stack, but they all share the same memory space. This shared memory allows threads to communicate and synchronize their activities through shared variables and data structures.

Каждый поток содержит свой набор регистров и стек, но все они разделяют одну и ту же область памяти. Эта общая память позволяет потокам обмениваться данными и синхронизировать свои действия через общие переменные и структуры данных.

Multithreading can be beneficial in various situations, such as when dealing with computationally intensive tasks, handling I/O operations, or building responsive user interfaces. By utilizing multiple threads, a program can effectively utilize available CPU cores, exploit parallelism, and provide a better user experience.

Многопоточность может быть полезной в различных ситуациях, таких как работа с вычислительно сложными задачами, обработка операций ввода-вывода или создание отзывчивых пользовательских интерфейсов. Путем использования нескольких потоков программа может эффективно использовать доступные ядра процессора, использовать параллелизм и обеспечить лучший опыт использования.

However, multithreading also introduces challenges like thread synchronization, avoiding race conditions, and ensuring data integrity. Proper synchronization mechanisms, such as locks, semaphores, and condition variables, are often required to coordinate the access and manipulation of shared resources to prevent conflicts and maintain consistency.

Однако многопоточность также вводит сложности, такие как синхронизация потоков, предотвращение гонок данных и обеспечение целостности данных. Для координации доступа и манипуляции с общими ресурсами и предотвращения конфликтов и поддержания согласованности часто требуются правильные механизмы синхронизации, такие как блокировки, семафоры и условные переменные.

Overall, multithreading is a powerful technique that enables concurrent execution of tasks, harnesses parallelism, and can enhance the performance and responsiveness of programs.

В целом, многопоточность является мощной техникой, которая позволяет одновременное выполнение задач, использует параллелизм и может улучшить производительность и отзывчивость программы.

# `Thread` (Поток)

## Creating a Thread (Создание потока)

There are two ways to create a thread.

Есть два способа создания потока.

It can be created by extending the `Thread` class and overriding its `run()` method:

Он может быть создан путем наследования от класса `Thread` и переопределения его метода `run()`:

```java
public class Main extends Thread {

  public void run() {
    System.out.println("This code is running in a thread");
  }
}
```

Another way to create a thread is to implement the `Runnable` interface:

Еще один способ создания потока - реализация интерфейса `Runnable`:

```java
public class Main implements Runnable {

  public void run() {
    System.out.println("This code is running in a thread");
  }
}
```

## Running Threads (Запуск потоков)

If the class extends the `Thread` class, the thread can be run by creating an instance of the class and call its `start()` method:

Если класс унаследован от класса `Thread`, поток может быть запущен путем создания экземпляра класса и вызова его метода `start()`:

```java
public class Main extends Thread {

  public static void main(String[] args) {
    Main thread = new Main();
    thread.start();
    System.out.println("This code is outside of the thread");
  }

  public void run() {
    System.out.println("This code is running in a thread");
  }
}
```

If the class implements the `Runnable` interface, the thread can be run by passing an instance of the class to a `Thread` object's constructor and then calling the thread's `start()` method:

Если класс реализует интерфейс `Runnable`, поток может быть запущен путем передачи экземпляра класса в конструктор объекта класса `Thread`, а затем вызова метода `start()` потока:

```java
public class Main implements Runnable {

  public static void main(String[] args) {
    Main obj = new Main();
    Thread thread = new Thread(obj);
    thread.start();
    System.out.println("This code is outside of the thread");
  }

  public void run() {
    System.out.println("This code is running in a thread");
  }
}
```

## Concurrency Problems (Проблемы параллелизма)

Because threads run at the same time as other parts of the program, there is no way to know in which order the code will run. When the threads and main program are reading and writing the same variables, the values are unpredictable. The problems that result from this are called concurrency problems:

Поскольку потоки выполняются одновременно с другими частями программы, нет способа знать, в каком порядке будет выполняться код. Когда потоки и главная программа читают и записывают одни и те же переменные, значения становятся непредсказуемыми. Проблемы, возникающие в результате этого, называются проблемами параллелизма:

```java
public class Main extends Thread {

  public static int amount = 0;

  public static void main(String[] args) {
    Main thread = new Main();
    thread.start();
    System.out.println(amount);
    amount++;
    System.out.println(amount);
  }

  public void run() {
    amount++;
  }
}
```

To avoid concurrency problems, it is best to share as few attributes between threads as possible. If attributes need to be shared, one possible solution is to use the `isAlive()` method of the thread to check whether the thread has finished running before using any attributes that the thread can change:

Для избежания проблем конкурентности лучше всего делить как можно меньше атрибутов между потоками. Если атрибуты должны быть общими, одно из возможных решений - использовать метод `isAlive()` потока для проверки, завершился ли поток перед использованием атрибутов, которые поток может изменять:

```java
public class Main extends Thread {

  public static int amount = 0;

  public static void main(String[] args) {
    Main thread = new Main();
    thread.start();
    // Wait for the thread to finish
    while(thread.isAlive()) {
      System.out.println("Waiting...");
    }
    // Update amount and print its value
    System.out.println("Main: " + amount);
    amount++;
    System.out.println("Main: " + amount);
  }

  public void run() {
    amount++;
  }
}
```
