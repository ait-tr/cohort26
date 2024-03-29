# Async, Await, Fetch
## Async/Await
Существует специальный синтаксис для работы с промисами, который называется «async/await». Он удивительно прост для понимания и использования.

### Асинхронные функции
Начнём с ключевого слова async. Оно ставится перед функцией, вот так:

```
async function f() {
return 1;
}
```

У слова async один простой смысл: эта функция всегда возвращает промис. Значения других типов оборачиваются в завершившийся успешно промис автоматически.

Например, эта функция возвратит выполненный промис с результатом 1:

```
async function f() {
  return 1;
}

f().then(alert); // 1
```

Можно и явно вернуть промис, результат будет одинаковым:
```
async function f() {
return Promise.resolve(1);
}

f().then(alert); // 1
```
Так что ключевое слово async перед функцией гарантирует, что эта функция в любом случае вернёт промис. Согласитесь, достаточно просто? Но это ещё не всё. Есть другое ключевое слово – await, которое можно использовать только внутри async-функций.

## Await
```
// работает только внутри async–функций
let value = await promise;
```
Ключевое слово await заставит интерпретатор JavaScript ждать до тех пор, пока промис справа от await не выполнится. После чего оно вернёт его результат, и выполнение кода продолжится.

В этом примере промис успешно выполнится через 1 секунду:

```
async function f() {

  let promise = new Promise((resolve, reject) => {
    setTimeout(() => resolve("готово!"), 1000)
  });

  let result = await promise; // будет ждать, пока промис не выполнится (*)

  alert(result); // "готово!"
}

f();
```
В данном примере выполнение функции остановится на строке (*) до тех пор, пока промис не выполнится. Это произойдёт через секунду после запуска функции. После чего в переменную result будет записан результат выполнения промиса, и браузер отобразит alert-окно «готово!».

Обратите внимание, хотя await и заставляет JavaScript дожидаться выполнения промиса, это не отнимает ресурсов процессора. Пока промис не выполнится, JS-движок может заниматься другими задачами: выполнять прочие скрипты, обрабатывать события и т.п.

По сути, это просто «синтаксический сахар» для получения результата промиса, более наглядный, чем promise.then.


**await нельзя использовать в обычных функциях**  
Если мы попробуем использовать await внутри функции, объявленной без async, получим синтаксическую ошибку:
```
function f() {
  let promise = Promise.resolve(1);
  let result = await promise; // SyntaxError
}
```
## Обработка ошибок

Когда промис завершается успешно, await promise возвращает результат. Когда завершается с ошибкой – будет выброшено исключение. Как если бы на этом месте находилось выражение throw.

Такой код:
```
async function f() {
  await Promise.reject(new Error("Упс!"));
}
```
Делает то же самое, что и такой:

```
async function f() {
  throw new Error("Упс!");
}
```

Но есть отличие: на практике промис может завершиться с ошибкой не сразу, а через некоторое время. В этом случае будет задержка, а затем await выбросит исключение.

Такие ошибки можно ловить, используя try..catch, как с обычным throw:

```
async function f() {

try {
let response = await fetch('http://no-such-url');
} catch(err) {
alert(err); // TypeError: failed to fetch
}
}

f();
```

В случае ошибки выполнение try прерывается и управление прыгает в начало блока catch. Блоком try можно обернуть несколько строк:
```
async function f() {

try {
let response = await fetch('/no-user-here');
let user = await response.json();
} catch(err) {
// перехватит любую ошибку в блоке try: и в fetch, и в response.json
alert(err);
}
}

f();
```

## Fetch API 

JavaScript может отправлять сетевые запросы на сервер и подгружать новую информацию по мере необходимости.

Например, мы можем использовать сетевой запрос, чтобы:
- Загрузить информацию о пользователе,
- Запросить последние обновления с сервера

Чтобы сделать запрос, необходимо восользоваться специальной функцией fetch():


```
const response = await fetch(resource[, options]);
```
Эта функция принимает два аргумента, (квадратные скобки означают, что аргумент опционален)
- resource:  URL строка
- options: опциональные характеристики, например: method, headers, body, credentials 

fetch() запускает запрос и возвращает promise. Когда запрос удовлетворяется, promise разрешается(resolved) объектом ответа (Response object)
Если ответ не получается получить из-за, например, неполадок сети, promise отклоняется (promise is rejected).

async/await синтаксис очень помогает при работе с fetch(),
поскольку он упрощает работу с промисами синтаксическим сахаром. 

Для примера сделаем запрос, чтобы получить информацию о фильмах:
```
async function fetchMovies() {
  const response = await fetch('/movies');
  // waits until the request completes...
  console.log(response);
}
```
Когда запрос завершается, response присваивается значение response object. 

Давайте рассмотрим, как извлекать полезные данные, такие как JSON, из ответа.


## Fetch JSON

Объект ответа (response object), возвращаемый await fetch(), является обобщенным объектом для хранения разных видов информации.

Например, можно извлечь JSON объект из fetch response:
```
async function fetchMoviesJSON() {
  const response = await fetch('/movies');
  const movies = await response.json();
  return movies;
}

fetchMoviesJSON().then(movies => {
  movies; // fetched movies
});
```
response.json() это метод Response объекта, который позволяет JSON object`у быть извлеченным из response. 
Метод этот тоже возвращает promise, поэтому его тоже необходимо дожидаться при помощи await: 
```
await response.json()
```
