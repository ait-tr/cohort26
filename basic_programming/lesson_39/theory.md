# Абстрактные классы и методы

Иногда наш дизайн классов предполагает, что мы хотим определить общий набор методов и общий базовый класс.

Например, для шахматных фигур нам бы подошёл класс "Фигура", который будет содержать в себе описание конструктора и методов `getCoordinates()`, `checkCoordinates()`, `setCoordinates()`, `getColor()`...

Для этого мы обычно используем наследование:

```java
enum Color {
  WHITE,
  BLACK,
}

public class Figure {

  Color color;
  // ... остальные атрибуты

  public Figure(Color color) {
    this.color = color;
  }

  // ... остальные общие методы
}

public class Rook extends Figure {

  public Rook(Color color) {
    super(color);
  }

  // ... @Override общих методов
}
```

Такая архитектура код позволит нам создать список фигур:
```java
List<Figure> = new ArrayList<>();
```

Или даже игровую доску:
```java
// Предположим, что у нас есть класс Cell, описывающий клетку
Map<Cell, Figure> board = new HashMap<>();
// или создадим список "строчек доски"
List<List<Figure>> anotherBoard = new ArrayList<>();
```

Но ещё эта архитектура кода создаст нам две проблемы:
- что такое "создать просто фигуру" `new Figure()`?
- что должен возвращать метод `checkCoordinates()` у "просто фигуры"?

У этих вопросов есть ответ, но он может нам не понравиться: "просто фигуры" **не бывает**.

Это некая **абстракция**, которую мы ввели для удобства написания кода.

Класс `Figure` - это абстрактная, *какая-то* фигура, у которой будут нужные методы и которую можно складывать в список.

Но создавать и использовать её "саму по себе" **нельзя**!

Такие классы (и те их методы, которые бессмысленно описывать, как `checkCoordinates()` для "просто фигуры") называют абстрактными и обозначают ключевым словом `abstract`.

Выглядит это следующим образом:
```java
// абстрактный класс - его объекты нельзя создавать
public abstract class Figure {

  Color color;
  // ... остальные атрибуты

  public Figure(Color color) {
    this.color = color;
  }

  public abstract boolean checkCoordinates(int row, int column);
  // абстрактный метод - только сигнатура без тела метода

  // ... остальные общие методы
}

public class Rook extends Figure {

  public Rook(Color color) {
    super(color);
  }

  @Override // если не перезаписать абстрактный метод, класс Rook тоже будет абстрактным
  public boolean checkCoordinates(int row, int column) {
    boolean result = false;
    // какая-то проверка
    return result;
  }

  // ... @Override общих методов
}
```

**Невозможно** создать объект абстрактного класса. Код
```java
Figure smth = new Figure();
```
приведёт к ошибке **"'Figure' is abstract; cannot be instantiated"** *("класс Фигура абстрактный; не может быть создан")*.

Методы, которые нет смысла описывать в абстрактном классе, потому что они **точно** должны быть переопределены, также называются абстрактными. Для них достаточно записать сигнатуру и поставить точку с запятой, не нужно писать тело метода (в фигурных скобочках):
```java
public abstract boolean checkCoordinates(int row, int column);
```

# Правила работы с абстрактными классами

1. Абстрактный класс - класс, объекты которого нельзя создавать. **В нём может и не быть абстрактных методов.**
1. Если в классе есть **хоть один абстрактный метод**, класс **обязан** быть абстрактным.
1. Если вы унаследовали свой класс от абстрактного класса, нужно **переопределить все** унаследованные **абстрактные** методы — написать для них реализацию.
   Иначе такой класс тоже придется объявить **абстрактным**.
