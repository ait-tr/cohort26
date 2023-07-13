const plusBtnElement = document.getElementById("plus");
const minusBtnElement = document.getElementById("minus");
const counterElement = document.getElementById('counter');

// console.log(plusBtnElement); // проверили, что элементы сохранились
// console.log(minusBtnElement);
// console.log(counterElement);

let counter = 0;

const plusHandler = () => {
  counter++;
  counterElement.innerText = counter;
}

const minusHandler = () => {
  counterElement.innerText = --counter; // cделали декремент в одну строку
}

plusBtnElement.addEventListener('click', plusHandler);
minusBtnElement.addEventListener('click', minusHandler);



// Первый вариант
// plusBtnElement.addEventListener('click', () => {
//   // console.log("Работает!"); // проверили, что listener добавился
//   // counterElement.innerText = Number(counterElement.innerText) + 1;
//   counter++;
//   counterElement.innerText = counter;
// });