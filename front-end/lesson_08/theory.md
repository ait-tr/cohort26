## JS intro

Ссылка на презентацию: [ссылка](https://github.com/ait-tr/cohort22/blob/main/front_end/lesson_12/js.pdf)

Учебник по JS:   [ссылка](https://learn.javascript.ru/)

## Примитив (значение примитивного типа, примитивный тип данных)
Примитив - это данные, которые не являются объектом и не имеют методов. В JavaScript имеется 7 простых типов данных: string, number, boolean, null, undefined, symbol (новое в ECMAScript 2015), bigint.

##  Преобразование типов (coercion)
Когда сравниваются разные типы, движок JavaScript производит попытку привести тип одного элемента к типу другого, чтобы он мог их сравнить
Приоритет преобразований:
1. String
2. Number
3. Boolean

## Два способа создания пустого массива
-  let arr = new Array();
   let arr = [];
- // В квадратных скобках можно сразу указать начальные значения
- let fruits = ["Apple", "Orange", "Banana"];

- Можно получить элемент по индексу
  let fruits = ["Apple", "Orange", "Banana"];
- Получим нулевой элемент
  console.log(fruits[0]); // Apple

-  Можно заменить элемент по идексу
   fruits[0] = "Mango"
   console.log(fruits[0]); // ["Mango", "Orange", "Banana"];

## Методы Array:
- push - добавляет элемент в конец массива:
- pop - удаляет последний элемент из массива и возвращает его
- shift - удаляет элемент из начала массива
- unshift - добавляет элемент в начало массива