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

Чаще всего используются три функциональных интерфейса:

- `Predicate` - принимает параметр и возвращает логическое значение
- `Consumer` - который принимает параметр и не возвращает никакого значения
- `Function` - принимает параметр и возвращает какое-то значение
