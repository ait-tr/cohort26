// Destructuring assignment 
// вспомним про массив 
const brothers = [
  { race: "hobbit", height: 110, age: 45, name: "Frodo Baggins" },
  { race: "human", height: 185, age: 46, name: "Aragorn" },
  { race: "elf", height: 189, age: 110, name: "Legolas" },
  { race: "dworf", height: 140, age: 150, name: "Gimly" },
  { race: "human", height: 195, age: 200, name: "Gandalf" }
];

// const frodo = brothers[0];
// const aragorn = brothers[1];
//...
const [frodo, aragorn, legolas, gimly, gandalf] = brothers;
console.log(frodo); // { race: 'hobbit', height: 110, age: 45, name: 'Frodo Baggins' }

// теперь у нас есть объект фродо 
// как сохранить возраст фродо в отдельную переменную:
const ageOfFrodo = frodo.age; // достали по ключу
console.log(ageOfFrodo); // 45

const { race, age, name, noSuchKey } = frodo;
console.log(race);      // hobbit
console.log(name);      // Frodo Baggins
console.log(age);       // 45
console.log(noSuchKey); // undefined
// создаем переменную с таким именем как имя ключа - 
// и с такми значением как то, которое хранилось под этим ключом

const user = { id: 1, email: "user@mail.com", login: "funny_user" };
// const email = user.email;
const { email, id, login } = user; 
console.log(email); // user@mail.com