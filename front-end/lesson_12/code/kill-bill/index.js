const formElement = document.getElementById("form");
const listElement = document.getElementById("persons-list");
const clearBtnElement = document.getElementById("clear");
const clearOneBtnElement = document.getElementById("clear-one");

const persons = [];

const clearList = function () {
  // функция, которая удаляет всех детей у листа ul
  while (listElement.hasChildNodes()) { // пока есть дети лист элемент
    listElement.firstChild.remove();    // удаляю первого ребенка и иду на следущуюитерацию
  }
}

const clearOne = function () {
  if (listElement.hasChildNodes()) {
    listElement.firstChild.remove();
  }
}

function clearInputs(event) {
  event.target.nickname.value = "";
  event.target.place.value = "";
}

function changeStatus(event) {
  if (event.target.style.textDecoration === "line-through") {
    event.target.style.textDecoration = "none";
  } else {
    event.target.style.textDecoration = "line-through";
  }
}

clearBtnElement.addEventListener('click', clearList);
clearOneBtnElement.addEventListener('click', clearOne);

formElement.addEventListener('submit', (event) => {
  event.preventDefault(); // предотвращает переход на другую страницу
  // console.log(event.target);
  // event.target.ИМЯ_ПОЛЯ_ИНПУТА.value
  // console.log(event.target.nickname.value);
  // console.log(event.target.place.value);
  const person = {
    name: event.target.nickname.value,
    place: event.target.place.value
  };
  persons.push(person);
  const liElement = document.createElement('li'); //  создали <li></li>
  liElement.textContent = `${person.name} ${person.place} 🥷🏻`; // <li>Bill Texas</li>
  liElement.onclick = changeStatus;

  listElement.append(liElement); // прикрепить
  // сбросим поля 
  // event.target.nickname.value = "";
  // event.target.place.value = "";
  clearInputs(event); // вызвали очистку полей - сама функция объявлена выше 
});


