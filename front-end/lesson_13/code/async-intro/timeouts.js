// асинхронный код vs синхронный 
console.log("Apple");

// код сработал с задержкой 
setTimeout(() => {
  console.log("Orange")
}, 5000);
// () => {console.log("ornage") } будет вызвана через 5 секунд

//   JS однопоточный - V8 - движок 
console.log("Banana");

// Web API - ждет 5 секунд и возвращает () => {
// console.log("Orange")
// } назад в движок V8

// сначала выполняется весь синхронный код - 
// только после этого асинхронный 

setTimeout(() => {
  console.log("Mango")
}, 0);

console.log("Lime");  // Lime вывелся до Mango

// Пример 2 
function print() {
  console.log("Print is done");
}

setTimeout(print, 3000);

// Создайте функцию clapHands()
// которая бы выводила в консоль фразу "Clap-clap" через 2 секунды
// и фразу "Bravo" через 7 секунд
// и возовите эту функцию

function printClap() {
  console.log("Clap-clap");
}

function printBravo() {
  console.log("Bravo");
}

function clapHands() {
  setTimeout(printClap, 2000);
  setTimeout(printBravo, 7000);
}

clapHands();
