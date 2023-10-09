# DB #7 / Oct 6, 2023

![Screenshot from 2023-10-06 19-56-04.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/c6a54d19-dc30-4e71-8d58-7162e3bb0311/Screenshot_from_2023-10-06_19-56-04.png)

**Примеры запросов**

```jsx
// Вывести ко-во незаблокированных юзеров
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } },
    { $count: 'unblocked_users' }
])

// Вывести ко-во незаблокированных юзеров не из Germany
db.users.countDocuments(
    {
        is_blocked: { $ne: true },
        country: { $ne: 'Germany' }
    }
)

// Вывести ко-во роликов у автора 4
db.videos.countDocuments(
    { author_id: 4 }
)

// Вывести ко-во незаблокированных юзеров из USA и Germany
db.users.countDocuments(
    {
        is_blocked: { $ne: true },
        country: { $in: ['USA', 'Germany'] }
    }
)

// Вывести юзера, который находится на втором месте по балансу
db.users.aggregate([
    { $sort: { balance: -1 } },
    { $skip: 1 },
    { $limit: 1 }
])

// Вывести название и продолжительность видео, которое находится на третьем месте по продолжительности
db.videos.aggregate([
    { $sort: { duration_secs: -1 } },
    { $skip: 2 },
    { $limit: 1 },
    { $project: { title: 1, duration_secs: 1, _id: 0 } }
])

// Увеличить баланс на 1.5% юзерам из Germany и France
db.users.updateMany(
    { country: { $in: ['Germany', 'France'] } },
    { $mul: { balance: 1.015 } }
)

// Вывести видео-ролики, включая данные об их авторах
db.videos.aggregate([
    {
        $lookup: {
            from: 'users',
            localField: 'author_id',
            foreignField: '_id',
            as: 'author'
        }
    }
])
```

**Пример. Вывести юзеров, у которых есть видео-ролики**

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
    { $match: { videos: { $ne: [] } } }
])
```

**Пример. Используя метод `aggregate()`, вывести ко-во юзеров без видео-роликов**

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
    { $match: { videos: [] } },
    { $count: 'users_without_videos' }
])
```

## Группировка / оператор `$group`

- получает на входе документы
- объединяет их в группы по заданному **полю (или полям)** группуровки
- на выходе - один документ равен одному уникальному значению **поля группировки**

**Базовые операторы группировки (аккумуляторы)**

- `$sum`
- `$avg`
- `$min`
- `$max`
- `$count`

**Пример. Вывести кол/распределение юзеров по странам**

```jsx
db.users.aggregate([
    {
        $group: {
            _id: '$country', // поле группировки
            total_users: { $count: {} },
            avg_balance: { $avg: '$balance' }
        }
    }
])
```

**Пример. Вывести общее ко-во юзеров**

```jsx
db.users.aggregate([
    {
        $group: {
            _id: null, // поле группировки
            total_users: { $count: {} },
            avg_balance: { $avg: '$balance' }
        }
    }
])
```

**Задача. Вывести среднюю продолжительность всех роликов**

```jsx
db.videos.aggregate([
    {
        $group: {
            _id: null, // поле группировки
            avg_duration: { $avg: '$duration_secs' }
        }
    }
])
```

**Задача. Вывести статистику по всех роликам (по продолжительности)**

```jsx
db.videos.aggregate([
    {
        $group: {
            _id: null,
            avg_duration: { $avg: '$duration_secs' },
            total_duration: { $sum: '$duration_secs' },
            min_duration: { $min: '$duration_secs' },
            max_duration: { $max: '$duration_secs' },
            count_videos: { $count: {} }
        }
    }
])
```

**Задача. Вывести одного автора роликов, у которого самая высокая средняя продолжительность, включая имя автора**

```jsx
db.videos.aggregate([
    {
        $group: {
            _id: '$author_id',
            avg_duration: { $avg: '$duration_secs' }
        }
    },
    { $sort: { avg_duration: -1 } },
    { $limit: 1 }, 
    {
        $lookup: {
            from: 'users',
            localField: '_id',
            foreignField: '_id',
            as: 'author'
        }
    }
])
```

**Задача. Вывести ролики продолжительностью до `1` часа, включая имя автора**

```jsx
db.videos.aggregate([
    {
        $match: {
            duration_secs: { $lte: 60 * 60 }
        }
    },
    {
        $lookup: {
            from: 'users',
            localField: 'author_id',
            foreignField: '_id',
            as: 'author'
        }
    }
])
```

## Оператор агрегации `$unwind`

- позволяет “развернуть” массив (отказаться от массива)

```jsx
{ $unwind: '$author' }
```

**Пример**

```jsx
db.videos.aggregate([
    {
        $lookup: {
            from: 'users',
            localField: 'author_id',
            foreignField: '_id',
            as: 'author'
        }
    },
    { $unwind: '$author' },
    {
        $project: {
            _id: 0,
            duration_secs: 1,
            author_fullname: '$author.fullname'
        }
    }
])
```

**Пример. Добавить несколько реакций (на видео)**

```jsx
db.reactions.insertMany([
    { video_id: 1, author_id: 1, value: 5 },
    { video_id: 2, author_id: 2, value: 2 },
    { video_id: 3, author_id: 3, value: 1 },
    { video_id: 4, author_id: 4, value: 5 },
    { video_id: 5, author_id: 5, value: 3 },
    { video_id: 2, author_id: 1, value: 5 },
    { video_id: 2, author_id: 1, value: 4 },
    { video_id: 4, author_id: 2, value: 4 },
    { video_id: 4, author_id: 4, value: 2 },
    { video_id: 1, author_id: 4, value: 3 },
    { video_id: 1, author_id: 3, value: 3 }
])
```

**Задача. Вывести самый рейтинговый ролик**

(проекция: `название_ролика`, `ср/оценка`)

```jsx
db.reactions.aggregate([
    {
        $group: {
            _id: '$video_id',
            rating: { $avg: '$value' }
        }
    },
    { $sort: { rating: -1 } },
    { $limit: 1 },
    {
        $lookup: {
            from: 'videos',
            localField: '_id',
            foreignField: '_id',
            as: 'video'
        }
    },
    { $unwind: '$video' },
    {
        $project: {
            _id: 0,
            rating: 1,
            video_title: '$video.title'
        }
    }
])
```

**Задача. Вывести реакции со значением от трех (три и более)**

(проекции: `название_ролика`, `имя_автора_реакции`, `значение_реакции`)

```jsx
db.reactions.aggregate([
    { $match: { value: { $gte: 3 } } },
    {
        $lookup: {
            from: 'videos',
            localField: 'video_id',
            foreignField: '_id',
            as: 'video'
        }
    },
    {
        $lookup: {
            from: 'users',
            localField: 'author_id',
            foreignField: '_id',
            as: 'author'
        }
    },
    { $unwind: '$video' },
    { $unwind: '$author' },
    {
        $project: {
            _id: 0,
            video_title: '$video.title',
            author_fullname: '$author.fullname',
            value: 1
        }
    }
])
```

## Повторение `SQL`

**Задача. Вывести страны поставщиков**

```sql
SELECT DISTINCT
	Country
FROM Suppliers
```

**Задача. Вывести имена клиентов из `Germany` и `France`**

```sql
SELECT 
	CustomerName
FROM Customers

WHERE
	Country IN ('Germany', 'France')
```

**Задача. Вывести товары с ценой от `10` до `150` EUR**

```sql
SELECT * 
FROM Products

WHERE
	Price BETWEEN 10 AND 150
```

**Задача. Вывести два самых дорогих товара из категории `4`**

```sql
SELECT *
FROM Products

WHERE
    CategoryID = 4

ORDER BY Price DESC
LIMIT 2
```

**Задача. Вывести ко-во товаров из категории `4`**

```sql
SELECT 
	COUNT(*) AS total_products
FROM Products

WHERE
	CategoryID = 4
```

**Задача. Очистить телефоны у компаний-перевозчиков**

```sql
UPDATE Shippers
SET
	Phone=''
```

**Задача. Удалить поставщиков из `UK`**

```sql
DELETE FROM Suppliers
WHERE
	Country='UK'
```

**Задача. Вывести среднюю стоимость товара для каждого поставщика**

```sql
SELECT
		SupplierID,
    AVG(Price) AS avg_price
FROM Products

GROUP BY SupplierID
```