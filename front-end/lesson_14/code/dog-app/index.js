const dogImageElement = document.getElementById("dog-image");

fetch("https://dog.ceo/api/breeds/image/random") // Promise<response>
  .then((response) => response.json()) // Promise<какого-то объекта>
  .then((obj) => {
    console.log(obj); // сначала посмотрели какие есть ключи в объекте 
    // в ДАННОМ случае два ключа: message и status 
    const { message } = obj; // обязательно смотрите в консоли браузера какие поля у вашего объекта
    console.log(message);
    dogImageElement.src = message; // заменяем у элемента картинка значение атрибута src 
  })

  