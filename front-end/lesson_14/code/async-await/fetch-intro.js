// Fetch запрос 
// с помощью запроса мы можем получить информацию с сервера
// чтобы дождаться этой информации - нам придется раскрыть promise 

// JSON {"message":"https:\/\/images.dog.ceo\/breeds\/spaniel-brittany\/n02101388_4875.jpg","status":"success"}
// Java script object notation
// используется для хранинения информации в парах ключ значение 
// Также очень удобно передавать информацию в строках

// Давайте сделаем наш первый запрос 
// делаем запрос на внешний API - aplication programming interface - интерфейс для взаимодествия 
fetch("https://dog.ceo/api/breeds/image/random") // Promise<Response>
  .then((res) => res.json()) // Response мы должны раскрыть с помощью ассинхронного метода .json()  // метод json возвращает нам промис объекта 
  .then((obj) => console.log(obj)); // { message: 'https://images.dog.ceo/breeds/pembroke/n02113023_2482.jpg',  status: 'success'}

