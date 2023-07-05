// console.log("*************");
// // const и let - объявление переменных в js
// // Результат консоль лога можем посмотерть в браузере в инстр. раз. во вкладке console
// console.log("Hello, JS!");
// let x = 2;
// let word = "apple";
// // let - объявление переменной 
// // const - объявление константы
// x = 4;
// word = "orange";
// const y = 10;
// // y = 12; // здесь будет ошибка - нельзя присвоить новое значение константе
// console.log(word); // orange
// console.log(y);    // 10

// word = 10;
// console.log(word);
// console.log("**************");

// DOM - document object model
const btnElement = document.getElementById("btn-boom");
console.log(btnElement);
const btnChangeColorElement = document.getElementById("btn-change-color");
console.log(btnChangeColorElement); // вывожу в консоль, чтобы убедиться, что все ок
const textElement = document.getElementById("text");
console.log(textElement);

// повесили на элемент слушатель событий
btnElement.addEventListener('click', () => {
  console.log("Boom-boom-boom");
});

// добавим слушатель события на кнопку изменения цвета 
btnChangeColorElement.addEventListener('click', () => {
  console.log("Нажали на кнопку изменить цвет");
  textElement.style.color = "green"; // мутирую свойства объекта 
  // в данном случае мы поменяли значения свойсва color 
  // как поменять имя класса? className
  textElement.className = "green-text";
  // как поменять цвет фона? background-color   --> backgroundColor
  textElement.style.backgroundColor = "lightgrey";
  textElement.style.padding = "10px";
  // id тоже можно поменять таким образом 
});

// Создайте в html элемент div с текстом Синий квадрат
// Добавьте в html кнопку button c текстом Сделать квадрат черным
// не забудьте задать квадрату ширину и высоту

// напишите js код, чтобы при нажатии на кнопку Квадрат становился 
// черным с бордер радиус 10px
// отловите кнопку кнопку и квадрат по id 
// создайте event listener для кнопки 
// пропишите в ивент листенере изменения свойств 

// Решение
// 1. Отловим нужные элементы
// отловили квадрат
const boxElement = document.getElementById("box");
console.log(boxElement);
// отловим кнопку 
const btnChangeBoxElement = document.getElementById("change-box-btn");
console.log(btnChangeBoxElement);
// добавим слушатель событий
btnChangeBoxElement.addEventListener('click', () => {
  if (boxElement.style.backgroundColor === "black") {
    boxElement.style.backgroundColor = "blue";
    boxElement.innerText = "Blue box";
    // innerText - возращает видимый текст
    // textContent - возвращает еще и с тегами
  } else {
    boxElement.style.backgroundColor = "black";
    boxElement.innerText = "Black box";
    boxElement.style.color = "white";
  }
  boxElement.style.borderRadius = "10px";
});

// Кнопка для удаления 
// 1. отловим кнопку 
const btnDeleteBoxElement = document.getElementById("delete-box");
// 2. добавим слушатель событий
btnDeleteBoxElement.addEventListener('click', () => {
  boxElement.remove();
});

// Как создать новый узел, то есть новый элемент и прикрепить его к документу?
// Создание нового узла
const newElement = document.createElement('p'); // создали пустой элемент с тегом p
// <p></p>
newElement.innerText = "Кажется, я начинаю понимать DOM";
// <p>Кажется, я начинаю понимать DOM</p>
newElement.id = "new-text";
// <p id="new-text">Кажется, я начинаю понимать DOM</p>
newElement.style.fontSize = "25px";
// теперь когда мы создали новый элемент мы можем его прикрепить
// давайте сделаем для этого кнопку
// 1. отловим кнопку 
const btnAddElement = document.getElementById("add-text");
// 2. добавим слушатель события
btnAddElement.addEventListener("click", () => {
  // console.log("Добавление"); посмотрели работает ли кнопка - при помощи console.log
  // чтобы прикрепить созданный узел к документу:
  // в данном слчае прикреплятся будет к document.body, а можно было бы выбрать и другой элемент
  document.body.appendChild(newElement); // добавляет после всех
  // кудаПрикрепляем.appendChild(чтоПрикрепляем);
  // document.body.prepend(newElement); // добваляет первым узлом
});

// Создадим изображение и прикрепим его к стрaнице
const newImageElement = document.createElement('img');
const btnAddImageElement = document.getElementById("add-img");
// console.log(newImageElement); // <img>
newImageElement.src = "https://images.unsplash.com/photo-1618897996318-5a901fa6ca71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTZ8fHxlbnwwfHx8fHw%3D&auto=format&fit=crop&w=800&q=60";
// console.log(newImageElement); // 
newImageElement.style.width = "250px";
// создадим кнопку для прикрепеления изображения

btnAddImageElement.addEventListener('click', () => {
  document.body.appendChild(newImageElement);
});


