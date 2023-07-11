// Object literal 
// Пример 1:
const user = {
  name: "Sergey",
  age: 26,
  isMarried: false
};
// получить значение поля по ключу/имени
console.log(user.name);
// заменить значение по ключу 
user.name = "Anton";

// Пример 2: ключ - из нескольких слов с пробелом - не лучшая практика
const person = {
  firstName: "Bob",
  "secondName": "Smith", // 
  "has dog": true        // если свойстов состоит из двух и более слов через пробел 
  // его следует заключить в кавычки
}

console.log(person["has dog"]); // true
console.log(person.secondName);

// Пример 3
// допустим, что у нас есть имя ключа сохраненное в переменную
const key = "firstName";
const client = {
  firstName: "Frank",
  age: 45
}
console.log(client[key]); // то ключ в переменной - то используем квадратные скобки
console.log(client.key);  // undefined - получается, что такой вариант не работает

// Пример 4 
// допустим у нас были переменные со значениями 
// и мы бы хотели бы создать из них объект
const title = "Titanic";
const capacity = 1500;
// создаем объект
const titanik = { title, capacity };
console.log(titanik); // { title: 'Titanic', capacity: 1500 }

// Пример 5 
// допустим у нас были переменные, но создать объект 
// и переименовать эти ключи
const name = "Aurora";
const numberOfGuns = 20;
// если захотим сохранить под ключом title 
const aurora = {
  title: name,
  numberOfGuns
};
console.log(aurora); // { title: 'Aurora', numberOfGuns: 20 }

// Пример 6 
// метод внутри объекта
const dog = {
  name: "Bobbik",
  bark() {
    console.log("woof-woof");
  }
}
dog.bark(); // woof-woof

// Прототипное наследование - нативное для JS 
// Пример протипного наследования
// создадим объект bicycle
const bicycle = {
  brand: "Desna",
  price: 200,
  drive() {
    console.log("Driving bicycle");
  }
}
// на основании этого объекта - мы можем создать другой объект
const mountainBicycle = {
  __proto__: bicycle, // прототипом для горного велосипеда выступает велосипед
  price: 300,
  speeds: 7
}

console.log(mountainBicycle.price); // 300
console.log(mountainBicycle.brand); // "Desna"
mountainBicycle.drive();

// 2015 г. ES5, ES6

// Создайте объект транспортное средство vehicle c полями
// - speed со значением 40
// - capacity со значением 4
// - методом go (){} - который выводит в консоль фразу "Br-br-br-br"

// Создайте на основе транспортного средства - 
// объект jeep - с вместимостью 5, скоростью 60 
// numberOfDoors со значением 2 

// вызовите метод go от jeep

// *
// cоздайте bike - c полями на ваше усмотрение

// * Создайте метод accelerate - который бы увеливал скорость на 5 км 
// * Создайте метод stop - менять скорость на 0
const vehicle = {
  speed: 40,
  capacity: 4,
  go() {
    console.log("Br-br-br");
  },
  accelerate() {
    this.speed += 5;
  },
  stop() {
    this.speed = 0;
  }
};

const jeep = {
  __proto__: vehicle,
  speed: 60,
  capacity: 5,
  numberOfDoors: 2
}

jeep.go();
console.log(jeep.numberOfDoors);
console.log(jeep.speed); // 60
jeep.accelerate();       // метод изменил значение поле speed
console.log(jeep.speed); // 65
jeep.accelerate();       // метод изменил значение поле speed
console.log(jeep.speed); // 70
jeep.stop();
console.log(jeep.speed); // 0

// Class, inheritance 
// объявили класс
class Animal {
  constructor(age, name, color) {
    this.age = age;
    this.name = name;
    this.color = color;
  }
  info() {
    console.log(`Меня зовут ${this.name}. Возраст: ${this.age}`);
  }
}

// создать объект класса Animal
const monkey = new Animal(5, "Chi-chi", "brown");
monkey.info(); // console.log(`Меня зовут ${monkey.name}. Возраст: ${monkey.age}`);
console.log(monkey.age);
console.log(monkey);

// inheritance - relation between classes
class Panda extends Animal {
  constructor(age, name, color, weight) {
    super(age, name, color);
    this.weight = weight;
  }
  sleep() {
    console.log("Z-z-zz-z");
  }
}

// Создайте класс Alcohol с полями: 
// - название title
// - крепость strength
// - объем volume
// методом drink - выводит в консоль фразу "Приятно выпить <имя напитка>" 

// Создать производный класс 
// Cognac c полями: 
// age - возраст
// country - страна производства

// Создайте класс Martini c полями:
// sugarAmount - содержание сахара в процентах 

// Создайт объекты этих двух классов: мартини, конъяк

class Alcohol {
  constructor(title, strength, volume) {
    this.title = title;
    this.strength = strength;
    this.volume = volume;
  }
  drink() {
    console.log("It is nice to drink " + this.title);
  }
}

class Cognac extends Alcohol {
  constructor(title, strength, volume, age, country) {
    super(title, strength, volume);
    this.age = age;
    this.country = country;
  }
}

class Martini extends Alcohol {
  constructor(title, strength, volume, sugarAmount) {
    super(title, strength, volume);
    this.sugarAmount = sugarAmount;
  }
}

// create instances of class
const ararat = new Cognac("Ararat", 40, 0.7, 10, "Armenia");
const bianco = new Martini("Bianco", 14, 0.7, 4);

console.log(ararat);
ararat.drink();
console.log(bianco);
bianco.drink();

// Дополнительная информация 
// защищенные поля 
// создам класс квадрат с защищенным полем side
class Square {
  #side; // объявили приватное поле 
  constructor(side){
    this.#side = side;
  }
  // специльаные слова get, set 
  get side(){
    return this.#side;
  }
  // сеттер
  set side(value){
    this.#side = value;
  }
}

const square1 = new Square(4);
// используем геттер
console.log(square1.side);
// используем сеттер  
square1.side = 6;
console.log(square1.side);
console.log(square1); // Square {} // не увидели приватную переменную, она скрыта 




