REST API
========

REST (от англ. Representational State Transfer — «передача репрезентативного состояния» или «передача „самоописываемого“ состояния»)

Основные свойства REST API

- Идентификация ресурсов с помощью URL(Resource identification). Каждый ресурс идентифицирется с помощью URL, который используется для доступа
    - https://myservice.example.com/users/1
    - https://api.zoom.us/v2/meetings/1
    - https://deezerdevs-deezer.p.rapidapi.com/album/12

- Единообразие интерфейса(Uniform interface). Для операций над ресурсами используются стандартные методы HTTP дя того чтобы сделать CRUD(Create, Read, Update, Delete) операции.
    - GET https://myservice.example.com/comments/15 - Read - получить комментарий с ID=14
    - DELETE https://myservice.example.com/comments/17 - Delete - удалить комментарий с ID=17
    - POST https://myservice.example.com/comments/ - Create - создать комментарий
    - PUT/PATCH https://myservice.example.com/comments/14 - Update - обновить комментарий
- Отсутствие состояния(Statelessness). REST API не поддерживает состояние между запросами. Каждый запрос от клиента содержит полную информацию необходимую для запроса

- Манипуляция ресурсами через представление(Representations). У клиента должно быть полное представление(все данные) для манипулации с объектом. ```{"user_id": 12, "usename": "exampleuser" }```
- Возможность использовать кэширование(Cacheability). Ответы с сервера могут быть закэшированы для более быстрого ответа.

**Это не все принципы, а те, что я посчитал ключевыми**. Остальные можно найти в статьях.

**Ресурсы**. Комментарий, пользователь или другая сущность в вашем проекте - ресурс. На него можно ссылаться с помощью URL 

## Заметки

- REST — это концепция, парадигма, но не протокол. В отличие от HTTP, который действительно является протоколом.
- Вам не нужна библитека чтобы работать с REST API
- REST на практите работает поверх HTTP
- Данные можно представить разными способами, но будем использовать JSON как самый популярный

Пример:

```
Endpoint: /posts/{post_id}/comments
Methods:

    GET: Retrieve a list of all comments for the post with the given post ID.
    POST: Create a new comment for the post with the given post ID.

Endpoint: /posts/{post_id}/comments/{comment_id}
Methods:

    GET: Retrieve the comment with the given comment ID for the post with the given post ID.
    PUT: Update the comment with the given comment ID for the post with the given post ID.
    DELETE: Delete the comment with the given comment ID for the post with the given post ID.

Endpoint: /users/{user_id}/comments
Methods:

    GET: Retrieve a list of all comments posted by the user with the given user ID.
    POST: Create a new comment by the user with the given user ID.

Endpoint: /users/{user_id}/comments/{comment_id}
Methods:

    GET: Retrieve the comment with the given comment ID posted by the user with the given user ID.
    PUT: Update the comment with the given comment ID posted by the user with the given user ID.
    DELETE: Delete the comment with the given comment ID posted by the user with the given user ID.
```

Примеры коммерческих API

- https://developer.twitter.com/en/docs/api-reference-index
- https://rapidapi.com/deezerdevs/api/deezer-1
- https://developers.zoom.us/docs/api/

## Практика

- @RequestMapping
    - @GetMapping
    - @PostMapping
    - @PutMapping
    - @DeleteMaping
- @ResponseBody
- @RestController


## CURL

При запуске может быть ошибка

>curl: (3) URL using bad/illegal format or missing URL

Убедитесь, что вы вызываете curl из git bash.

```sh
# List - GET
curl -X GET  http://localhost:8080/events

# Read - GET
curl -X GET  http://localhost:8080/events/1

# Create - POST
curl -H "Content-Type: application/json" -X POST -d '{"name" : "party", "city": "BAr" }' http://localhost:8080/events

# Delete - DELETE
curl -X DELETE  http://localhost:8080/events/1

# Update - PUT
curl -H "Content-Type: application/json" -X PUT -d '{"name" : "party", "city": "BAr" }' http://localhost:8080/events/1
```

