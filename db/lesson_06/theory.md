![Screenshot from 2023-10-04 19-51-33.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/208add3f-b31c-4272-b83a-f63e4b7cd1fe/Screenshot_from_2023-10-04_19-51-33.png)

## Метод `countDocuments()`

- **возвращает ко-во совпадений (целое число)**
- аргументы
    - `filter`

**Пример. Вывести общее ко-во юзеров**

```jsx
db.users.countDocuments({})
```

**Пример. Вывести ко-во юзеров из `USA`**

```jsx
db.users.countDocuments(
    { country: 'USA' }
)
```

**Задача. Вывести ко-во незаблокированных юзеров не из `Germany`**

```jsx
db.users.countDocuments(
    {
        is_blocked: { $ne: true },
        country: { $ne: 'Germany' }
    }
)
```

**Задача. Написать пример запроса на аутентификацию юзера**

```jsx
db.users.countDocuments(
    {
        email: email,
        password: password,
        is_blocked: { $ne: true }
    }
)
```

**Задача. Вывести ко-во роликов у автора `4`**

```jsx
db.videos.countDocuments(
    { author_id: 4 }
)
```

**Задача. Вывести ко-во незаблокированных юзеров из `USA` и `Germany`**

```jsx
db.users.countDocuments(
    {
        is_blocked: { $ne: true },
        country: { $in: ['USA', 'Germany'] }
    }
)
```

**Задача. Вывести имена юзеров не из `France`**

```jsx
db.users.find(
    { country: { $ne: 'France' } }, // filter
    { fullname: 1, _id: 0 } // projection
)
```

**Задача. Вывести названия роликов `3` и `4`**

```jsx
db.videos.find(
    { _id: { $in: [3, 4] } },
    { _id: 0, title: 1 }
)
```

**Задача. Вывести ко-во незаблокированных юзеров не из `China` с положительным балансом**

```jsx
db.users.countDocuments(
    {
        is_blocked: { $ne: true },
        country: { $ne: 'China' },
        balance: { $gt: 0 }
    }
)
```

**Задача. Разблокировать юзеров из `China` и увеличить им баланс на `50` EUR**

```jsx
db.users.updateMany(
    { country: 'China' }, // filter
    { // action
        $unset: { is_blocked: null },
        $inc: { balance: 50 }
    }
)
```

**Задача. Увеличить баланс на `1.5%` юзерам из `Germany` и `France`**

```jsx
db.users.updateMany(
    { country: { $in: ['Germany', 'France'] } },
    { $mul: { balance: 1.015 } }
)
```

## MongoDB Aggregation Framework

- позволяет получить вычисленные данные
- инструмент для анализа, обработки данных
- реализуется методом `aggregate()`
- представляет конвеер (`pipeline`), который содержит определенные этапы обработки (`stages`)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/504d4e06-4d78-474d-85b7-670bd1d4954b/Untitled.png)

## Метод `aggregate()`

- аргументы
    - (1) массив этапов обработки (`pipeline`, конвеер)

**Пример. Вывести всех юзеров**

```jsx
db.users.aggregate()
```

## Основные стадии (этапы, stages) обработки - операторы

- `$match` фильтрация
- `$sort` сортировка
    - `-1` по убыванию
    - `1` по возрастанию
- `$project` проекция
- `$limit` лимитирование
- `$skip` пропустить (документы)
- `$group` группировка
- `$lookup` объединение коллекций
- `$addFields` добавить поля
- `$sample` получить произвольные документы
- `$count` возвращает ко-во документов

**Пример. Работа с видео и юзерами**

```jsx
// вывести все ролики
db.videos.aggregate()

// вывести ролики продолжительностью от 3 мин
db.videos.aggregate([
    {
        $match: { duration_secs: { $gte: 3 * 60 } }
    }
])

// вывести незаблокир. юзеров
db.users.aggregate([
    {
        $match: {
            is_blocked: { $ne: true }
        }
    }
])

// вывести всех юзеров по убыванию баланса
db.users.aggregate([
    {
        $sort: { balance: -1 }
    }
])

// вывести ТОП-3 юзеров по макс. балансу
db.users.aggregate([
    {
        $sort: { balance: -1 }
    },
    { $limit: 3 }
])
```

**Задача. Вывести одного незаблокированного юзера с минимальным балансом**

```jsx
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } }, // фильтрация
    { $sort: { balance: 1 } }, // сортировка (по возраст.)
    { $limit: 1 } // лимитирование
])
```

**Пример. Вывести имена юзеров**

```jsx
db.users.aggregate([
    {
        $project: { fullname: 1, _id: 0 }
    }
])
```

**Задача. Вывести баланс и имя юзера `1`**

```jsx
db.users.aggregate([
    { $match: { _id: 1 } },
    { $project: { fullname: 1, balance: 1, _id: 0 } }
])
```

**Задача. Вывести названия роликов `1, 3, 5`**

```jsx
db.videos.aggregate([
    { $match: { _id: { $in: [1, 3, 5] } } },
    { $project: { title: 1, _id: 0 } }
])
```

**Задача. Вывести имена юзеров с балансом от `10` до `1000` EUR**

```jsx
db.users.aggregate([
    { $match: { balance: { $gte: 10, $lte: 1000 } } },
    { $project: { fullname: 1, _id: 0 } }
])
```

**Пример. Вывести юзера, который находится на втором месте по балансу**

```jsx
db.users.aggregate([
    { $sort: { balance: -1 } },
    { $skip: 1 },
    { $limit: 1 }
])
```

**Задача. Вывести название и продолжительность видео, которое находится на третьем месте по продолжительности**

```jsx
db.videos.aggregate([
    { $sort: { duration_secs: -1 } },
    { $skip: 2 },
    { $limit: 1 },
    { $project: { title: 1, duration_secs: 1, _id: 0 } }
])
```

**Пример. Вывести один произвольный видео-ролик**

```jsx
db.videos.aggregate([
    {
        $sample: { size: 1 }
    }
])
```

**Задача. Вывести имя одного произвольного незаблокированного юзера**

```jsx
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } },
    { $sample: { size: 1 } },
    { $project: { fullname: 1, _id: 0 } }
])
```

**Пример. Вывести ко-во незаблокированных юзеров**

```jsx
// вар. 1
db.users.countDocuments(
    { is_blocked: { $ne: true } } // filter
)

// вар. 2
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } },
    { $count: 'unblocked_users' }
])
```

**Задача. Вывести ко-во юзеров из `USA` и `Germany` с балансом от `10` EUR, используя метод `aggregate()`**

```jsx
db.users.aggregate([
    {
        $match: {
            country: { $in: ['USA', 'Germany'] },
            balance: { $gte: 10 }
        }
    },
    { $count: 'users_count' }
])
```

**Пример. Вывести видео-ролики, включая данные об их авторах**

```jsx
db.videos.aggregate([
    {
        $lookup: {
            from: 'users', // название коллекции
            localField: 'author_id', // поле из тек/кол
            foreignField: '_id', // поле из внеш/кол
            as: 'author' // куда поместить результат
        }
    }
])
```

**Пример. Добавить нового юзера**

```jsx
db.users.insertOne({
    _id: 6,
    fullname: 'No Videos User',
    country: 'France'
})
```

**Задача. Необходимо вывести юзеров, у которых отсутствуют видео**

```jsx
db.users.aggregate([
    {
        $lookup: {
            from: 'videos',
            localField: '_id',
            foreignField: 'author_id',
            as: 'videos'
        }
    },
    { $match: { videos: [] } }
])
```