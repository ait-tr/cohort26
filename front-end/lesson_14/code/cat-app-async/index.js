const catFactElement = document.getElementById("cat-fact");

// функцию обертка
async function loadCatFact() {
  const response = await fetch("https://catfact.ninja/fact");
  const obj = await response.json();
  // console.log(obj);
  const { fact, length } = obj;
  catFactElement.textContent = `${fact} ${length}`
}

loadCatFact();

