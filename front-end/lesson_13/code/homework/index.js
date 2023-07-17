const formElement = document.getElementById("todo-form");
const listElement = document.getElementById("todo-list");
// const showBtnElement = document.getElementById("show-tasks");

const tasks = [];

const addTask = (event) => {
  event.preventDefault();
  // event.target             - эта вся форма
  // event.target.title       - это инпут <input type="text" placeholder="title" name="title">
  // event.target.title.value - это что пользователь ввел в инпут
  // Получаем информацию из инпутов:
  const title = event.target.title.value;
  const description = event.target.description.value;
  // Очищаем поля:
  event.target.title.value = "";
  event.target.description.value = "";
  // console.log(title, description);
  // добавляем в массив новый task
  tasks.push({ title, description, done: false });
  console.log(tasks);
  // отображаем в html коде
  renderTasks();
}

function renderTasks() {
  // очистим ul от всего
  while (listElement.hasChildNodes()) {
    listElement.firstChild.remove();
  }
  // добавим детей 
  tasks.forEach((task) => {
    const li = document.createElement("li"); // <li></li>
    const checkBox = document.createElement('input');  // <input>
    checkBox.type = "checkbox";   // 
    checkBox.checked = task.done; // этот атрибут отвечает за то - есть ли галочка внутри квадрата - true -есть 
    checkBox.onclick = () => { // меняем статус в массиве на противоположный
      task.done = !task.done;
    }
    li.append(checkBox);          // <li> <input type="checkbox"> </li>
    const textNode = document.createTextNode(`${task.title} ${task.description}`);
    li.append(textNode) //        // <li> <input type="checkbox"> "asdasd asdasdasd"</li>
    console.log(li);
    // как изменить 
    listElement.append(li);
  })
}


formElement.addEventListener('submit', addTask);



