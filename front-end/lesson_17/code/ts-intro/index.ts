console.log("Welcome to TS");
// number, string, boolean, null, undefined, bigint, symbol

let x = 10; // пример неявного
// x = "Alena"; эта строка выдает ошибку
console.log(x);

// Как типизировать? 
// Явно vs Неявно
// Как явно задать тип переменной?
// При объявлении переменной мы указываем тип:
let y: number = 11; // пример явного - эксплитное - 
let p: string;
p = "What a wonderful day";
// 
let isDrunk: boolean = true;

// ключевое слово type
// мы можем объявлять типы отдельно:
type Age = number;   // типы всегда пишутся с большой буквы 
let myAge: Age = 29;

// Union type:   yyyy | xxxx
let k: number | string = 10;
k = "ten";
console.log(k);
// Еще примеры union
type Pet = "cat" | "dog"; // типы всегда с большой буквы
let petOfAlex: Pet = "cat";
petOfAlex = "dog";

// Можно раcширить union 
type ExtendedPet = Pet | "snake";
let myPet: ExtendedPet;
myPet = "cat";
myPet = "snake";
// Еще один пример того же самого 
// создание типов:
type Gender = "male" | "female";
type ExtendedGender = Gender | "non-binary person";
// создание переменной указанного типа 
let myGender: Gender;
// присвоим начальное значение 
myGender = "male";
// myGender = "non-binary";

// Как типизировать массив стрингов
let fruits: string[] = ["apple", "orange", "mango"];
// особенно важно указыватьтип при создании пустого массива
let vegetables: string[] = [];
vegetables.push("potatos");

// Как типизировать объекты?
// - первый способ - не предпочтительный 
// создали тип юзер 
type User = {
  firstName: string;
  isAdmin: boolean;
}

const user1: User = {
  firstName: "Wladimir",
  isAdmin: false
}
// - второй способ - очень популярный - через интерфейс 

interface Monster {
  name: string,
  height: number,
  hasTentacles: boolean,
  isAlive: boolean,
  isEvil: boolean
}

// создал объект указанного типа 
const frankestein: Monster = {
  name: "Frankestain Monster",
  height: 210,
  hasTentacles: false,
  isAlive: true,
  isEvil: true
}

// мы можем расширять интерфейсы 
// Мы можем создать нового монстра на основании интерфейса Монстра

interface ExtendenMonster extends Monster {
  isFlying: boolean;
}

const dracula: ExtendenMonster = {
  isFlying: true,
  name: "Vlad",
  height: 178,
  hasTentacles: false,
  isAlive: false,
  isEvil: true
}

// опциональные поля 
interface Food {
  title: string;
  isSweet?: boolean;
}

const pancake: Food = { title: "Pancakes", isSweet: true };
const carrot: Food = { title: "carrot" }; // не ругается, что не указали поле isSweet, поскольку оно опционально

// 
// Создать интерфейс город City
// со следующими полями
//  - name
//  - population - число горожан 
//  - riversName - опциональное поле название реки - 
//  - isTouristic - является ли туристическим или нет
//  - isCapital - является ли столицей 

// Создайте несколько объектов для этого интерфейса 

// дополнительно сделайте интерфейс - расширяющий город
// например, добавьте дату основания 

// сначала создадим тип 
interface City {
  name: string;
  population: number;
  riversName?: string;
  isTouristic: boolean;
  isCapital: boolean;
}

const berlin: City = {
  name: "Berlin",
  population: 3_600_000,
  isTouristic: true,
  isCapital: true,
  riversName: "Elba"
}

console.log(berlin);

// Типизация функций 
// Что нужно типизирвовать? Параметры, возвращаемое значение
function sum(a: number, b: number): number {
  return a + b;
}
const dev = (a: number, b: number): number => a / b;

console.log(sum(10, 12));
console.log(dev(20, 2));

function toUpper(str: ExtendedPet): string {
  return str.toUpperCase();
}

console.log(toUpper("cat"));

const nine = Number("9");
const nineStr = String(9);

// Task 1 
// Создайте функцию, которая принимает массив строк 
// и возвращает элемент массива под индексом 1

// Task 2 
// Создайте стрелочную функцию, которая принимает условный код погоды 
// (всего три вида: "sun", "strm", "fog" ) 
// и возвращает расшифровку:
// sun - "sunny"
// strm - "storm"
// fog - "foggy weather"

function getSecondElement(arr: string[]): string {
  return arr[1];
}

const res = getSecondElement(["Apple", "Orange", "Mnago"]);
console.log(res);

const getDescriptionByCode = (code: "sun" | "strm" | "fog"): string => {
  switch (code) {
    case "sun": return "sunny";
    case "strm": return "storm";
    case "fog": return "foggy weather";
    default: return "";
  }
}

console.log(getDescriptionByCode("strm"));

function printHello(): void {
  console.log("Hello");
}
