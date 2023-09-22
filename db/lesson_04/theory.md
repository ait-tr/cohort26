### Подсчет ко-ва уникальных значений

```sql
COUNT(DISTINCT Suppliers.Country)
```

**Задача. Вывести ко-во товаров в заказе `10248` (по именованиям)**

```sql
SELECT
	COUNT(*) AS total_products
FROM OrderDetails

WHERE
	OrderID=10248
```

## Группировка в SQL (механизм агрегации) / оператор `GROUP BY`

**Категории запросов**

1. **CRUD** - простые запросы
2. **Aggregation** - получение вычисленных данных

**Группировка** - объединение записей на основе общего признака с целью получения обобщеных данных

**Пример. Вывести страны покупателей с количеством клиентов из каждой**

(количественное распределение клиентов по странам)

```sql
SELECT DISTINCT
	Country
FROM Customers

--
SELECT
		Country,
    COUNT(*) AS total_customers
FROM Customers

GROUP BY Country

ORDER BY total_customers DESC
```

**Пример. Статистика товаров по поставщикам**

```sql
SELECT
		SupplierID,
		AVG(Price) AS avg_price,
    COUNT(*) AS total_products
FROM Products

GROUP BY SupplierID
```

**Задача. Вывести кол/распределение товаров по категориям**

```sql
SELECT
	CategoryID,
	COUNT(*) AS total_products
FROM Products

GROUP BY CategoryID

ORDER BY total_products DESC

--
SELECT
	Categories.CategoryName,
	COUNT(*) AS total_products,
	AVG(Products.Price) AS avg_price

FROM Products

JOIN Categories ON Products.CategoryID=Categories.CategoryID
-- JOIN Categories USING(CategoryID)

GROUP BY Products.CategoryID

ORDER BY total_products DESC
```

## Ключевое слово `USING()` при горизонтальном объединении таблиц

- синтаксический сахар
- позволяет сократить код в случае столбцов с одним названием

## Некоторые виды `JOIN`

![Screenshot from 2023-09-22 20-50-08.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/ef826e45-d33b-428e-9f4b-241a4aedc7fa/Screenshot_from_2023-09-22_20-50-08.png)

**Задача. Вывести ТОП-3 менеджеров по ко-ву заказов (`фамилия_менеджера`, `ко-во_заказов`)**

```sql
SELECT 
	Employees.LastName,
	COUNT(*) AS total_orders

FROM Orders

JOIN Employees ON Employees.EmployeeID = Orders.EmployeeID

GROUP BY Employees.EmployeeID

ORDER BY total_orders DESC
LIMIT 3
-- LIMIT 1 OFFSET 1 второе место
```

**Задача. Вывести кол/распределение заказов по клиентам**

(проекция: `имя_клиента`, `ко-во_заказов`)

```sql
SELECT
		Customers.CustomerName,
    COUNT(*) AS total_orders
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID

GROUP BY Customers.CustomerID

ORDER BY total_orders DESC
```

**Задача. Вывести ТОП-1 компанию-перевозчика (и ко-во заказов) по количеству доставок**

(проекция: `название_компании`, `к-во_заказов`)

```sql
SELECT
		Shippers.ShipperName,
    COUNT(*) AS total_orders
FROM Orders

JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID

GROUP BY Orders.ShipperID

ORDER BY total_orders DESC
LIMIT 1
```

**Задача. Вывести ТОП-3 самых продаваемых товаров**

(проекция: `название_товара`, `ко_во_проданных_единиц`)

```sql
SELECT
	Products.ProductName,
	SUM(OrderDetails.Quantity) AS sold_count
	
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.ProductID

ORDER BY sold_count DESC
LIMIT 3
```

**Задача. Вывести стоимость каждого заказа в упорядоченном виде**

(проекция: `номер_заказа`, `сумма_заказа`)

```sql
SELECT
		OrderDetails.OrderID,
    SUM(OrderDetails.Quantity * Products.Price) AS order_cost

FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.OrderID

ORDER BY order_cost DESC
```

## Оператор `HAVING`

- аналог `WHERE`, который позволяет отфильтровать агрегированные данные

**Пример. Вывести заказы со стоимостью от `10000` (EUR)**

```sql
SELECT
		OrderDetails.OrderID,
    SUM(OrderDetails.Quantity * Products.Price) AS order_cost

FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.OrderID
HAVING
	order_cost >= 10000

ORDER BY order_cost DESC
```

**Задача. Вывести поставщиков, у которых средняя стоимость товара выше `40` EUR**

(проекция: `название_поставщика`, `сред_стоимость`)

```sql
SELECT 
		Suppliers.SupplierName,
		AVG(Products.Price) AS avg_price
FROM Products

JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID

GROUP BY Suppliers.SupplierID
HAVING
	avg_price > 40

ORDER BY avg_price DESC
```

### Пример схемы БД “онлайн-музыка”

- **Требования**
    - регистрация юзеров
    - прослушивание треков
    - создание и наполнение список воспроизведения
- **Примеры сущностей**
    - `users`
    - `tracks`
    - `playlists`

[Схема](https://dbdiagram.io/d/online_music-650ddbe4ffbf5169f053d851)