# Тип `boolean`

Чтобы было удобно работать с выражениями, которые могут быть истинными или ложными, в Java добавили специальный тип — `boolean`. Его главная особенность заключается в том, что переменные этого типа могут принимать всего два значения: `true` (истина) и `false` (ложь).

Никакие другие значения присвоить переменным типа `boolean` невозможно. Компилятор не позволит.

В него можно сохранять значения логических выражений. 


boolean isOK = true;

boolean hasError = false;

int age = 70;
boolean isSenior = (age > 65);

int record = 612;
int value = 615;
boolean hasNewRecord = (value > record);

int min = 0;
int max = 100;
int temperature = -20;
boolean isIce = (temperature < min);
boolean isSteam = (temperature > max);
```

# Операторы сравнения

В Java, как и в других языках программирования, часто приходится сравнивать переменные между собой. И именно для сравнения в Java есть такие операторы:

|Оператор|Пояснение|Пример|
|-|-|-|
|`<`|Меньше|`a < 10`|
|`>`|Больше|`b > a`|
|`<=`|Меньше или равно|`a <= 10`|
|`>=`|Больше или равно|`speed >= max`|
|`==`|Равно|`age == 18`|
|`!=`|Не равно|`time != 0`|

Результатом действия каждого из приведенных операторов будет логическое выражение. Его можно сохранить в переменную типа `boolean`, ну или использовать в качестве условия в `if`.

Операторы, состоящие из двух символов, разрывать нельзя.

`a < = 10` — такой код компилироваться не будет.

