// Повторим spread массива
const fruits = ["apple", "orange", 'lime'];
const newFruits = [...fruits, "banana"];

// Spread объекта 
const fruit = { title: "orange", color: "yellow", weight: 200 };
console.log(fruit);
// { title: 'orange', color: 'yellow', weight: 200 }
// скопировали все ключи у fruit и добавили новый ключ country со значением "Maroco"
const specialOrange = { ...fruit, country: "Maroco" };
console.log(specialOrange);
// { title: 'orange', color: 'yellow', weight: 200, country: 'Maroco' }

// скопируем апельсин, заменим цвет на красный
const redOrange = { ...fruit, color: "red" };
console.log(redOrange); // { title: 'orange', color: 'red', weight: 200 }


// Объединим эти две темы и используем метод map со спредом

const cars = [
  { color: "black", brand: "Mercedes" },
  { color: "green", brand: "Mercedes" },
  { color: "blue", brand: "Porsche" },
  { color: "yellow", brand: "Porsche" }
]

// хочу создать новый массив, где заменить цвет у всех порше на red 
const newCars = cars.map((car) => {
  if (car.brand === "Porsche") {
    return { ...car, color: "red" }
  }
  return { ...car };
});

console.log(newCars);
newCars[0].color = "purple";
// если мутировали элемент нового массива
// старый остался нетронутым
console.log(newCars);
console.log(cars);

// 
const panda = { name: "Po", age: 18 };
const newPanda = panda;
newPanda.name = "Vladimir";
console.log(panda);    //  поменялось
console.log(newPanda); //  поменялось 
// переменные содеражат ссылку на один и тот же объект

const giraffe = { name: "Simon", age: 46 };
const newGiraffe = { ...giraffe };
newGiraffe.name = "Melman";
console.log(giraffe);    // имя осталось прежним 
console.log(newGiraffe); // имя изменилось 
// в примере с жирафами у нас два разных объекта 