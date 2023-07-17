
// Promise - обещание 

// Обозначим проблему, чтобы понять зачем промисы нужны нам 
function getSix() {
  setTimeout(() => {
    return 6;
  }, 4000);
}

let x = getSix();
console.log(x); // undefined синхронный код не ждал пока выполнится асинхронный

// 
function getSeven() {
  return new Promise(function (resolve, reject) {
    setTimeout(() => {
      resolve(6);
    }, 4000);
  });
}

const promise = getSeven();
console.log(promise); // Promise { <pending> }
// pending - ожидается 
// resolved - успешно разрешено со значение 
// rejected - когда не получилось дождаться - отклонено

// Нам нужно дождаться значения, чтобы его получить 
promise.then((data) => {
  // data - это переменная в которой мы получили значение, которое ждали 
  // название переменной может быть любым
  console.log(data);
});
// с помощью метода промиса then мы можем получать из промиса значение

function getSevenRej() {
  return new Promise(function (resolve, reject) {
    setTimeout(() => {
      reject(new Error("Ошибка сервера"));
    }, 4000);
  });
}

const promise2 = getSevenRej();
promise2
  .then((data) => {
    console.log(data); // а значения попадают в then
    // с data мы можем работать только здесь 
  })
  .catch((e) => {     // ошибки от rej попадают в catch
    console.log(e);
  })


// функция принимать имя пользователя- 
// если имя John - будет резолвить
// если нет - то будет реджектить

function getAgeOfUserByName(name) {
  return new Promise(function (resolve, reject) {
    if (name === "John") {
      setInterval(() => {
        resolve(18);
      }, 3000);
    } else {
      setInterval(() => {
        reject(new Error(`Wrong name: ${name}, access denied`));
      }, 3000);
    }
  });
}

getAgeOfUserByName("John")
  .then((data) => console.log(data)) // 18
  .catch((e) => console.log(e));

getAgeOfUserByName("Anna")
  .then((data) => console.log(data))
  .catch((e) => console.log(e))
  // Error: Wrong name: Anna, access denied
  // at Timeout._onTimeout (/Users/aliserkhamidov/Ait/cohort26/front-end/lesson_13/code/async-intro/promises.js:68:16)
  // at listOnTimeout (node:internal/timers:564:17)
  // at process.processTimers (node:internal/timers:507:7)
