const cardElement = document.getElementById("dracula-card");

async function loadDracula() {
  const response = await fetch("https://alisherkhamidov.github.io/fake-api/dracula.json");
  const obj = await response.json();
  console.log(obj);
  const { name, age, isHungry, motto, mood } = obj;
  console.log(name, age, isHungry, motto, mood); // проверим, что получили значения
  cardElement.textContent = `${name} ${age} ${motto} ${mood} ${isHungry ? "hungry" : "full"}`;
}

loadDracula();