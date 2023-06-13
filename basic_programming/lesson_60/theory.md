# Стандартные алгоритмы в Java

## Для массивов

Все методы расположены в классе `java.util.Arrays` (см. [документацию](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Arrays.html))

### Бинарный поиск

- `static int binarySearch(Object[] a, Object key)`
- `static int binarySearch(Object[] a, int fromIndex, int toIndex, Object key)`
- `static int binarySearch(T[] a, T key, Comparator<? super T> c)`
- `static int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)`

### Сортировка

- `static void sort(Object[] a)`
- `static void sort(Object[] a, int fromIndex, int toIndex)`
- `static <T> void sort(T[] a, Comparator<? super T> c)`
- `static <T> void sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)`

## Для списков

Все методы расположены в классе `java.util.Collections` (см. [документацию](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Collections.html))

### Бинарный поиск

- `static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)`
- `static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)`

### Сортировка

- `static <T extends Comparable<? super T>> void sort(List<T> list)`
- `static <T> void sort(List<T> list, Comparator<? super T> c)`

# Лямбда-выражения в Java

Лямбда-функции или просто лямбда в Java — это анонимные функции, которые можно сохранять и передавать как анонимные классы, реализующие абстрактный функциональный интерфейс.

Функциональный интерфейс в Java — интерфейс, в котором объявлен только один абстрактный метод (например, компаратор).

## Структура лямбда-выражения

Общий вид лямбды: `(параметры) -> выражение` или `(параметры) -> {операторы;}`. Стрелка — это лямбда-оператор.

Если у лямбда-выражения всего один аргумент, и для него не требуется объявление типа, то круглые скобки можно опустить. В остальных случаях, в том числе если лямбда не принимает никаких аргументов, скобки опустить нельзя.

Аналогичная ситуация и с телом лямбда-выражений: если оно состоит только из одной строки, то фигурные скобки, точку с запятой (;) и директиву return можно тоже опустить.

В качестве тела лямбда-выражения может использоваться ссылка на метод.

## Создание лямбда-выражений

Анонимный компаратор из предыдущего урока
```java
public class Main {

  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();
    // заполнение списка

    cars.sort(new Comparator<Car>() {
      @Override
      public int compare(Car o1, Car o2) {
        return o1.getMaxSpeed() - o2.getMaxSpeed();
      }
    });

    System.out.println(cars);
  }
}
```
можно заменить лямбда-функцией:
```java
public class Main {

  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();
    // заполнение списка

    cars.sort((o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());

    System.out.println(cars);
  }
}
```
