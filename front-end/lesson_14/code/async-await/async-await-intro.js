// просто функция которая возвращает промис
function getName() {
  return new Promise(function (resolve, reject) {
    setTimeout(() => {
      resolve("John Smith");
    }, 1000)
  })
}

console.log(getName()); // Promise { <pending> }

// как раскрыть с помощью then?
getName().then((data) => {
  console.log(data)
});

// как раскрыть с помощью синтаксиса async await
// 1. нужно сделать функцию обертку со словом async и вызвать ее
async function f() {
  // 2. использовать await
  const response = await getName(); // с помощью слова await мы можем раскрывать промисы
  console.log(response); // John Smith
}
// 3. вызвать функцию обертку
f();

// Две одинаковые функции, которые возращают промисы 5 
function getFiveVer1() {
  return new Promise(function (resolve, reject) {
    resolve(5);
  })
}
// вот то же самое c async
async function getFive() {
  return 5; // 
}

console.log(getFive()); //  Promise { 5 } - промис пятерки