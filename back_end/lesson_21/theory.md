Проект: пиццерия Tomate Pizza
=============================

## План работ, день #1

1. Обсуждение вариантов проекта, выбор варианты
2. Обсуждение структуры таблиц базы данных проекта
3. Создание доменных сущностей

## План работ, день #2

1. Обсуждение и создание доменных сущностей
2. Liquibase: заполнение db.changelog.xml

## План работ, день #3

1. Завершение changeSet #1 db.changelog.xml
2. Заполнение таблиц БД с помощью Liquibase
3. Оптимизация таблицы PizzaBase

## План работ, день #4 понедельник

1. Написание и обсуждение PizzaBaseController
2. Написание PizzaBaseService

## План работ, день #5 вторник

1. Обсуждение набора операций и структуры контроллеров
2. Дописываем PizzaBaseService
3. Написание PizzaSizeController + Service

## План работ, день #6 среда

1. Написание PizzaTypeController + Service
2. Написение IngredientController + Service
3. Обсуждение UserOrderController и начинаем его писать

## План работ, день #7 четверг

1. Разбираемся с ошибкой при работе UserOrderSevice.create
2. Переименовываем таблицы: user -> users, order -> orders
3. Пишем UserOrderController + UserOrderService

## План работ, день #8 пятница

1. Проверяем входные данных, используя Validate, [статья](https://medium.com/@skywalkerhunter/org-apache-commons-best-preconditions-validation-ouch-49b8a1f2fae9)
2. Возвращаем HTTP статусы из контроллеров, [статья](https://for-each.dev/lessons/b/-spring-response-entity)
3. Дописываем UserOrderController + UserOrderService
