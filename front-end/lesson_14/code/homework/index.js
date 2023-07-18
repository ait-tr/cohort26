// - Создайте метод getStudent, 
// который возвращает promise - объекта (студент с именем "Anri" и возрастом 32), 
// c задержкой 4 секунды.
// - Вызовите этот метод - сохраните в переменную.
// - Раскройте promise при помощи then, выведите имя студента.  

const { fail } = require("yargs");

function getStudent() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve({ name: "Anri", age: 32 });
    }, 4000)
  });
}

let x;

getStudent().then((student) => {
  // нам доступно значение только внутри колбека - это не очень удобно 
  // снаружи колбека будет undefined
  console.log(student.name); //  Anri
  x = student.name;
  console.log("внутри колбека", x); // выведется вторым - Anri
});

console.log("снаружи колбека", x); // выведется первым - undefined

// Второе задание 
// - Напишите функцию getDriverLicence, которая принимает в себя два аргумента success и failure.
// - Сделайте внутри этой функции проверку: если выпадет какое-то число, которое будет > 0.1, 
// то вызовется success со строкой "успех!". В иных случаях вызови failure со строкой "упс, неудача :("
// - Подсказка: используйте Math.random()
// - Ниже, под этой функцией, опишите аргументы success и failure, которые, в свою очередь, тоже являются функциями.
// - Функция success принимает в себя аргумент, например result,
//  и выводит в консоль текст "Успешно завершено с результатом (и указать, каким результатом)".
// - Функция failure принимает в себя аргумент, например error, 
// и выводит в консоль текст "Завершено с ошибкой(и указать, какой ошибкой)".
// - Ниже вызвать функцию getDriverLicence, передав в нее аргументами две другие функции.

function getDriverLicense(success, failure) {
  if (Math.random() > 0.1) {
    success("успех");
  } else {
    failure("Упс, неудача");
  }
}

function success(result) {
  console.log(`Успешно завершено с результатом ${result}`);
}

function failure(error){
  console.log(`Завершено с ошибкой: ${error}`);
}

getDriverLicense(success, failure);
