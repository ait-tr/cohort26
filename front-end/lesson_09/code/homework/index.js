// ## Homework
// ### Задание 1
// Создайте массив из следующих элементов: "Семен", "Иван", "Петр", "Татьяна". 
// Создайте еще один массив с возрастами: 18, 27, 74, 34; 
// Создайте и заполните при помощи цикла этот новый массив новыми элементами по образу: 
// "Семен 18 лет/годов"

const names = ["Семен", "Иван", "Петр", "Татьяна"];
const ages = [18, 27, 74, 34];

const nameAndAges = [];

for (let i = 0; i < names.length; i++) {
  nameAndAges.push(names[i] + " " + ages[i] + " лет/годов");
}

console.log(nameAndAges);
// метод reverse 
const fruits = ["apple", "orange", "banana"];
const reversedFruits = fruits.reverse();
console.log(fruits);
console.log(reversedFruits);

reversedFruits[0] = "boot";

console.log(fruits);
console.log(reversedFruits);
// reverse - мутирующий метод - меняет исходный массив - это может стать большой проблемой 
// Мы можем сделать копию массива - и уже ее развернуть, тогда исходный массив останется нетронутым
// Как сделать копию?
const vegitables = ['carrot', 'potato', 'tomatos', 'corn'];
// spread syntax
const newVegitables = [...vegitables];
console.log(newVegitables);
newVegitables[0] = 'boot';
console.log(newVegitables);  // этот массив изменился - мутировал 
console.log(vegitables);     // исходный массив остался нетронутым
newVegitables.reverse();
console.log(newVegitables);

// ### Задание 2
// Используя пройденные на занятии методы массива получите
// из этого массива новый массив, в котором элементы идут в обратной последовательности.
// Ответ присылайте в личку в слак.
// push, pop, shift, unshift 
//const fruits = ["apple", "orange", "banana"];
const reversedFruits2 = [];
for (let i = 0; i < fruits.length; i++) {
  // мы идем циклом по исходному массиву -
  // берем элемиент по индексу и добавляем его в левую часть нового массива
  // за счет этого новый массив получается в обратном порядке 
  reversedFruits2.unshift(fruits[i]);
}

console.log(fruits);
console.log(reversedFruits2);