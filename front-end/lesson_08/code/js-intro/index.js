console.log("Welcome to JS");
console.log("Welcome to JS");

const x = "word";
let y = "orange";

// x = "strawberry"; // так нельзя 
y = "strawberry";
console.log(y);

y = 9;
// Как 
// string - примитив - "apple", 'apple'
let text = "banana"; // string

let n1 = 9;   // number
let n2 = 9.2; // number - и целые числа и с плавающей точкой
console.log(Number.MAX_SAFE_INTEGER);

let n3 = 9n; // bigint - с постфиксом n  2 в 53 степени -1

// boolean 
// true, false 
let isDrunk = true;
isDrunk = false;
let isBiggerThenTen = 11 > 10; // true

// symbol 
let s1 = Symbol('something');
console.log(s1);
// null 
let l1 = null;
console.log(l1);
// undefined 
let l2 = undefined;
console.log(l2); // undefined
let l3; // если не дали значение переменной - то в ней undefined
console.log(l3); // undefined

// Преобразование типов:
// 1. преобразование в строку 
// неявное преобразование - когда прибавляем к строке - конкатенация
let n4 = 5 + "";
console.log(typeof n4); // оператор typeof показывает тип переменной, например 'string', 'boolean'
// явное способ 
let n5 = String(5);     // number -> string
console.log(typeof n5);

let n6 = String(false); // boolean -> string
console.log(typeof n6);
console.log(n6); 'false'

console.log(typeof isDrunk === "boolean"); // true
// 2. численное преобразование
// неявное преобразование 
let n7 = +"7";
console.log(typeof n7); // number
let n8 = 9 + +"7";
console.log(typeof n8);
// явное преобразовние 
let n9 = Number("9");
let n10 = 9 + Number("7");
let n11 = Number("8$12jd");
console.log(n11);        // NaN - особое значение - not a number - когда получилось преобразовать
console.log(typeof NaN); // парадоксальным образом number 
console.log(NaN + 10);   // NaN 

// 3. Логическое преобразование 
// числа в булеан
let l5 = Boolean(0);
console.log(l5); // false
let l6 = Boolean(1);
console.log(l6); // true 
let l7 = Boolean(27);
console.log(l7); // true 
let l8 = Boolean(-27);
console.log(l8); // true
// особые случаи 
let l9 = Boolean(NaN);
console.log(l9);  // false
let l10 = Boolean(null);
console.log(l10); // false
let l11 = Boolean(undefined);
console.log(l11); // false
let l12 = Boolean("");
console.log(l12); // false
// строки в булеан
let l4 = Boolean("hey guys!");
console.log(l4);  // true
// falsy - 0, NaN, '', null, undefined - преобразуются 
// truthy - все отсальные, которые преобразуются в true

// Операторы:
// - арифметические 
let n12 = 12 + 2.7; // + сложение 
let n13 = 13 - 2.7; // - вычитание
let n14 = 13 * 2.7; // * умножение 
let n15 = 13 / 2.7; // / умножение 
let n16 = 13 % 2;   // % целечисленное деление, остаток от деления
console.log(n16);
let n17 = 13 ** 2;  // ** возведение в степень 

// - сравнение - все возвращают тип boolean 
// >, <, >=, <= 

// - равенство 
// === - без преобразования типов - строгое равенство
// ==  - с преобразованием типов  - нестрогое 
// coercion - неявное преобразование типов string number boolean
console.log(9 === "9"); // false - потому что они не равны и типы разные 
console.log(9 == "9");  // true - потому что если преобразовать тип - они будут равны 
// !==
console.log(9 !== 9);

// Массивы Arrays - динимические - то длинна может увеличиваться 
// два способа создать пустой массив:
const arr1 = [];          // первый способ создать пустой массив
const arr2 = new Array(); // второй способ создать пустой массив
// создадим массивы сразу со значением
const number = [1, 4, 8, 24, 64];
const fruits = ["apple", "orange", "mango", "banana"];
// получение элементов массива по индексам
console.log(fruits[0]);
const orange = fruits[1];
console.log(orange);
console.log(fruits); // до изменения
// изменить значение массива:
fruits[2] = "avacado";
console.log(fruits); // после изменения
// некоторые особенности 
console.log(fruits[10]); // undefined
fruits[5] = "cherry";
console.log(fruits);
console.log(fruits[4]);  // undefined

// Цикл for
for (let i = 0; i < fruits.length; i++) {
  console.log(fruits[i]);
}
// есть аналог for-each
// Цикл for...of
for (const fruit of fruits) {
  console.log(fruit);
}
// цикл while такой же как в java
let i = 0;
while (i <= 10) {
  console.log(i);
  i++;
}
// создайте массив стрингов - марки автомобилей  
// выведите значения в консоль при помощи цикла for 
// * поменяйте первое и последнее значения местами 
// и вновь распечатайте циклом  

const brands = ["BMW", "Audi", "Opel", "Kia", "Mercedes"];

for (let i = 0; i < brands.length; i++) {
  console.log(brands[i]);
}

let temp = brands[0];                  // "BMW"
brands[0] = brands[brands.length - 1]; // ["Mercedes", "Audi", "Opel", "Kia", "Mercedes"];
brands[brands.length - 1] = temp;      // ["Mercedes", "Audi", "Opel", "Kia", "BMW"];

for (let i = 0; i < brands.length; i++) {
  console.log(brands[i]);
}

// методы массивов, push - добавить в конец, pop - забрать элемент с конца

const students = ["Marina", "Alexander", "Alena"];
students.push("Wladimir");
console.log(students); // [ 'Marina', 'Alexander', 'Alena', 'Wladimir' ]
// 
const wladimir = students.pop();
console.log(wladimir); // Wladimir 
console.log(students); // [ 'Marina', 'Alexander', 'Alena']
// push + pop  === LIFO 

// методы для работы с началом shift - убрать из начала - unshift - добавитьв начало
const marina = students.shift();
console.log(marina);
console.log(students); // [ 'Alexander', 'Alena' ]
students.unshift("Ekaterina")
console.log(students); // [ 'Ekaterina', 'Alexander', 'Alena' ]
// push + shift    === FIFO
// pop + unshift   === FIFO
// unshift + shift === LIFO
// Задачи на codewars