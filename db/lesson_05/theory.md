## MongoDB GUI Client

[Download Studio 3T for MongoDB | Windows, macOS & Linux](https://studio3t.com/download/)

## `URI` для подключения

```jsx
mongodb+srv://ab:Os9yUOqHKfxhKO0M@cluster0.u54vil2.mongodb.net/admin?retryWrites=true&replicaSet=atlas-qut493-shard-0&readPreference=primary&srvServiceName=mongodb&connectTimeoutMS=10000&authSource=admin&authMechanism=SCRAM-SHA-1&3t.uriVersion=3&3t.connection.name=atlas-qut493-shard-0&3t.databases=admin&3t.alwaysShowAuthDB=true&3t.alwaysShowDBFromUserRole=true&3t.sslTlsVersion=TLS
```

## Принципиальные отличия MongoDB от RDBMS

1. Другой язык для выполнения запросов (`NoSQL - QUERY API`)
2. Модель данных - **ДОКУМЕНТНАЯ** (документ - ассоц/массив)
3. Использует `JSON` и Binary `JSON` (`BSON`)
4. Динамическая схема данных (без схемы, `schemaless`) - каждый документ может иметь свой набор полей
5. Позволяет хранить вложенные структуры данных

## Базовые структуры данных

1. Скаляр (скалярное значение)
2. Массив (список значений)
3. Ассоц/массив (пары ключ/значение)
4. Множество (список **уникальных** элементов)

```jsx
// пример
users = [
	{username: 'hacker', email: '123@example.org', is_blocked: true},
	{username: 'user1', email: 'hello@example.org', phone: '+0000000000'}
]
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/79708bc2-898c-4f92-8a14-7841622892d1/Untitled.png)

## Категории запросов

1. `CRUD` - более простые запросы
2. Aggregation - получение вычисленных данных

## MongoDB: CRUD

**Create**

- `insertOne()` добавить один документ
    - один аргумент
        - ассоц/массив (объект)
- `insertMany()` добавить несколько документов
    - один аргумент
        - массив ассоц/массивов

**Read**

- `findOne()`  найти (выбрать) один документ
- `find()` найти (выбрать) несколько документов
    - аргументы
        - `filter`
        - `projection`
- `countDocuments()` ко-во совпадений
    - аргументы
        - `filter`

**Update**

- `updateOne()` изменить один документ
- `updateMany()` изменить несколько документов
    - аргументы
        - `filter`
        - `action`

**Delete**

- `deleteOne()` удалить один документ
- `deleteMany()` удалить несколько документов
    - аргументы
        - `filter`

## БД `videohosting` сервис хранения и воспроизведения видео

**Основные сущности**

- `users`
- `videos`

**Пример. Добавление юзеров**

```jsx
db.users.insertMany([
    { _id: 1, fullname: 'Ivan Ivanov', country: 'Germany' },
    { _id: 2, fullname: 'Petr Ivanov', country: 'USA' },
    { _id: 3, fullname: 'Sidr Ivanov', country: 'Germany' },
    { _id: 4, fullname: 'hacker', country: 'USA' },
    { _id: 5, fullname: 'noname', country: 'France' }
])
```

**Пример. Вывести всех юзеров**

```jsx
db.users.find()
```

**Пример. Вывести юзеров из `Germany`**

```jsx
db.users.find(
    { country: 'Germany' } // filter
)

// с проекцией
db.users.find(
    { country: 'Germany' }, // filter
    { fullname: 1, _id: 0 } // projection
)

// с проекцией
db.users.find(
    { country: 'Germany' }, // filter
    { country: 0 } // projection
)
```

**Задача. Вывести имена юзеров из `USA`**

```jsx
db.users.find(
    { country: 'USA' }, // filter
    { fullname: 1, _id: 0 } // projection
)
```

**Задача. Вывести страну юзера `1`**

```jsx
db.users.findOne(
    { _id: 1 },
    { country: 1, _id: 0 }
)
```

**Задача. Вывести всех юзеров (кроме поля `_id`)**

```jsx
db.users.find(
    {},
    { _id: 0 }
)
```

**Задача. Добавить пять видео-роликов (`videos`)**

```jsx
db.videos.insertMany([
    { _id: 1, title: 'Video 1', duration_secs: 5 * 60, author_id: 1 },
    { _id: 2, title: 'Video 2', duration_secs: 4 * 60, author_id: 2 },
    { _id: 3, title: 'Video 3', duration_secs: 6 * 60, author_id: 3 },
    { _id: 4, title: 'Video 4', duration_secs: 7 * 60, author_id: 4 },
    { _id: 5, title: 'Video 5', duration_secs: 9 * 60, author_id: 5 }
])
```

**Задача. Вывести название и продолжительность видео `4`**

```jsx
db.videos.findOne(
    { _id: 4 },
    { title: 1, duration_secs: 1, _id: 0 }
)
```

**Задача. Вывести все видео юзера `2` (кроме поля `author_id`)**

```jsx
db.videos.find(
    { author_id: 2 },
    { author_id: 0, _id: 0 }
)
```

## Операторы сравнения

`$eq` равно (equal)

`$ne` не равно (not equal)

`$gt` больше (greater than)

`$gte` больше или равно (greater than or equal)

`$lt` меньше (less than)

`$lte` меньше или равно (less than or equal)

`$in` проверка принадлежности к списку значений

`$nin` не принадлежит списку значений

**Пример. Вывести видео с продолжительностью от `5` мин**

```jsx
db.videos.find(
    { duration_secs: { $gte: 5 * 60 } }
)
```

**Задача. Вывести видео продолжительностью до одного часа (включительно)**

(проекция: `название`, `продолжительность`)

```jsx
db.videos.find(
    { duration_secs: { $lte: 60 * 60 } },
    { title: 1, duration_secs: 1, _id: 0 }
)
```

**Задача. Вывести видео продолжительностью от `2` до `10` мин**

```jsx
db.videos.find(
    { duration_secs: { $gte: 2 * 60, $lte: 10 * 60 } }
)
```

**Пример. Вывести юзеров из `Germany` и `France`**

```jsx
db.users.find(
    { country: { $in: ['Germany', 'France'] } }
)
```

**Задача. Вывести имена всех юзеров, кроме тех, что из `USA` и `Germany`**

```jsx
db.users.find(
    { country: { $nin: ['USA', 'Germany'] } },
    { fullname: 1, _id: 0 }
)
```

## Базовые операторы модификации (`updateOne` / `updateMany()`)

`$set` установить поля

`$unset` удалить (снять) поля

`$inc` инкремент полей (увеличить/уменьшить)

`$mul` умножение

**Пример. Заблокировать юзеров из `France`**

```jsx
db.users.updateMany(
    { country: 'France' }, // filter
    { $set: { is_blocked: true } } // action
)
```

**Задача. Вывести имена всех заблокированных юзеров**

```jsx
db.users.find(
    { is_blocked: true },
    { fullname: 1, _id: 0 }
)
```

**Задача. Вывести незаблокированных юзеров**

```jsx
db.users.find(
    { is_blocked: { $ne: true } }
)
```

**Задача. Вывести всех незаблокированных юзеров не из `Germany`**

```jsx
db.users.find(
    {
        is_blocked: { $ne: true },
        country: { $ne: 'Germany' }
    }
)
```

**Пример. Разблокировать всех юзеров**

```jsx
db.users.updateMany(
    {},
    { $unset: { is_blocked: null } }
)
```

**Задача. Заблокировать юзера `1` и установить ему произвольный `email`**

```jsx
db.users.updateOne(
    { _id: 1 },
    {
        $set: {
            is_blocked: true,
            email: ''
        }
    }
)
```

**Пример. Разблокировать юзера `1` и установить ему произвольный `email`**

```jsx
db.users.updateOne(
    { _id: 1 },
    {
        $set: { email: '' },
        $unset: { is_blocked: null }
    }
)
```

**Пример. Увеличить баланс юзерам из `USA` на `100` (EUR)**

```jsx
db.users.updateMany(
    { country: 'USA' },
    { $inc: { balance: 100 } }
)
```

**Задача. Разблокировать юзеров из `Germany` и увеличить их баланс на `50` (EUR)**

```jsx
db.users.updateMany(
    { country: 'Germany' },
    {
        $inc: { balance: 50 },
        $unset: { is_blocked: null }
    }
)
```

**Задача. Вывести незаблокированных юзеров с положительным балансом**

```jsx
db.users.find(
    {
        is_blocked: { $ne: true },
        balance: { $gt: 0 }
    }
)
```

**Задача. Увеличить баланс всех юзеров, кроме тех, что из `China`, на `200` EUR**

```jsx
db.users.updateMany(
    { country: { $ne: 'China' } },
    { $inc: { balance: 200 } }
)
```

**Задача. Уменьшить баланс всех юзеров на `1%`**

```jsx
db.users.updateMany(
    {},
    { $mul: { balance: .99 } }
)
```

## Ссылка

- [онлайн-генератор хешей](https://emn178.github.io/online-tools/sha3_224.html)
- [хеширование паролей](https://www.kaspersky.ru/blog/the-wonders-of-hashing/3633/)