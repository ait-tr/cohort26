# Аргументы командной строки

При запуске любой программы после названия программы могут идти дополнительные аргументы.

Пример:
```shell
git commit -m "Initial commit"
```

Именно эти аргументы попадают в массив `String[] args` - в единственный аргумент метода `main()`, через который запускается программа.

- Аргументы разделены пробелами.
- Текст в кавычках считается одним аргументом.
- Первый (с индексом ноль) аргумент - имя самой программы.

При этом "нулевой" аргумент - само название программы - в Java **пропадает**.

В приведённом выше примере, если бы git был программой, написанной на Java, массив `String[] args` был бы размера 3.
Состав массива:
- 0: `commit`
- 1: `-m`
- 2: `Initial commit`

Проверить наличие аргументов можно следующим образом: `args.length > 0`.

Аргументы командной строки ещё называют "параметры запуска". Обычно они нужны для того, чтобы запустить программу в конкретном режиме -- например, разрешить возможность редактирования базы данных или оставить только просмотр.

Ещё один вариант использования - задание начальных констант программы.

# Собственные исключения

Все исключения объединены в общую иерархию. Как мы теперь уже знаем, такая иерархия задаётся при помощи **наследования**.

Это значит, что теперь вы можете создавать, выбрасывать и обрабатывать собственные исключения.

Такое часто необходимо, если ваши собственные исключения и ошибки вы обрабатывать хотите, а вот системные должны приводить к падению программы или просто обрабатываться по-другому.

Пример:
```java
public class IllegalAge extends IllegalArgumentException {

}

public class Alcohol {

  final private static int LEGAL_AGE = 18;

  public void open(int age) {
    if (age < LEGAL_AGE) {
      throw new IllegalAge();
    }
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    Alcohol beer = new Alcohol();

    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.print("Введите возраст: ");
      int age = Integer.parseInt(br.readLine());
      beer.open(age);
    } catch (IllegalAge e) {
      System.err.println("Недостаточный возраст");
    }
  }
}
```

# Метод `equals()`

Сравнение объектов по умолчанию сравнивает ссылки.

Если вы создали собственный класс (например, деньги) и хотите научиться сравнивать его с другими объектами, то вам необходимо переопределить метод `public boolean equals(Object o)`:
```java
public class Money {

  private long amount;
  private String currency;

  public Money(double amount, String currency) {
    this.amount = Math.round(amount * 100);
    this.currency = currency;
  }

  @Override
  public String toString() {
    return String.format("%.2f %s", amount / 100.0, currency.toUpperCase());
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Money money)) {
      return false;
    }
    return amount == money.amount && currency.equalsIgnoreString(money.currency);
  }
}
```

**Внимание!** Метод `equals` должен принимать аргумент `Object`!

При сравнении вам нужно самостоятельно проверить, можете ли вы сравнивать с экземплярами конкретного класса!

# Метод `hashCode()`

Метод `public int hashCode()` используется Java при поиске и хранении объекта при использовании в качестве элемента множества или ключа словаря.

**Необходимо, чтобы для тех объектов, которые считает равными `equals()`, метод `hashCode()` также возвращал одинаковое значение.**

**Поэтому при переопределении метода `equals()` вы должны переопределить метод `hashCode()`.**

Желательно, чтобы для разных объектов метод hashCode() возвращал разные значения, иначе скорость работы `HashMap` и `HashSet` сильно замедлится.

Пример "грубой" реализации метода, консистентной с `equals()` для упомянутого выше класса `Money`:
```java
@Override
public int hashCode() {
  return (int) amount * currency.hashCode();
}
```

Пример усовершенствованной реализации, генерируемой Idea для старых версий Java:
```java
@Override
public int hashCode() {
  int result = (int) (amount ^ (amount >>> 32));
  result = 31 * result + currency.hashCode();
  return result;
}
```

Idea по запросу автоматически генерирует методы `equals()` и `hashCode()`:
```java
@Override
public boolean equals(Object o) {
  if (this == o) {
    return true;
  }
  if (!(o instanceof Money money)) {
    return false;
  }
  return amount == money.amount && currency.equals(money.currency);
}

@Override
public int hashCode() {
  return Objects.hash(amount, currency);
}
```

В большинстве случаев результат автоматической генерации вам полностью подойдёт.
