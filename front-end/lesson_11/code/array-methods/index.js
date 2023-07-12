// 
const brothers = [
  { race: "hobbit", height: 110, age: 45, name: "Frodo Baggins" },
  { race: "human", height: 185, age: 46, name: "Aragorn" },
  { race: "elf", height: 189, age: 110, name: "Legolas" },
  { race: "dworf", height: 140, age: 150, name: "Gimly" },
  { race: "human", height: 195, age: 200, name: "Gandalf" }
];

// 1. Метод map - отображать 
// нужен для !создания нового массива! на основании исходного массива
// Я хочу создать на основании массива наших героев, новый массив их имен 

// Пример 1 
const names = brothers.map((element) => element.name);
console.log(names); // [ 'Frodo Baggins', 'Aragorn', 'Legolas', 'Gimly', 'Gandalf' ]

// Пример 2 
// слова element/brother - это всего лишь имя переменной - может быть любым, 
// однако удобно выбирать слово в единственном числе, например, если мы работаем с массивом
// cars - перемунню в колбеке удобно car
const ages = brothers.map((brother) => brother.age);
console.log(ages); // [ 45, 46, 110, 150, 200 ]

// Пример 3 Хочу создать массив с элементами ["hobbit Frodo Baggins", "human Aragorn"...]
const racesNames = brothers.map((brother) => brother.race + " " + brother.name);
console.log(racesNames);

// Пример 4 
// высокий - это выше или равно 170 
// маленький - это ниже 170
// массив из слов [маленький, высокий, высокий, маленький, высокий]
const sizes = brothers.map((brother) => {
  if (brother.height >= 170) {
    return "высокий";
  }
  return "маленький";
});
console.log(sizes);
// то же самое через тернарник
const sizesVer2 = brothers.map((brother) => brother.height >= 170 ? "высокий" : "маленький");
console.log(sizesVer2);

// console.log(undefined >= 170);

// 2. Метод - forEach - для изменения исходного массива - мы можем мутровать элементы массива
// сделаем всех старшен на один год 
// Пример 1 
brothers.forEach((brother) => brother.age += 1);
console.log(brothers);

// Пример 2 
// сделать имена прописными буквами 
brothers.forEach((brother) => brother.name = brother.name.toUpperCase());
console.log(brothers);

// 3. reduce 
// допустим мы хотим получить сумму возрастов все наших героев 
// у нас есть массив ages
// [ 45, 46, 110, 150, 200 ]
// как бы мы это сделали с помощью цикла for: 
let sum = 0;
for (let i = 0; i < ages.length; i++) {
  sum += ages[i];
}
console.log(sum);
// как сделать при помощи reduce 
const sum2 = ages.reduce((acc, current) => acc + current, 0);
// [ 45, 46, 110, 150, 200 ]
// iteration -- acc -- current 
// 1         -- 0   -- 45
// 2         -- 45  -- 46
// 3         -- 91  -- 110
// 4         -- 201 -- 150
// 5         -- 351 -- 200
// сумммируем и возвращаем значение аккумулятора 551
console.log(sum2);

// Интересный пример: комбинация map + reduce 
// общая выоста наших героев
const totalHeight = brothers.reduce((acc, brother) => acc + brother.height, 0);
console.log(totalHeight); // 819
// можно сделать цепочку 
const totalHeight2 = brothers
  .map((brother) => brother.height) // получили массив ростов 
  .reduce((acc, height) => acc + height, 0);
console.log(totalHeight2);

// Хотим на объединить все имена через пробел 
const namesStr = brothers
  .map((brother) => brother.name)
  .reduce((acc, name) => acc + name + " ", '');
console.log(namesStr); // "FRODO BAGGINS ARAGORN LEGOLAS GIMLY GANDALF "
console.log(namesStr.trim()); // убрать пробелы по краям 
// "FRODO BAGGINS ARAGORN LEGOLAS GIMLY GANDALF"

// 1. map 
// - для создания нового массива, 
// - не изменяет старый массив === не мутирующий метод
// - возвращает новый массив

// 2. forEach 
// - когда нужно сделать операцию для каждого элемента 
// - например можем мутировать элементы массива
// - может быть мутирующим 
// - возвращает void 

// 3. reduce 
// - сведение к какому-то знчению 
// - возвращает какое-то значение 

// Другие методы:
// - split
let str = "Gandalf, Sauron, Saruman, Elrond, Tom Bombadil";
// как из этой строки получить массив имен?
const namesArr = str.split(", "); // метод сплит принимает разделитель 
console.log(namesArr); // [ 'Gandalf', 'Sauron', 'Saruman', 'Elrond', 'Tom Bombadil' ]

// как объединить обратно в строку, например через решеточку?  
// - join
const newString = namesArr.join("#");
console.log(newString); // "Gandalf#Sauron#Saruman#Elrond#Tom Bombadil"

// - find
//  возвращает первое совпадение, удовлетворябщее условию 
//  найдем того, у кого раса human 
const person = brothers.find((brother) => brother.race === "human");
console.log(person); // { race: 'human', height: 185, age: 47, name: 'ARAGORN' }

const person2 = brothers.find((brother) => brother.height <= 120);
console.log(person2); // { race: 'hobbit', height: 110, age: 46, name: 'FRODO BAGGINS' }

const person3 = brothers.find((brother) => brother.age <= 10);
console.log(person3); // undefined

// - filter 
//   возвращает все элементы, удовлетворяющие условию
//   не мутирующий 
//   возращает новый массив 
// Хочу выбрать старых - тех, кто старше 100 лет 
const oldBrothers = brothers.filter((brother) => brother.age > 100);
console.log(oldBrothers);
//[
//   { race: 'elf', height: 189, age: 111, name: 'LEGOLAS' },
//   { race: 'dworf', height: 140, age: 151, name: 'GIMLY' },
//   { race: 'human', height: 195, age: 201, name: 'GANDALF' }
// ]

// Хочу выбрать всех старых не human 

const oldNonHumans = brothers
  .filter((brother) => brother.age > 100 && brother.race !== "human");
console.log(oldNonHumans);

const odestBeeings = brothers.filter((brother) => brother.age > 500);
console.log(odestBeeings); // []
// codewars - решайте задачи начиная с 8 ки - выберите по популярности
