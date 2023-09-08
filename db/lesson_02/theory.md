**Задача. Вывести номер и дату предпоследнего заказа**

```sql
SELECT
		OrderID,
    OrderDate
FROM Orders

ORDER BY OrderDate DESC
LIMIT 1 OFFSET 1
```

**Задача. Вывести три самых дешевых товара из категории `4` с ценой от `20` EUR**

```sql
SELECT *
FROM Products

WHERE
		CategoryID = 4
    AND
    Price >= 20

ORDER BY Price ASC
LIMIT 3
```

## SQL: CRUD

- **Create**
    - `INSERT INTO`
- **Read**
    - `SELECT`
    - `SELECT DISTINCT`
- **Update**
    - `UPDATE`
- **Delete**
    - `DELETE FROM`
        
        ![Screenshot from 2023-09-08 20-14-26.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/5065cf15-52f4-4190-938a-2cb31062f04e/Screenshot_from_2023-09-08_20-14-26.png)
        
    
    ## Поиск по шаблону / Оператор `LIKE`
    
    - поиск по нестрогому соответствию
    
    **Базовые подстановочные символы (знаки)**
    
    - `%` нулевой, один или несколько символов
    - `_` один симво
    
    **Примеры**
    
    ```sql
    SELECT *
    FROM Customers
    WHERE
    	Country LIKE 'usa'
    ```
    
    ```sql
    SELECT *
    FROM Suppliers
    WHERE
    	Phone LIKE '%555%'
    ```
    
    ```sql
    SELECT *
    FROM Employees
    WHERE
    	LastName LIKE '%lio%'
    ```
    
    **Задача. Вывести имена и фамилии сотрудников, у которых в имени или фамилии есть вхождение строки `drew`**
    
    ```sql
    SELECT
    		FirstName,
        LastName
    FROM Employees
    
    WHERE
    		FirstName LIKE '%drew%'
        OR
        LastName LIKE '%drew%'
    ```
    
    **Задача. Вывести сотрудников, у которых имена начинаются на букву `a`**
    
    ```sql
    SELECT *
    FROM Employees
    
    WHERE
    		FirstName LIKE 'a%'
    ```
    

## SQL CRUD: Delete / удаление записей / Оператор `DELETE FROM`

**Пример. Удалить указанных клиентов**

```sql
DELETE FROM Customers
WHERE
	CustomerID IN (2, 3)
```

**Задача. Удалить товары, которые дешевле `5` EUR**

```sql
DELETE FROM Products
WHERE
	Price < 5
```

## SQL CRUD: Update / модификация / Оператор `UPDATE`

**Пример**

```sql
-- очистить указанные поля у клиентов 1, 2, 3
UPDATE Customers
SET
		Country='',
    City=''
WHERE
	CustomerID IN (1, 2, 3)
```

**Задача. Для поставщиков из `Japan` и `Spain` изменить телефон и контактное имя на произвольные значения**

```sql
UPDATE Suppliers
SET
	ContactName='Ivan Ivanov',
	Phone='0000000000'
WHERE
	Country IN ('Japan', 'Spain')
```

**Пример. Применить постоянную скидку к товарам в `10%`**

```sql
UPDATE Products
SET
	Price = Price * .9
```

**Задача. Увеличить стоимость товаров из категорий `2, 4, 6` на `15.5%`**

```sql
UPDATE Products
SET
	Price = Price * 1.155
WHERE
	CategoryID IN (2, 4, 6)
```

## SQL CRUD: Create / добавление / Оператор `INSERT INTO`

**Пример**

```sql
INSERT INTO Shippers (ShipperName)
VALUES
		('Shipper X'),
    ('Shipper Y')

--
INSERT INTO Shippers (ShipperName, Phone)
VALUES
		('Shipper X', ''),
    ('Shipper Y', '')
```

**Задача. Добавить произвольного поставщика из `China`**

```sql
INSERT INTO Suppliers (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
VALUES 
	('XYZ Company', NULL, NULL, NULL, NULL, 'China', NULL);
```

## Ключевые поля

- первичный ключ (`PRIMARY KEY`)
- внешний ключ (`FOREIGN KEY`)

## Горизонтальное объединение таблиц / Оператор `JOIN`

- синтаксис JOIN

```sql
SELECT <проекция>
FROM <таблица_1>
JOIN <таблица_2> ON <таблица_1.внешний_ключ>=<таблица_2.первичный_ключ>
```

**Примеры**

```sql
SELECT *
FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
```

```sql
SELECT
	Products.ProductName,
	Products.Price,
	Suppliers.SupplierName
FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
```

```sql
SELECT *
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID
JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID
JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID
```

**Задача. Вывести данные о заказах клиентов из `Germany`**

```sql
SELECT *
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID

WHERE
	Customers.Country='Germany'
```

**Задача. Вывести данные о товарах**
(проекция: `название_товара`, `цена_товара`, `название_категории`)

```sql
SELECT
    Products.ProductName,
    Products.Price,
    Categories.CategoryName
FROM Products

JOIN Categories ON Products.CategoryID=Categories.CategoryID
```

**Задача. Вывести все заказы, которые повезет `Speedy Express`**

```sql
SELECT * 
FROM Orders

JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID
****
WHERE
	Shippers.ShipperName='Speedy Express'
```

**Задача. Вывести заказы клиентов из `USA`, `Germany`, `UK`**

- `номер_заказа`
- `полное_имя_клиента`
- `страна_клиента`
- `имя_и_фамилия_менеджера`

```sql
SELECT
	Orders.OrderID,
	Customers.CustomerName,
	Customers.Country,
	Employees.FirstName,
	Employees.LastName 

FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID
JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID
****
WHERE
	Customers.Country IN ('Germany', 'UK', 'USA');
```

**Задача. Вывести страны-поставщики морепродуктов (кто из стран поставляет морепродукты)**

```sql
SELECT DISTINCT
	Suppliers.Country

FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
JOIN Categories ON Products.CategoryID=Categories.CategoryID

WHERE
	Categories.CategoryName='Seafood'
```