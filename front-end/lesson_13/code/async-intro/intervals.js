// Интервалы 
setInterval(() => {
  console.log("Tick");
}, 5000) // будет вызовать функцию-колбек каждые пять секунд



const interval = setInterval(() => {
  console.log("Clap"); // задали интервал 
}, 1000);

setTimeout(() => { // остановили интервал через пять секунд 
  clearInterval(interval);
}, 5000);

