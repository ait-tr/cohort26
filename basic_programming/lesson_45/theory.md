# Параметризованные тесты

Если код (и смысл результата) теста полностью повторяется, отличаясь только входными значениями, то для повтора теста с разными наборами данных можно использовать параметризацию.

Для параметризованного теста необходимо использовать аннотацию [`@ParametrizedTest`](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/ParameterizedTest.html) вместо `@Test`.

Для передачи параметров достаточно удобно использовать [`@CsvSource`](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/CsvSource.html), в котором наборы аргументов тестового метода передавать в виде csv-строки. Парсинг значений в соотетствии с типами аргументов осуществит сам **JUnit**:

```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RectangleTests {

  @ParameterizedTest
  @CsvSource({
      "5, 3, 'Rectangle {длина: 5, ширина: 3} (площадь: 15)'",
      "3, 5, 'Rectangle {длина: 5, ширина: 3} (площадь: 15)'",
  })
  public void toString(int sideA, int sideB, String expected) {
    // arrange
    Rectangle rect = new Rectangle(sideA, sideB);

    // act
    String actual = rect.toString();

    // assert
    assertEquals(expected, actual);
  }
}
```

# Класс `Date` и Unix-время

С самого появления языка **Java** в нем был специальный класс для работы со временем и датой — [`Date`](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Date.html). С течением времени появилось еще несколько классов для работы с датой, но класс `Date` продолжает использоваться программистами до сих пор.

Все дело в том, что он очень простой и удобный. И вы как программист обязательно столкнетесь c ним в любом реальном проекте. Использовать его или нет — выбор за вами, но знать его вы обязаны.

Класс `Date` хранит информацию о дате и времени в виде количества миллисекунд, прошедших с **1 января 1970 года**. Это очень много миллисекунд, поэтому для их хранения используется тип `long`.

Вот несколько полезных примеров работы с классом `Date`.

## Получение текущей даты

Чтобы получить текущее время и дату, достаточно просто создать объект типа `Date`. Каждый новый объект хранит время (момент) его создания.
```java
Date current = new Date();
```

После выполнения этой команды переменная `current` будет хранить ссылку на созданный объект `Date`, который внутри себя будет хранить время его создания — количество миллисекунд, которое прошло с 1 января 1970 года.

## Вывод текущей даты на экран

Чтобы вывести на экран текущую дату, просто:
- создайте новый объект Date,
   ```java
   Date current = new Date();
   ```
- выведите его на экран:
   ```java
   System.out.println(current);
   ```
   ```
   Thu Feb 21 14:01:34 EET 2019
   ```
Вывод на экран расшифровывается так:

| Текст       | Расшифровка                                                  |
| ----------- | ------------------------------------------------------------ |
| Thursday    | Четверг                                                      |
| February 21 | 21 Февраля                                                   |
| 14:01:34    | часы : минуты : секунды                                      |
| EET         | Часовой пояс: East European Time (восточноевропейское время) |
| 2019        | Год                                                          |

## Задание определенной даты

Как получить текущее время мы разобрались, а как создать объект `Date`, который бы содержал другую дату или время?

Чтобы задать определенный день, нужно написать код вида:

```java
Date birthday = new Date(год, месяц, день);
```
Все относительно просто, но есть два нюанса:
- Год нужно задавать от 1900 (т.е. 1992 должен выглядеть, как `92`)
- Месяцы нумеруются с нуля.

Например, я родился 21 марта 1989 года. Март — третий месяц, значит мне нужно написать 2, так как месяцы нумеруются с нуля:

```java
Date current = new Date(89, 2, 21);
```

Месяцы нумеруются с нуля, а дни — нет. Немного странно, да?

## Задание определенного времени

Задать определенное время тоже достаточно просто, для этого нужно написать команду вида:
```java
Date birthday = new Date(год, месяц, день, час, минуты, секунды);
```
Часы, минуты и секунды нумеруются с нуля (как на электронных часах): программист внутри вас должен вздохнуть спокойно.

```java
Date current = new Date(105, 5, 4, 12, 15, 0);
System.out.println(current);
```
выведет
```
Sat Jun 04 12:15:00 EEST 2005
```

Мы задали время 12:15 и дату 4 июня 2005 года. Читается немного сложновато для не программиста, зато работает как надо.

## Миллисекунды

Как мы уже говорили, внутри объекта `Date` хранится количество миллисекунд, прошедшее с 1 января 1970 года.

Если оно нам нужно, мы можем получить его у объекта `Date`:
```java
long time = date.getTime();
```

Метод `getTime()` возвращает количество миллисекунд, которое хранится внутри объекта `Date`.

Передать такое время в объект `Date` прямо во время его создания:
```java
Date date = new Date(1117876500000L);
```

## Сравнение дат

Если вы хотите сравнить две даты и узнать, какая из них была раньше, для этого есть три способа

Способ первый — просто сравнить количество миллисекунд, которое в них хранится:
```java
if (date1.getTime() < date2.getTime())
```

Способ второй — использовать метод `before()` объекта `Date`:
```java
if (date1.before(date2))
```
Читается это так: если `date1` перед `date2`, то...

Способ третий — использовать метод `after()` объекта `Date`:
```java
if (date2.after(date1))
```
Читается это так: если `date2` после `date1`, то...

## Метод `Date.parse`

Класс `Date` умеет делать еще одну интересную и полезную вещь: получать дату из текстовой строки. Или как говорят программисты, парсить строку.

Для этого у него есть специальный метод — `parse()`. Выглядит процесс парсинга так:
```java
Date date = Date.parse("Jul 06 12:15:00 2019");
```

# Переход от класса `Date` к классу `Calendar`

Программисты любили класс `Date` за его простоту и поддержку стандартов Unix, но, как известно, наши недостатки — это продолжение наших достоинств.

Программисты хотели иметь «умный класс `Date`». И такой класс появился: им стал класс [`Calendar`](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Calendar.html). Он задумывался как инструмент не только хранения, но и сложной работы с датами.

Полное имя класса `Calendar` — `java.util.Calendar`.

Создать объект `Calendar` можно командой:
```java
Calendar date = Calendar.getInstance();
```
Статический метод `getInstance()` класса `Calendar` создаст объект `Calendar`, инициализированный **текущей датой и временем**. В зависимости от настроек компьютера, на котором выполняется программа, будет создан нужный календарь.

## Создание объекта "календарь"

Объект календарь с произвольной датой создается командой:
```java
Calendar date = new GregorianCalendar(год, месяц, день);
```

Год нужно писать полностью. Месяцы по-прежнему нумеруются с нуля, но можно использовать константы класса. А дни месяца по-прежнему нумеруются не с нуля.

Чтобы задать не только дату, но и время, нужно передать их дополнительными параметрами:

```java
... = new GregorianCalendar(год, месяц, день, часы, минуты, секунды);
```

Можно даже передать миллисекунды, если это необходимо: их указывают следующим параметром после секунд.

## Класс `DateFormat`

Помните, когда мы выводили дату на экран, отображалось что-то типа `Thu Feb 21 14:01:34 EET 2019`. Вроде бы все правильно, но это скорее отображение даты для программиста. А для пользователя хотелось бы отображать дату попонятнее. Что-нибудь типа `Вторник, 21 Февраля`.

И без года. Ну или с годом, если надо. В общем, хотелось бы отображать дату разными способами.

Для этого есть специальный класс — [`SimpleDateFormat`](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/text/SimpleDateFormat.html).

Код
```java
Date current = new Date(105, 5, 4, 12, 15, 0);
SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-YYYY");
String message = formatter.format(current);
System.out.println(message);
```
выведет на экран: `Jun-04-2005`. Совсем не то, что раньше.

А все дело в том, что мы отображали не сам объект `Date` (точнее, `Date.toString()`), а специальную строку, полученную вызовом метода `format()` у объекта типа `DateFormat`. Но ключевое здесь даже не это.

Когда объект `SimpleDateFormat` создается, в него в виде параметров мы передаем строку **"MMM-dd-YYYY"**. Вот в этой строке и зашифрован формат даты, который вы увидели в итоге на экране.

| `DateFormat` — это абстрактный класс, который обеспечивает базовую поддержку для форматирования и анализа дат, а `SimpleDateFormat` — это конкретный класс, расширяющий класс `DateFormat`.

Вот так выглядит пример создания объекта `SimpleDateFormat` и **форматированного вывода** `Date`:
```java
SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date = new Date(1212121212121L);
System.out.println(formatter.format(date));
```
В приведенном выше примере мы использовали шаблон `"yyyy-MM-dd HH:mm:ss"`, который означает:
- 4 цифры для года (`yyyy`);
- 2 цифры для месяца (`ММ`);
- 2 цифры для дня (`dd`);
- 2 цифры для часов в 24-часовом формате (`HH`);
- 2 цифры для минут (`mm`);
- 2 цифры для секунд (`ss`).
Знаки разделения и порядок расстановки символов шаблона сохраняется.

Вывод в консоль:
```
2008-05-30 08:20:12
```

Метод `parse()` класса `SimpleDateFormat` позволяет распарсить (распознать) дату из строки в объект класса `Date`:
```java
String strDate = "Sat, April 4, 2020";
SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMMM d, yyyy", Locale.ENGLISH);
try {
  Date date = formatter.parse(strDate);
  System.out.println(formatter.format(date));
}
catch (ParseException e) {
  e.printStackTrace();
}
```
Как вы видите, у нас тут появился аргумент `Locale`. Если же мы его опустим, он будет использовать значение `Locale` по умолчанию, которое не всегда является английским.

Если языковой стандарт не совпадает с входной строкой, то строковые данные, привязанные к языку, как у нас `Mon` или `April`, не будут распознаны и вызовут падение — `java.text.ParseException`, даже в том случае, когда шаблон подходит.

Можно не указывать формат, если у нас используется шаблон, который не привязан к языку. Как пример — `yyyy-MM-dd HH:mm:ss`.

Для вывода даты календаря на экран стоит воспользоваться методом `getTime()`:
```java
public static void main(String[] args) {
   SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
   Calendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25);
   calendar.set(Calendar.HOUR, 10);
   calendar.set(Calendar.MINUTE, 42);
   calendar.set(Calendar.SECOND, 12);
   calendar.roll(Calendar.MONTH, -2);
   System.out.println(dateFormat.format(calendar.getTime()));
}
```

Шаблонных букв для класса `SimpleDateFormat` довольно много:
| Символ | Описание                                                               | Пример  |
| ------ | ---------------------------------------------------------------------- | ------- |
| `G`    | эра (в английской локализации — AD и BC)                               | н.э.    |
| `y`    | год (4-х значное число)                                                | 2020    |
| `yy`   | год (последние 2 цифры)                                                | 20      |
| `yyyy` | год (4-х значное число)                                                | 2020    |
| `M`    | номер месяца (без лидирующих нулей)                                    | 8       |
| `MM`   | номер месяца (с лидирующими нулями, если порядковый номер месяца < 10) | 04      |
| `MMM`  | трехбуквенное сокращение месяца (в соответствии с локализацией)        | янв     |
| `MMMM` | полное название месяца                                                 | Июнь    |
| `w`    | неделя в году (без лидирующих нулей)                                   | 4       |
| `ww`   | неделя в году (с лидирующими нулями)                                   | 04      |
| `W`    | неделя в месяце (без лидирующих нулей)                                 | 3       |
| `WW`   | неделя в месяце (с лидирующим нулем)                                   | 03      |
| `D`    | день в году                                                            | 67      |
| `d`    | день месяца (без лидирующих нулей)                                     | 9       |
| `dd`   | день месяца (с лидирующими нулями)                                     | 09      |
| `F`    | день недели в месяце (без лидирующих нулей)                            | 9       |
| `FF`   | день недели в месяце (с лидирующими нулями)                            | 09      |
| `E`    | день недели (сокращение)                                               | Вт      |
| `EEEE` | день недели (полностью)                                                | пятница |
| `u`    | номер дня недели (без лидирующих нулей)                                | 5       |
| `uu`   | номер дня недели (с лидирующими нулями)                                | 05      |
| `a`    | маркер AM/PM                                                           | AM      |
| `H`    | часы в 24-часовом формате без лидирующих нулей                         | 6       |
| `HH`   | часы в 24-часовом формате с лидирующим нулем                           | 06      |
| `k`    | количество часов в 24-часовом формате                                  | 18      |
| `K`    | количество часов в 12-часовом формате                                  | 6       |
| `h`    | время в 12-часовом формате без лидирующих нулей                        | 6       |
| `hh`   | время в 12-часовом формате с лидирующим нулем                          | 06      |
| `m`    | минуты без лидирующих нулей                                            | 2       |
| `mm`   | минуты с лидирующим нулем                                              | 02      |
| `s`    | секунды без лидирующих нулей                                           | 1       |
| `ss`   | секунды с лидирующим нулем                                             | 01      |
| `S`    | миллисекунды                                                           | 297     |
| `z`    | часовой пояс                                                           | EET     |
| `Z`    | часовой пояс в формате RFC 822                                         | 300     |

## Работа с фрагментами даты

Чтобы получить фрагмент даты (год, месяц, ...), у класса `Calendar` есть специальный метод — `get()`. Метод один, зато с параметрами:
```java
int month = calendar.get(Calendar.MONTH);
```
Где `calendar` — это переменная типа `Calendar`, а `MONTH` — это переменная-константа класса `Calendar`.

```java
Calendar calendar = Calendar.getInstance();

int era = calendar.get(Calendar.ERA); // эра (до нашей эры или после)
int year = calendar.get(Calendar.YEAR); // год
int month = calendar.get(Calendar.MONTH); // месяц
int day = calendar.get(Calendar.DAY_OF_MONTH); // день месяца
int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // день недели
int hour = calendar.get(Calendar.HOUR); // часы
int minute = calendar.get(Calendar.MINUTE); // минуты
int second = calendar.get(Calendar.SECOND); // секунды
```

Для изменения фрагмента даты используется метод `set`:
```java
calendar.set(Calendar.MONTH, значение);
```
В метод `set` в качестве первого параметра вы передаете специальную константу класса `Calendar`, а в качестве второго параметра — новое значение.
```java
Calendar calendar = new GregorianCalendar();

calendar.set(Calendar.YEAR, 2019); // год = 2019
calendar.set(Calendar.MONTH, 6); // месяц = Июль (нумерация с 0)
calendar.set(Calendar.DAY_OF_MONTH, 4); // 4 число
calendar.set(Calendar.HOUR_OF_DAY, 12); // часы
calendar.set(Calendar.MINUTE, 15); // минуты
calendar.set(Calendar.SECOND, 0); // секунды

System.out.println(calendar.getTime()); // метод getTime() вернёт объект класса Date
```

## Константы класса `Calendar`

В классе `Calendar` есть константы не только для названия фрагментов даты.
Например, есть константы для обозначения месяцев:
```java
Calendar date = new GregorianCalendar(2019, Calendar.JANUARY, 31);
```

Или, например, для дней недели:
```java
Calendar calendar = new GregorianCalendar(2019, Calendar.JANUARY, 31);
if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
   System.out.println("Это пятница");
}
```

## Изменение даты в объекте `Calendar`

У класса `Calendar` есть метод, который позволяет проводить с датой более умные операции. Например, добавить к дате год, месяц или несколько дней. Или отнять. Называется этот метод `add()`. Выглядит работа с ним примерно так:
```java
calendar.add(Calendar.MONTH, значение);
```
Где `calendar` — это переменная типа `Calendar`, а `MONTH` — это переменная-константа класса `Calendar`.

В метод `add` в качестве первого параметра вы передаете специальную константу класса `Calendar`, и в качестве второго параметра — значение, которое нужно добавить.

Особенность этого метода в том, что он умный. Давайте сами посмотрим, насколько:

Код
```java
Calendar calendar = new GregorianCalendar(2019, Calendar.FEBRUARY, 27);
calendar.add(Calendar.DAY_OF_MONTH, 2);
System.out.println(calendar.getTime());
```
выведет на экран
```
Fri Mar 01 00:00:00 EET 2019
```
Этот метод понимает, что в феврале 2019 года всего 28 дней, и итоговая дата — 1 марта.

А теперь давайте отнимем 2 месяца! Что должно получиться? 27 декабря 2018 года! Сейчас проверим.

Чтобы выполнить действие, уменьшающее дату, нужно в метод `add()` передать значение с отрицательным знаком:

Код
```java
Calendar calendar = new GregorianCalendar(2019, Calendar.FEBRUARY, 27);
calendar.add(Calendar.MONTH, -2);
System.out.println(calendar.getTime());
```
выведет на экран
```
Thu Dec 27 00:00:00 EET 2018
```
Работает!

Этот метод учитывает длины месяцев и високосные годы.

## Прокручивание фрагментов даты

Но иногда бывают ситуации, когда такое умное поведение излишне: хочется что-то сделать с одной частью даты, не меняя все остальное.

Для этого у класса Calendar есть специальный метод — `roll()`. По своей сигнатуре он полностью аналогичен методу `add()`, но любые изменения с его помощью затрагивают один параметр, остальные остаются неизменными.

Код
```java
Calendar calendar = new GregorianCalendar(2019, Calendar.FEBRUARY, 27);
calendar.roll(Calendar.MONTH, -2);
System.out.println(calendar.getTime());
```
выведет на экран
```
Fri Dec 27 00:00:00 EET 2019
```

Месяц мы поменяли, а год и число остались неизменными.

# Новая версия классов для работы с данными

Существует и **третья** версия классов для работы с датами:

- [`LocalDate`](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/time/LocalDate.html)
- [`LocalTime`](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/time/LocalTime.html)
- [`LocalDateTime`](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/time/LocalDateTime.html)
