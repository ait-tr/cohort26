# Анонимный класс

В документации Oracle приведена хорошая рекомендация: «Применяйте анонимные классы, если вам нужен локальный класс для одноразового использования».

Зачем нам может потребоваться одноразовый класс? Например, для компаратора.

Для сравнения автомобилей по максимальной скорости вместо создания отдельного класса
```java
public class MaxSpeedCarComparator implements Comparator<Car> {

  @Override
  public int compare(Car o1, Car o2) {
    return o1.getMaxSpeed() - o2.getMaxSpeed();
  }
}

public class Main {

  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();
    // заполнение списка

    Collections.sort(cars, new MaxSpeedCarComparator());

    System.out.println(cars);
  }
}
```
мы можем использовать более короткую запись:
```java
public class Main {

  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();
    // заполнение списка

    Collections.sort(cars, new Comparator<Car>() {
      @Override
      public int compare(Car o1, Car o2) {
        return o1.getMaxSpeed() - o2.getMaxSpeed();
      }
    });

    System.out.println(cars);
  }
}
```

Нам больше не нужен отдельный файл с компаратором, и логика сравнения теперь находится в том же месте кода, где вызывается сортировка.

# Функциональный интерфейс в Java

Функциональный интерфейс в Java — интерфейс, в котором объявлен только один абстрактный метод (например, компаратор).

Чаще всего используются пять функциональных интерфейсов:
- `Runnable` - ничего не принимает и ничего не возвращает, просто запускается
- `Supplier` - поставщик - ничего не принимает, но порождает новые значения
- `Predicate` - принимает параметр и возвращает логическое значение, часто описывает условие, например, для поиска или фильтрации
- `Function` - функция - принимает параметр и возвращает новое значение, преобразовывает аргумент в результат
- `Consumer` - потребитель - принимает параметр и не возвращает никакого значения
