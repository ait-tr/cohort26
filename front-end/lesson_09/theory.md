## Spread operator (...), functions

### Spread
JavaScript spread оператор позволяет нам быстро скопировать часть существующего массива или объекта в другой массив или объект.

Пример создания массива на основе двух предыдущих: 
```javascript
const numbersOne = [1, 2, 3];
const numbersTwo = [4, 5, 6];
const numbersCombined = [...numbersOne, ...numbersTwo];
```


Spread оператор часто используется вместе с деструктурированием:
  
Первый и второй элемент сохранены в переменные, все остальные элементы массива помещены в переменную rest
```javascript
const numbers = [1, 2, 3, 4, 5, 6];

const [one, two, ...rest] = numbers;
```

### Функция
Объявление функции определяет функцию с указанными аргументами.

```
function name([param,[, param,[..., param]]]) {
[statements]
}


```
- name - Имя функции.

- paramN - Имя аргумента, переданного в функцию. Максимальное количество аргументов, которое может принять функция, может варьироваться в зависимости от движков.

- statements - Инструкции, которые составляют тело функции.

### Функциональное выражение
var myFunction = function [name]([param1[, param2[, ..., paramN]]]) {
statements
};

### Поднятие функциональных выражений
Функциональные выражения в JavaScript не поднимаются (hoisting), в отличие от объявленных функций. Вы не можете использовать функциональные выражения прежде, чем вы их определили.

### Синтаксис стрелочных функций 
```javascript
(param1, param2, …, paramN) => { statements }
(param1, param2, …, paramN) => expression
// эквивалентно: (param1, param2, …, paramN) => { return expression; }

// Круглые скобки не обязательны для единственного параметра:
(singleParam) => { statements }
singleParam => { statements }

// Функция без параметров нуждается в круглых скобках:
() => { statements }
() => expression
// Эквивалентно: () => { return expression; }
```