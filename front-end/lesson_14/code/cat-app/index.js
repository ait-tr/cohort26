const catFactElement = document.getElementById("cat-fact");

fetch("https://catfact.ninja/fact")
  .then((response) => response.json())
  .then((obj) => {
    const { fact, length } = obj;
    catFactElement.textContent = `${fact} ${length}`
  })
