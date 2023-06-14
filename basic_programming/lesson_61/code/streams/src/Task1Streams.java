import java.util.stream.Stream;

public class Task1Streams {

  // создать и вывести список квадратов чисел от 1 до 5
  public static void main(String[] args) {
    // streams - потоки - специальный способ работы с данными, не меняя их источник.
    // Поток невозможно повернуть назад - обработка происходит "пошагово".

    // Без потоков
//    int[] numbers = {1, 2, 3, 4, 5}; // создание
//
//    for (int i = 0; i < numbers.length; ++i) { // преобразование
//      // numbers[i] = numbers[i] * numbers[i];
//      numbers[i] *= numbers[i];
//    }
//
//    System.out.println("Список квадратов чисел:");
//    for (int x : numbers) { // потребление
//      System.out.println(x);
//    }

    // Вот так работать с потоками нельзя!
    // исполнение любого оператора над потоком уничтожает этот поток - поэтому для потоков
    // создают пайплайны (pipelines) ("линии труб"), заканчивающиеся терминальным оператором,
    // и не сохраняют поток в виде ссылки на него
//    Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5); // поток 1, 2, 3, 4, 5
//    stream = stream.map(x -> x * x);                           // поток 1, 4, 9, 16, 25
////    stream.forEach(x -> System.out.println(x));
//    stream.forEach(System.out::println);

    Stream.of(1, 2, 3, 4, 5)    // создание
        .map(x -> x * x)                // преобразование
        .forEach(System.out::println);  // потребление - терминальный оператор
  }
}
