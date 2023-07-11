// Задание 1
// Создайте стрелочную функцию, которая бы принимала массив и цифру, 
// возвращала бы элемент массива под этим индексом.

const getElementByIndex = (arr, index) => arr[index];
// вызов:
const res = getElementByIndex(["lime", "orange", "lemongrass"], 2);
console.log(res);

// Создайте функцию, которая бы принимала бы следующие параметры:

// код погоды
// функция decode, которая дает расшифровку погоды по коду.
// Функция должна возвращать строку, описывающую погоду.

const getWeatherDescription = function (code, decode) {
  return decode(code);
}

const decode = function (code) {
  switch (code) {
    case "SQ": return "Шквал";
    case "PO": return "Пыльный вихрь";
    case "BR": return "Дымка";
    case "HZ": return "Мгла";
    case "FU": return "Дым";
    case "SS": return "Песчаная буря";
    case "DS": return "Пылевая буря";
    default: return "No such code";
  }
}

const res1 = getWeatherDescription("BR", decode);
console.log(res1);
console.log(getWeatherDescription("OP", decode));
console.log(decode("BR"));
