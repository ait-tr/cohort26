# Повторение
## Собственные исключения

`throw` - англ. *выбросить* -  издать сигнал об аварии.

После `throw` мы создаём конкретный сигнал - `new IllegalArgumentException("Всё пропало!")`.

Выбрасывание исключения работает как аварийный сигнал - всё очень плохо, дальше продолжать бессмысленно.

Если исключение не поймать, то завершится вообще вся программа.

## `Object.equals(Object obj)`

Метод `public boolean Object.equals(Object obj)` сравнивает объекты: возвращает `true`, если они равны, и `false`, если не равны.

Аргумент метода - то, с чем мы сравниваем объект (т.е. сравниваем `this` и `obj`).

Правила, которым должен подчиняться метод:
1. Объект должен быть равен самому себе.
2. При переопределении `equals()` надо переопределить `hashCode()`.

Mетод `equals()` сравнивает объекты внутри системных методов **Java**, например:
- ищет объект в списке (`list.indexOf()`)
- проверяет совпадение ключей словаря или элементов множества
- и т.д.

Следовательно, если мы хотим научить **Java** сравнивать наши объекты, мы обязаны перезаписать метод `public boolean Object.equals(Object obj)`, а следовательно, и `public int Object.hashCode()`.

Если метод не переписать, то `Object.equals(Object obj)` сравнивает ссылки.

## `Object.hashCode()`

При переопределении `equals()` надо переопределить `hashCode()`.
Правила:
1. Для одинаковых объектов **нужно** возвращать одинаковое число.
2. ***Хорошо бы*** возвращать разные числа для разных объектов.
Что такое одинаковые, определяет метод `equals()`.

Метод `public int Object.hashCode()` используется для ускорения работы всего, у чего в названии есть слово **Hash**.

При попытке выяснить, есть ли такой объект в `HashSet` или в ключах `HashMap`, сначала **вычисляется хэш объекта** и потом объект сравнивают с имеющимися объектами, но не со всеми, а только **с таким же хэшем**.

Если хэш разный, то объекты считаются разными и даже не сравниваются ;(это относится только к **HashЧтоНибудь**).

Если хэш одинаковый, то объекты сравниваются через `equals()`.

Фактически, `hashCode()` используют для **ускорения** сравнения.

Идеально, если у всех разных объектов будут разные хэши.

Если все хэши одинаковые, то **HashЧтоНибудь** работает **очень медленно** - с таким же успехом можно складывать в список и перебирать вручную, каждый сравнивая каждый с каждым.

Оригинальный `Object.hashCode()` для разных ссылок выдаёт разные хэши,
приходится **перезаписывать**, чтобы для разных в памяти, но **одинаковых по мнению `equals()`** объектов хэш получался **одинаковым**.

## Примечание

Методы `equals()` и `hashCode()` обычно генерируют, а не пишут самостоятельно.

[Чуть-чуть больше про хэш и коллизии](https://blog.skillfactory.ru/glossary/hashmap/)
