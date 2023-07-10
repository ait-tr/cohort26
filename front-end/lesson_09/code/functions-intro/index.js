'use strict'
// Spread synthax 
const fruits = ["apple", "mango"];
const fruits2 = [...fruits]; // новый массив ["apple", "mango"]
// могу скопировать и добавить новый элемент
const peach = "peach";

const fruits3 = [...fruits, peach];
// скопировали все элементы исходного массива,
// добавили через запятую все что хотели добавить, в данном случае персик
console.log(fruits3); // [ 'apple', 'mango', 'peach' ]
const fruits4 = [peach, ...fruits];
console.log(fruits4); // [ 'peach', 'apple', 'mango' ]

const cars1 = ["bmw", 'citroen'];
const cars2 = ['audi', 'mercedess'];
// как объединить эти два массива в третий при помощи spread
const allCars = [...cars1, ...cars2];
console.log(allCars);

// Array destructuring assignment - деструктуризация массива 
// - когда вычленяем элемент и сохраняем его в отдельную переменную
const catBreeds = ["British", "Siam", "Mai-kun", 'Sphynx'];
// как я взять строку из массива и сохранить в переменную? старая версия - как в java
let british = catBreeds[0];
// но можно сделать по-другому
// сохраним все значения в отдельные переменные - деструктуризация 
const [british1, siam, maikun, sphynx, pers] = catBreeds;
console.log(siam); // siam
console.log(pers); // undefined

// можно сохранять не все переменные 
const capitals = ["Berlin", "Paris", "London", "Rome"];

const [first, , london] = capitals; // то есть мы выбрали только первый и третий элементы
console.log(first); // Berlin
console.log(london); // London

// Functions
// объявление функции - декларация - declaration
// можем объявить функцию, используя слово function
// printRome();  - если вызвать функциюдо объявления - hoisting - поднятие 
function printRome() {
  console.log("Rom");
  console.log(" - eternal city");
}
// вызов функции - call 
printRome();

// мы можем передать аргументы/параметры
// объявление
function sum(a, b) {
  return a + b;
}
// вызов
let res = sum(10, 15);
console.log(res); // 25

// Function expression - Фукнциональное врыажение
// const subtraction = function subtraction (a, b) {
//   return a - b;
// }
const subtraction = function (a, b) {
  return a - b;
}

let dif = subtraction(15, 10);
console.log(dif); // 5

// функцию которая будет принимать другие функции в качестве параметров
// a - число, b - число, operationFunction - функция 
function calculate(a, b, operationFunction) {
  return operationFunction(a, b);
}

let calcRes = calculate(22, 13, subtraction);
console.log(calcRes);

// Создайте функцию с именем helloEng  (используйте функциональное выражение)
// пусть метод принимает два параметра - firstName, secondName
// и пусть вывод фразу в консоль "Good day, <firstName> <secondName>"
// пример helloEng("John", "Smith"); // "Good day, John Smith"

// Создайте метод с именем helloTurkish 
// пусть метод принимает два параметра - firstName, secondName
// и пусть вывод фразу в консоль "Merhaba, <firstName> <secondName>"
// пример helloEng("John", "Smith"); // "Merhaba, John Smith"

// Создайте функцию universalHello(fistName, secondName, greetingFunction);
// Пример вызова: universalHello("Kate", "Wales", helloEng); //"Good day, Kate Wales" 

const helloEng = function (firstName, secondName) {
  console.log("Good day, " + firstName + " " + secondName);
};
helloEng("Marina", "Danilov");

const helloTurkish = function (firstName, secondName) {
  console.log("Merhaba, " + firstName + " " + secondName);
};
helloTurkish("Marina", "Danilov");

const helloSerbs = function (firstName, secondName) {
  console.log("Здраво, " + firstName + " " + secondName);
};
helloSerbs("Marina", "Danilov")

const universalHello = function (firstName, secondName, greetingFunction) {
  greetingFunction(firstName, secondName);
}

universalHello("Luka", "Gavric", helloSerbs); // передаем два стринга и функцию

// Arrow Function - стрелочная функция 
// блочный вариант
const multiply = (a, b) => {
  return a * b; // statement
}

const resOfMultiplication = multiply(5, 12);
console.log(resOfMultiplication); // 60

// то же самое, но в одну строку
const multiplyVer2 = (a, b) => a * b; // a * b - это expression

// 
universalHello(
  "Maiia",
  "Kats",
  (firstName, secondName) => console.log("Shalom, " + firstName + " " + secondName)
  // стрелочная функция выше - безымянная функция - нельзя вызвать повторно
)

// Еще один пример 
// функция принимает три параметра: два стринга и функцию - метод приготовления
function cook(ingredient1, ingredient2, cookingFunction) {
  cookingFunction(ingredient1, ingredient2)
}
// первый метод приготовления - варка
function boil(ingredient1, ingredient2) {
  console.log("Варю " + ingredient1 + " и " + ingredient2);
}
// можно передать прописанную заранее функцию
cook("картофель", "морковь", boil); // Варю картофель и морковь
// а можно ad hoc - стрелочную функцию
cook("картофель", "шампиньоны",
  (a, b) => console.log("Жарю " + a + " и " + b)
);

//  Шаблонные строки, то что было String format
// Можем конкатенировать через плюс 
let firstName = "Gustav";
let secondName = "Feurbach"
let fullName = firstName + " " + secondName;
console.log(fullName);
// через шаблонные строки, `example` - backticks - обратные кавычки - бэктики
let fullName2 = `${firstName} ${secondName}`;
console.log(fullName2);

let text = `Уважаемый мистер ${secondName}, до нас дошли слухи о том, что вас зовут ${firstName}.`;
console.log(text);

cook("картофель", "шампиньоны",
  (a, b) => console.log(`Готовлю на пару ${a} и ${b}`)
);

// напишите метод printArray, который принимает массив из двух стрингов
//  и выводит в консоль следующую фразу
// "<first> - стоял на первом месте, а <second> на втором"
// Пример вызова:
// printArray(["apple", "juice"]); // "apple - стоял на первом месте, а juice на втором"

// при объявлении - function printArray(arr) и тд ...

function printArray(arr){
  const [first, second] = arr;
  console.log(`${first} стоял на первом месте, а ${second} на втором`);
}

printArray(['Дуб', 'Ясень']);

// вторая версия - еще короче  - дополнительная информация 
// деструктурируем массив прямо в скобках параметров
function printArray2([first, second]){
  console.log(`${first} стоял на первом месте, а ${second} на втором`);
}

printArray2(['Дуб', 'Ясень']);


// Задание со звездочкой 
// ([[name, name2], [age1, age2]])
// printOldest([["smith", "johnes"], [18, 26]]); //  Johnes старше Smith
