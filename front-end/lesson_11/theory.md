# Методы массивов

## Метод map()   
[_узнать больше_](https://developer.mozilla.org/ru/docs/Web/JavaScript/Reference/Global_Objects/Array/map)  

создаёт новый массив с результатом вызова указанной функции для каждого элемента массива.

### Синтаксис (в квадратных скобках необязательные параметры)
```
const new_array = arr.map(function callback( currentValue[, index[, array]]) {
    // Возвращает элемент для new_array
}[, thisArg])
```
Параметры
- **callback** Функция, вызываемая для каждого элемента массива arr. Каждый раз, когда callback выполняется, возвращаемое значение добавляется в new_array.
- **thisArg** - Необязательный параметр. Значение, используемое в качестве this при вызове функции callback
Функция callback, создающая элемент в новом массиве, принимает три аргумента:

- **currentValue** - Текущий обрабатываемый элемент массива.
- **index** Необязательный - Индекс текущего обрабатываемого элемента в массиве.
- **array** Необязательный - Массив, по которому осуществляется проход.

Возвращаемое значение
Новый массив, где каждый элемент является результатом callback функции.

## Array.prototype.reduce() 
[_узнать больше_](https://developer.mozilla.org/ru/docs/Web/JavaScript/Reference/Global_Objects/Array/reduce)
  
Метод reduce() применяет функцию reducer к каждому элементу массива (слева-направо), возвращая одно результирующее значение.

### Синтаксис
```array.reduce(callback[, initialValue])```

- **callback** - Функция, выполняющаяся для каждого элемента массива, принимает четыре аргумента:

  - **accumulator** - Аккумулятор, аккумулирующий значение, которое возвращает функция callback после посещения очередного элемента, либо значение initialValue, если оно предоставлено (смотрите пояснения ниже).

  - **currentValue** - Текущий обрабатываемый элемент массива.

  - **index** **Необязательный** - Индекс текущего обрабатываемого элемента массива.

  - **array****Необязательный** - Массив, для которого была вызвана функция reduce.

- **initialValue**
Необязательный параметр. Объект, используемый в качестве первого аргумента при первом вызове функции callback.

## Array.prototype.forEach()  
[_узнать больше_](https://developer.mozilla.org/ru/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach)


Метод forEach() выполняет указанную функцию один раз для каждого элемента в массиве.
### Синтаксис
```
arr.forEach(function callback(currentValue, index, array) {
//your iterator
}[, thisArg]);
```

### Параметры
- callback
Функция, которая будет вызвана для каждого элемента массива. Она принимает от одного до трёх аргументов:

  - currentValue
Текущий обрабатываемый элемент в массиве.

  - index Необязательный
Индекс текущего обрабатываемого элемента в массиве.

  - array Необязательный
Массив, по которому осуществляется проход.

- thisArg
Необязательный параметр. Значение, используемое в качестве this при вызове функции callback.

### Дополнительная информация: 
- [filter](https://developer.mozilla.org/ru/docs/Web/JavaScript/Reference/Global_Objects/Array/filter)
- [every](https://developer.mozilla.org/ru/docs/Web/JavaScript/Reference/Global_Objects/Array/every)
- [some](https://developer.mozilla.org/ru/docs/Web/JavaScript/Reference/Global_Objects/Array/some)

<img src="https://pbs.twimg.com/media/EwRkAk6XEAIs5Xu?format=jpg&name=4096x4096" width="1000">