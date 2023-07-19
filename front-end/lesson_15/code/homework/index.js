const titleElement = document.getElementById("title");
const yearElement = document.getElementById("year");
const authorElement = document.getElementById("author");
const genreElement = document.getElementById("genre");
const imageElement = document.getElementById("book-image");

async function loadBook() {
  const res = await fetch("https://alisherkhamidov.github.io/book-api/book.json");
  const obj = await res.json();
  console.log(obj); // {title: 'The Lord Of The Rings', author: 'Tolkien', year: 1954, genre: 'fantasy', cover: 'https://covers.openlibrary.org/b/id/10654730-L.jpg'}
  
  const { title, author, year, genre, cover } = obj;
  titleElement.textContent = title;
  yearElement.textContent = year;
  authorElement.textContent = author;
  genreElement.textContent = genre;
  imageElement.src = cover;
}

loadBook(); // не забываем вызвать функцию


// гит инит СУПЕР ВАЖНЫЙ МОМЕНТ СМОТРЕТЬ НА ТО В КАКОЙ ПАПКЕ ВЫ НАХОДИТЕСЬ В ТЕРМИНАЛЕ
// cd homework
// текущая папка слева выделена большими буквами: HOMEWORK

// git init 
// Команды ниже мы скопировали в браузере
// git remote add origin git@github.com:AlisherKhamidov/book.git // замените адрес
// git add .
// git commit -m "init"
// git branch -M main
// git push -u origin main