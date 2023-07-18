### Event Loop, setTimeout, setInterval, Promise, then

## Event Loop 

С помощью механизма Event Loop (Цикл событий) становится возможным выполнять асинхронный код в JavaScript.  
  
Event Loop - это специальный механизм на уровне движка js, который координирует работу трёх сущностей:   
- Call Stack (стэк вызовов)   
- Web API (API, предоставляемый браузером)  
- Callback Queue (очередь колбэков)    

<img src="https://joprblob.azureedge.net/site/blog/8e147efe-422d-42c3-bb51-61ca50d660dc/event.png" width="1000">

## setTimeout

Это метод, позволяющий вызвать функцию один раз через определённый промежуток времени.  

```
setTimeout(() => {
    console.log("Hey, timeout!");
}, 3000) 

// в консоли получим результат "Hey, timeout!" спустя 3 секунды
```

## setInterval  

Это метод, позволяющий вызывать функцию регулярно, повторяя вызов через определённый интервал времени.  

```
const ourInterval = setInterval(() => {
    console.log("Буду появляться каждые 5 секунд");
}, 5000)

// в консоли будет непрерывно появляться фраза "Буду появляться каждые 5 секунд" до тех пор, 
// пока мы не остановим выполнение функции setInterval
```
## clearInterval

Это метод, позволяющий прекратить выполнение функции setInterval.  

```
setTimeout (() => {
    clearInterval(ourInterval)
}, 10000)

// переменная ourInterval берется из предыдущего примера
```

## Promise

Это объект, представляющий результат успешного или неудачного завершения асинхронной операции.  

Имеет 3 состояния:
- pending /ожидание
- fulfilled /выполнено
- rejected /отклонено

Промис создается при помощи конструктора new Promise. А сам new Promise принимает в себя какую-то функцию, аргументами которой являются:   
- resolve - в случае исполнения промиса
- rejected - в случает невыполнения промиса
```
let promise = new Promise(function(resolve, reject) {
    setTimeout(() => {
        resolve(5)
    }, 3000)
})
```

Если хотим обработать результат промиса, используем .then

```

let promise = new Promise(function(resolve, reject) {
    setTimeout(() => {
    resolve(5)
    }, 3000)
    })
    
    promise.then((value) => {
        console.log(value);
    })
```

Если хотим отловить ошибку, используем .catch

```
let promice2 = new Promise(function(resolve, reject) {
    setTimeout(() => {
        reject (new Error("Ошибкааааа!!!!!"))
    }, 4000)
})

promice2.catch((err) => console.log(err))
```


# Полезные источники:  
- Статья про Event Loop: [ссылка](https://dev.to/lydiahallie/javascript-visualized-event-loop-3dif)
- Еще статья про Event Loop: [ссылка](https://habr.com/ru/articles/461401/)
- Онлайн визуализатор Event Loop: [ссылка](http://latentflip.com/loupe/?code=!!!PGJ1dHRvbj5DbGljayBtZSE8L2J1dHRvbj4%3D)
- Теория по Event loop: [ссылка на учебник learn.js](https://learn.javascript.ru/event-loop)
- Полезное видео от Минина про Event loop: [ссылка на видео Минина](https://www.youtube.com/watch?v=vIZs5tH-HGQ)
- Для тех, кто хочет покопаться и понять, как устроены архитектура и движок браузера: [ссылка на видео Ulbi TV](https://www.youtube.com/watch?v=zDlg64fsQow)
- Теория по promise: [ссылка на учебник learn.js](https://learn.javascript.ru/promise-basics)
- Презентация по промисам: [ссылка](https://github.com/ait-tr/cohort24/blob/main/front_end/lesson_13/promise.pdf)

